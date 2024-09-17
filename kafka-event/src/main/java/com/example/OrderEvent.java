package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent implements KafkaMessage {
    private UUID uuid;
    private OrderDto orderDto;
}
