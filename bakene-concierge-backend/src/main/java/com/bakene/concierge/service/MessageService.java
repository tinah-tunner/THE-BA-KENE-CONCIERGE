package com.bakene.concierge.service;

import com.bakene.concierge.entity.Conversation;
import com.bakene.concierge.entity.Message;
import com.bakene.concierge.repository.ConversationRepository;
import com.bakene.concierge.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;

    public MessageService(
            MessageRepository messageRepository,
            ConversationRepository conversationRepository) {

        this.messageRepository = messageRepository;
        this.conversationRepository = conversationRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> getConversationMessages(Long conversationId) {

        Conversation conversation = conversationRepository
                .findById(conversationId)
                .orElse(null);

        if (conversation == null) {
            return Collections.emptyList();
        }

        return messageRepository.findByConversationOrderByCreatedAtAsc(conversation);
    }
}