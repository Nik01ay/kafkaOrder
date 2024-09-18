package com.example;

import com.example.manager.KafkaMessageManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceManager {
    private final KafkaMessageManager kafkaMessageManager;
    @Value("${app.kafka.kafkaOrderMessageTopic}")
    private String topicName;

    public void sendDtoToKafkaMessage(OrderDto orderDto) {
        OrderEvent orderEvent = new OrderEvent(UUID.randomUUID(), orderDto);
        System.out.println(orderEvent.getOrderDto().getProduct() + " " + orderEvent.getOrderDto().getQuantity());
        kafkaMessageManager.send(topicName, orderEvent);
    }
}
