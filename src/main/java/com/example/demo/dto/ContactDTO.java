package com.example.demo.dto;

import com.example.demo.dto.WhatsAppBusinessAccountDTO;

public class ContactDTO {
    private ProfileDTO profile;
    private String wa_id;

    // Getters and setters for profile and wa_id
    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

    public String getWa_id() {
        return wa_id;
    }

    public void setWa_id(String wa_id) {
        this.wa_id = wa_id;
    }
}
