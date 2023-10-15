package com.example.demo.dto;


public class WhatsAppMediaMessageRequestBody {
    private String messaging_product;
    private String recipient_type;
    private String to;
    private String type;
    private Image image;
    private Video video;
    private Document document;
    private Audio audio;
    private Sticker sticker;

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public void setSticker(Sticker sticker) {
        this.sticker = sticker;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getMessaging_product() {
        return messaging_product;
    }

    public String getRecipient_type() {
        return recipient_type;
    }

    public String getTo() {
        return to;
    }

    public String getType() {
        return type;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRecipient_type(String recipient_type) {
        this.recipient_type = recipient_type;
    }

    public void setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
    }
    public void setTo(String to) {
        this.to = to;
    }
}
