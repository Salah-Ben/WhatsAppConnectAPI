package com.example.demo.dto;

public class MessageDTO {
    private String from;
    private String id;
    private String timestamp;
    private TextDTO text;
    private String type;
    private MediaDto image;
    private MediaDto sticker;
    private MediaDto audio;
    private MediaDto video;
    private MediaDto document;
    private MediaDto button;
    private MediaDto location;
    private MediaDto reaction;
    public MediaDto getImage() {
        return image;
    }

    public void setImage(MediaDto image) {
        this.image = image;
    }

    // Getters and setters for from, id, timestamp, text, and type
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public TextDTO getText() {
        return text;
    }

    public void setText(TextDTO text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MediaDto getSticker() {
        return sticker;
    }

    public MediaDto getAudio() {
        return audio;
    }

    public MediaDto getVideo() {
        return video;
    }

    public MediaDto getDocument() {
        return document;
    }

    public MediaDto getButton() {
        return button;
    }

    public MediaDto getLocation() {
        return location;
    }

    public MediaDto getReaction() {
        return reaction;
    }

    public void setSticker(MediaDto sticker) {
        this.sticker = sticker;
    }

    public void setAudio(MediaDto audio) {
        this.audio = audio;
    }

    public void setVideo(MediaDto video) {
        this.video = video;
    }

    public void setDocument(MediaDto document) {
        this.document = document;
    }

    public void setButton(MediaDto button) {
        this.button = button;
    }

    public void setLocation(MediaDto location) {
        this.location = location;
    }

    public void setReaction(MediaDto reaction) {
        this.reaction = reaction;
    }
}
