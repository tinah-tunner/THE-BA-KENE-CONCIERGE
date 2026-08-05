package com.bakene.concierge.controller;

import com.bakene.concierge.dto.MessageRequest;
import com.bakene.concierge.dto.MessageResponse;
import com.bakene.concierge.entity.Conversation;
import com.bakene.concierge.service.ConversationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(
            ConversationService conversationService) {

        this.conversationService = conversationService;
    }

    @PostMapping
    public ResponseEntity<Conversation> createConversation(
            @RequestParam String whatsappNumber,
            @RequestParam String userType) {

        return ResponseEntity.ok(
                conversationService.createConversation(
                        whatsappNumber,
                        userType
                )
        );
    }

    @GetMapping("/{whatsappNumber}")
    public ResponseEntity<Conversation> getConversation(
            @PathVariable String whatsappNumber) {

        return conversationService
                .getConversation(whatsappNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/message")
    public ResponseEntity<MessageResponse> processMessage(
            @RequestBody MessageRequest request) {

        String reply = conversationService.processMessage(
                request.getWhatsappNumber(),
                request.getMessage()
        );

        return ResponseEntity.ok(
                new MessageResponse(reply)
        );
    }
}