package com.example.demo.dto;

import com.example.demo.dto.WhatsAppBusinessAccountDTO;

public class ChangeDTO {
    private ValueDTO value;
    private String field;

    // Getters and setters for value and field
    public ValueDTO getValue() {
        return value;
    }

    public void setValue(ValueDTO value) {
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
