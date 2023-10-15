package com.example.demo.dto;

public class AttachmentDTO {
    private String url;
    private String mime_type;
    private String sha256;
    private int file_size;
    private String id;
    private String messaging_product;

    // Constructors
    public AttachmentDTO() {
    }

    public AttachmentDTO(String url, String mime_type, String sha256, int file_size, String id, String messaging_product) {
        this.url = url;
        this.mime_type = mime_type;
        this.sha256 = sha256;
        this.file_size = file_size;
        this.id = id;
        this.messaging_product = messaging_product;
    }

    // Getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessaging_product() {
        return messaging_product;
    }

    public void setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
    }
}
