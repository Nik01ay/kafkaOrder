package com.example.manager;

import com.example.KafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class KafkaMessageManager {


    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;


    public void send(String topicName, KafkaMessage message) {
            kafkaTemplate.send(topicName, message);
    }

}
