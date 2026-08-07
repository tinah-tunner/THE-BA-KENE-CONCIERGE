package com.bakene.concierge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetaConfig {

    @Value("${whatsapp.access.token}")
    private String accessToken;

    @Value("${whatsapp.phone.number.id}")
    private String phoneNumberId;

    @Value("${whatsapp.verify.token}")
    private String verifyToken;

    public String getAccessToken() {
        return accessToken;
    }

    public String getPhoneNumberId() {
        return phoneNumberId;
    }

    public String getVerifyToken() {
        return verifyToken;
    }
}