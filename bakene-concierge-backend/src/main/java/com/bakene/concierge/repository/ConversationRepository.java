package com.bakene.concierge.repository;

import com.bakene.concierge.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findByWhatsappNumber(String whatsappNumber);
}