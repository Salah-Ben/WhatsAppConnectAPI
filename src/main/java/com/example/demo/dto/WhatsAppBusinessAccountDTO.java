package com.example.demo.dto;

import java.util.List;

public class WhatsAppBusinessAccountDTO {
    private String object;
    private List<EntryDTO> entry;

    // Getters and setters for object and entry
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<EntryDTO> getEntry() {
        return entry;
    }

    public void setEntry(List<EntryDTO> entry) {
        this.entry = entry;
    }
}
