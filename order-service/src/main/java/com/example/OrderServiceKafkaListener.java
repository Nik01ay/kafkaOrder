package com.example;

import com.example.listener.KafkaMessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class OrderServiceKafkaListener {
    @Autowired
   private final KafkaMessageListener kafkaMessageListener;
    //todo хочу добавить метод котороый вызывается после вызова kafkaMessageListener.listen
    // не знаю как это сделать.
    // это для того что бы работа с кафкой была в отдельном модуле kafka-manager

}