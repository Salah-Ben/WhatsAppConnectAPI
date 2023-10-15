package com.example.demo.dto;

public class WebSocketMessageDto {
    private IMessage message;
    private String phoneNumber;
    private String type;

    public IMessage getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public void setMessage(IMessage message) {
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setType(String type) {
        this.type = type;
    }
}

