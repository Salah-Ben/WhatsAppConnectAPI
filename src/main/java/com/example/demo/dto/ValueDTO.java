package com.example.demo.dto;

import com.example.demo.dto.WhatsAppBusinessAccountDTO;

import java.util.List;

public class ValueDTO {
    private String messaging_product;
    private MetadataDTO metadata;
    private List<ContactDTO> contacts;
    private List<MessageDTO> messages;

    // Getters and setters for messaging_product, metadata, contacts, and messages
    public String getMessaging_product() {
        return messaging_product;
    }

    public void setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
    }

    public MetadataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDTO metadata) {
        this.metadata = metadata;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
}
