package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myapp")
public class MyAppProperties {
    private String bearer;
    private String verify_token;
    private String phone_number_id;

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getVerify_token() {
        return verify_token;
    }

    public void setVerify_token(String verify_token) {
        this.verify_token = verify_token;
    }

    public String getPhone_number_id() {
        return phone_number_id;
    }

    public void setPhone_number_id(String phone_number_id) {
        this.phone_number_id = phone_number_id;
    }
}

