package com.example.demo.dto;

public class TextMessage implements IMessage {
    private String text;

    public TextMessage(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getType() {
        return "text";
    }
}
