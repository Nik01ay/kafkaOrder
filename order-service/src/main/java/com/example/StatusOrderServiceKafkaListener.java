package com.example;

import com.example.listener.KafkaOrderMessageListener;
import com.example.listener.KafkaStatusOrderMessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Slf4j
@Component
@RequiredArgsConstructor
public class StatusOrderServiceKafkaListener implements KafkaStatusOrderMessageListener {
    @Override
    public void action(KafkaMessage message, UUID key , String topic, Integer partition, Long timestamp) {
        log.info("Received message: {}", message);
        log.info("Key: {}; Partition: {}; Topic: {}, Timestamp: {}", key, partition, topic, timestamp);
    }
}