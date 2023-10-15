package com.example.demo.dto;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public class MediaMessage implements IMessage {
    private String body;
    private String longitude;
    private String latitude;
    private String emoji;
    private String name;
    private String address;
    @Override
    public String getType() {return "media";}
    public MediaMessage(String body) {this.body = body; }
    public MediaMessage(String longitude, String latitude, String name, String address) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.address = address;
    }
    public void setBody(String body) {this.body = body;}

    public void setLongitude(String longitude) {this.longitude = longitude;}

    public void setLatitude(String latitude) {this.latitude = latitude;}

    public String getEmoji() {return emoji;}

    public void setEmoji(String emoji) {this.emoji = emoji;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getBody() {return body;}
    public String getLongitude() {return longitude;}
    public String getLatitude() {return latitude;}
}
