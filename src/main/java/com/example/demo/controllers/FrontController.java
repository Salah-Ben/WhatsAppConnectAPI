package com.example.demo.controllers;

import com.example.demo.MyAppProperties;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FrontController {
    private final MyAppProperties myAppProperties;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    public FrontController(MyAppProperties myAppProperties) {
        this.myAppProperties = myAppProperties;
    }

    @GetMapping("/downloadMedia")
    public ResponseEntity<Resource> downloadMedia(@RequestParam String id) throws Exception {
        AttachmentDTO dto = getAttachmentById(id);
        return getResponse(dto.getUrl(), dto.getMime_type());
    }
    private ResponseEntity<Resource> getResponse(String url, String mime_type) throws Exception {
        try {
            URI mediaUri = URI.create(url);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", myAppProperties.getBearer());
            headers.set("User-Agent", "WhatsApp/2.19.81 A");

            HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<byte[]> response = restTemplate.exchange(mediaUri, HttpMethod.GET, requestEntity, byte[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                InputStream inputStream = new ByteArrayInputStream(response.getBody());
                Resource resource = new InputStreamResource(inputStream);

                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.setContentType(MediaType.parseMediaType(mime_type));
                responseHeaders.setContentDispositionFormData("attachment",
                        "downloaded_media"+mime_type.split("/")[1]);

                return new ResponseEntity<>(resource, responseHeaders, HttpStatus.OK);
            } else {
                throw new Exception("exception");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public AttachmentDTO getAttachmentById(String id) {
        String url = "https://graph.facebook.com/v18.0/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", myAppProperties.getBearer());
        headers.set("User-Agent", "PostmanRuntime/7.26.8");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<AttachmentDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                AttachmentDTO.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to fetch AttachmentDTO. Status code: " + responseEntity.getStatusCodeValue());
        }
    }
    @PostMapping("/sendWhatsAppText")
    public ResponseEntity<String> sendWhatsAppTextMessage(@RequestParam String body) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", myAppProperties.getBearer());

            WhatsAppMessageRequestBody requestBody = new WhatsAppMessageRequestBody();
            requestBody.setMessaging_product("whatsapp");
            requestBody.setTo("212646303624");
            requestBody.setText(new WhatsAppMessageText(body));

            HttpEntity<WhatsAppMessageRequestBody> httpEntity = new HttpEntity<>(requestBody, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(
                    "https://graph.facebook.com/v12.0/" + myAppProperties.getPhone_number_id() + "/messages",
                    HttpMethod.POST,
                    httpEntity,
                    String.class
            );

            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/uploadMedia")
    public ResponseEntity<String> uploadMedia(@RequestParam("file") MultipartFile file) {
        ResponseEntity<String> response = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.set("Authorization", myAppProperties.getBearer());
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", new FileResource(file.getBytes(),file.getOriginalFilename()));
            body.add("type", "video/mp4");
            body.add("messaging_product", "whatsapp");
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.exchange(
                    "https://graph.facebook.com/v18.0/" + myAppProperties.getPhone_number_id() + "/media",
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/sendWhatsAppMedia")
    public ResponseEntity<String> sendWhatsAppMediaMessage(@RequestParam String id,@RequestParam String type) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", myAppProperties.getBearer());

            WhatsAppMediaMessageRequestBody requestBody = new WhatsAppMediaMessageRequestBody();
            requestBody.setMessaging_product("whatsapp");
            requestBody.setRecipient_type("individual");
            requestBody.setTo("212646303624");
            requestBody.setType(type);
            TypeFactory.setType(requestBody,id);
            HttpEntity<WhatsAppMediaMessageRequestBody> httpEntity = new HttpEntity<>(requestBody, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(
                    "https://graph.facebook.com/v18.0/" + myAppProperties.getPhone_number_id() + "/messages",
                    HttpMethod.POST,
                    httpEntity,
                    String.class
            );
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
