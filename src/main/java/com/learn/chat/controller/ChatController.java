package com.learn.chat.controller;

import org.springframework.web.bind.annotation.*;

import com.learn.chat.model.ChatMessage;
import com.learn.chat.producer.ChatProducer;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatProducer chatProducer;

    public ChatController(ChatProducer chatProducer) {
        this.chatProducer = chatProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody ChatMessage message) {
        chatProducer.sendMessage(message);
        return "Message sent successfully";
    }
}
