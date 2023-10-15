package com.example.demo.mappers;

import com.example.demo.dto.*;

public class MessageMapper {
    public static WebSocketMessageDto toWebSocketMessageDto(WhatsAppBusinessAccountDTO whatsAppBusinessAccountDTO){
        WebSocketMessageDto webSocketMessageDTO = new WebSocketMessageDto();
        MessageDTO messageDTO = whatsAppBusinessAccountDTO.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0);
        String type = messageDTO.getType();
        String from = messageDTO.getFrom();
        IMessage m = MessageFactory.getMessage(messageDTO);
        webSocketMessageDTO.setMessage(m);
        webSocketMessageDTO.setType(type);
        webSocketMessageDTO.setPhoneNumber(from);
        return webSocketMessageDTO;
    }
}
