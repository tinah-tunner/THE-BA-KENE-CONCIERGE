package com.bakene.concierge.controller;

import com.bakene.concierge.entity.Message;
import com.bakene.concierge.service.ConversationService;
import com.bakene.concierge.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
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
    public Map<String, Object> dashboard() {

        Map<String, Object> response = new HashMap<>();

        response.put("totalConversations",
                conversationService.getAllConversations().size());

        response.put("totalMessages",
                messageService.getAllMessages().size());

        response.put("conversations",
                conversationService.getAllConversations());

        return response;
    }

    @GetMapping("/conversation/{id}")
    public List<Message> getConversationMessages(
            @PathVariable Long id) {

        return messageService.getConversationMessages(id);
    }

}