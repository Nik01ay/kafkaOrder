package com.example.listener;

import com.example.KafkaMessage;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.UUID;


public interface KafkaOrderMessageListener {


    @KafkaListener(
            autoStartup = "${app.kafka.kafkaListenerAutoStartup}",
            topics = "${app.kafka.kafkaOrderMessageTopic}",
            // todo не смог передать значение топика из реализации
            groupId = "${app.kafka.kafkaMessageGroupId}",
            containerFactory = "kafkaMessageConcurrentKafkaListenerContainerFactory"
    )
    public default void listen(@Payload KafkaMessage message,
                               @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) UUID key,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                               @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp) {
        action();
    }

    public void action();


}
