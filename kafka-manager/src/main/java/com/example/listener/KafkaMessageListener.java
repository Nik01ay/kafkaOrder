package com.example.listener;

import com.example.KafkaMessage;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
//@Slf4j
@RequiredArgsConstructor
public class KafkaMessageListener {
// Todo не вызывается метод listen, непомнимаю как его внедрить

    @KafkaListener (
            autoStartup = "${app.kafka.kafkaListenerAutoStartup}",
            topics = "${app.kafka.kafkaMessageTopic}",
     groupId = "${app.kafka.kafkaMessageGroupId}",
    containerFactory = "kafkaMessageConcurrentKafkaListenerContainerFactory"
    )
    public void listen(@Payload KafkaMessage message,
                       @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) UUID key,
                     //  @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp){
        System.out.println("SLUSHAOOO");
        System.out.println("polucheno message - " + message);

        /*log.info("Received message: {}", message);
        log.info("Key: {}; Partition{}; Topic: {}; TimeStamp{}", key, partition, topic, timestamp);
        */

    }





}
