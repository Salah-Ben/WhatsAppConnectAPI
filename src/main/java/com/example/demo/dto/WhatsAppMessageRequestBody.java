package com.example.demo.dto;

public class WhatsAppMessageRequestBody {
    private String messaging_product;
    private String to;
    private WhatsAppMessageText text;

    public String getMessaging_product() {
        return messaging_product;
    }

    public String getTo() {
        return to;
    }

    public WhatsAppMessageText getText() {
        return text;
    }

    public void setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setText(WhatsAppMessageText text) {
        this.text = text;
    }
}
