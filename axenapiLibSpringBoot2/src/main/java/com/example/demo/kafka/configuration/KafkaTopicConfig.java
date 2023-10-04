package com.example.demo.kafka.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${my.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("my_topic", 1, (short) 1);
    }

    @Bean
    public NewTopic topic_demo_topic() {
        return new NewTopic("demo_topic", 1, (short) 1);
    }

    @Bean
    public NewTopic topic_demo_topic_response() {
        return new NewTopic("demo_topic_with_response", 1, (short) 1);
    }

    @Bean
    public NewTopic my_compitable_future() {
        return new NewTopic("my_compitable_future", 1, (short) 1);
    }

    @Bean
    public NewTopic my_annotation() {
        return new NewTopic("my_annotation", 1, (short) 1);
    }

    @Bean
    public NewTopic multiTopic() {
        return new NewTopic("multiType", 4, (short) 1);
    }
}