package com.example;

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

    private final OrderServiceManager orderServiceManager;


    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody OrderDto orderDto) {

        orderServiceManager.sendDtoToKafkaMessage(orderDto);
        return ResponseEntity.ok("Message sent to kafka");
    }

}


