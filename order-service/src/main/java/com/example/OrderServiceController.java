package com.example;

import com.example.listener.KafkaMessageListener;
import com.example.manager.KafkaMessageManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderServiceController {

    private final KafkaMessageManager kafkaMessageManager;



        @PostMapping("/send")
        public ResponseEntity<String> sendMessage(@RequestBody OrderDto orderDto){

            // todo нужно ли делать отдельный класс для обработки этой строки??
            OrderEvent orderEvent = new OrderEvent( UUID.randomUUID(), orderDto);

            System.out.println(orderEvent.getOrderDto().getProduct() + " "+ orderEvent.getOrderDto(). getQuantity());
            kafkaMessageManager.send(orderEvent);
            return ResponseEntity.ok("Message sent to kafka");
        }

    }


