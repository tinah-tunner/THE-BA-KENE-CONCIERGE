package com.bakene.concierge.dto;

public class MessageRequest {

    private String whatsappNumber;
    private String message;

    public MessageRequest() {
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}