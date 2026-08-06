package com.bakene.concierge.controller;

import com.bakene.concierge.entity.Conversation;
import com.bakene.concierge.service.ConversationService;
import com.bakene.concierge.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {

    private final ConversationService conversationService;
    private final MessageService messageService;

    public AdminController(
            ConversationService conversationService,
            MessageService messageService) {

        this.conversationService = conversationService;
        this.messageService = messageService;
    }

    @GetMapping("/admin")
    public String dashboard(Model model) {

        model.addAttribute(
                "conversations",
                conversationService.getAllConversations());

        model.addAttribute(
                "totalConversations",
                conversationService.getAllConversations().size());

        model.addAttribute(
                "totalMessages",
                messageService.getAllMessages().size());

        return "index";
    }

    @GetMapping("/admin/conversation/{id}")
    public String conversation(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "messages",
                messageService.getConversationMessages(id));

        return "conversation";
    }

}