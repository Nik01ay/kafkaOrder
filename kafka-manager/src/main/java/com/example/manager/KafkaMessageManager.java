package com.example.manager;

import com.example.KafkaMessage;
import com.example.listener.KafkaMessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class KafkaMessageManager {

    @Value("${app.kafka.kafkaMessageTopic}")
    private String topicName;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;


    public void send(KafkaMessage message) {
            kafkaTemplate.send(topicName, message);
         System.out.println("send message- " +  message);
    }

}
