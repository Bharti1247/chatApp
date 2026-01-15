package com.learn.chat.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.chat.model.ChatMessage;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChatConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${chat.topic}", groupId = "chat-group")
    public void consume(String message) {
        try {
            ChatMessage chatMessage = objectMapper.readValue(message, ChatMessage.class);
            System.out.println("Received Message: " + chatMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
