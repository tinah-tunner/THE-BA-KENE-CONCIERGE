package com.bakene.concierge.service;

import com.bakene.concierge.config.MetaConfig;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WhatsAppService {

    private final RestTemplate restTemplate;
    private final MetaConfig config;

    public WhatsAppService(RestTemplate restTemplate,
                           MetaConfig config) {

        this.restTemplate = restTemplate;
        this.config = config;
    }
public void sendMessage(String to, String message) {

    String url =
            "https://graph.facebook.com/v23.0/"
                    + config.getPhoneNumberId()
                    + "/messages";

    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(config.getAccessToken());
    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String,Object> body = Map.of(
            "messaging_product","whatsapp",
            "to",to,
            "type","text",
            "text",Map.of("body",message)
    );

    HttpEntity<Map<String,Object>> request =
            new HttpEntity<>(body,headers);

    System.out.println("===== SENDING MESSAGE =====");
    System.out.println("URL: " + url);
    System.out.println("TO: " + to);
    System.out.println("BODY: " + message);

    try {

        ResponseEntity<String> response =
                restTemplate.postForEntity(
                        url,
                        request,
                        String.class
                );

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody());

    } catch (Exception e) {

        System.out.println("WHATSAPP SEND FAILED");
        e.printStackTrace();
    }
}
}