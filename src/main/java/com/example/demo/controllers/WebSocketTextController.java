package com.example.demo.controllers;

import com.example.demo.MyAppProperties;
import com.example.demo.dto.*;
import com.example.demo.mappers.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WebSocketTextController {
    private final MyAppProperties myAppProperties;
    @Autowired
    public WebSocketTextController(MyAppProperties myAppProperties) {
        this.myAppProperties = myAppProperties;
    }

    @Autowired
    private SimpMessagingTemplate template;
    @PostMapping("/webhook")
    public ResponseEntity<Void> sendMessage(@RequestBody WhatsAppBusinessAccountDTO whatsAppBusinessAccountDTO) throws Exception {
        template.convertAndSend("/topic/message", MessageMapper.toWebSocketMessageDto(whatsAppBusinessAccountDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SendTo("/topic/message")
    public WebSocketMessageDto broadcastMessage(@Payload WebSocketMessageDto webSocketMessageDTO) {
        return webSocketMessageDTO;
    }

    @GetMapping("/webhook")
    public ResponseEntity<String> verifyWebhook(
        @RequestParam("hub.mode") String mode,
        @RequestParam("hub.verify_token") String token,
        @RequestParam("hub.challenge") String challenge) {
        if (mode != null && token != null) {
            if (mode.equals("subscribe") && token.equals(myAppProperties.getVerify_token())) {
                System.out.println("WEBHOOK_VERIFIED");
                return ResponseEntity.ok(challenge);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        return ResponseEntity.badRequest().build();
    }


}
