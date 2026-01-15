package com.learn.chat.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Value("${chat.topic}")
    private String topic;

    @Bean
    public NewTopic chatTopic() {
        return new NewTopic(topic, 1, (short) 1);
    }
}
