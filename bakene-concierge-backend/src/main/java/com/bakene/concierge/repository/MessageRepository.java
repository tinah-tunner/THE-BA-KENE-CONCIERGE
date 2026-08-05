package com.bakene.concierge.repository;

import com.bakene.concierge.entity.Conversation;
import com.bakene.concierge.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByConversationOrderByCreatedAtAsc(Conversation conversation);

}