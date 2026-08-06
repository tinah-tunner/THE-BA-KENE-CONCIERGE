package com.bakene.concierge.controller;

import com.bakene.concierge.entity.Conversation;
import com.bakene.concierge.service.ConversationService;
import com.bakene.concierge.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminApiController {

    private final ConversationService conversationService;
    private final MessageService messageService;

    public AdminApiController(
            ConversationService conversationService,
            MessageService messageService) {

        this.conversationService = conversationService;
        this.messageService = messageService;
    }

    @GetMapping("/dashboard")
    public Map<String,Object> dashboard(){

        Map<String,Object> response = new HashMap<>();

        response.put(
                "totalConversations",
                conversationService.getAllConversations().size());

        response.put(
                "totalMessages",
                messageService.getAllMessages().size());

        response.put(
                "conversations",
                conversationService.getAllConversations());

        return response;
    }

}