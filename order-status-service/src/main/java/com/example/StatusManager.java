package com.example;

import com.example.manager.KafkaMessageManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class StatusManager {
    private final KafkaMessageManager kafkaMessageManager;
    @Value("${app.kafka.kafkaStatusOrderMessageTopic}")
    private String topicName;

    public void sendDtoToKafkaStatusMessage() {
        StatusEvent statusEvent = new StatusEvent(StatusEnum.CREATED.toString(), Instant.now());
        kafkaMessageManager.send(topicName, statusEvent);
    }


}