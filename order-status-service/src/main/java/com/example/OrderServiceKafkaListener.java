package com.example;

import com.example.listener.KafkaOrderMessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderServiceKafkaListener implements KafkaOrderMessageListener {
    private final StatusManager statusManager;
    @Override
    public void action() {
        statusManager.sendDtoToKafkaStatusMessage();
        System.out.println("Говорит ордер Статус сервис. Произошло изменение статуса");
    }
}