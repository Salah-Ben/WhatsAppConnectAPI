package com.example.demo.dto;

import com.example.demo.dto.WhatsAppBusinessAccountDTO;

import java.util.List;

public class EntryDTO {
    private String id;
    private List<ChangeDTO> changes;

    // Getters and setters for id and changes
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ChangeDTO> getChanges() {
        return changes;
    }

    public void setChanges(List<ChangeDTO> changes) {
        this.changes = changes;
    }
}
