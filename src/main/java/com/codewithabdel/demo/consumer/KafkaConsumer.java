package com.codewithabdel.demo.consumer;

import com.codewithabdel.demo.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic-name}", groupId = "ConsumerGroup1")
    public void flightEventConsumer(MyEvent message) {
        log.info("Consumer consume Kafka message -> {}", message);

        // write your handlers and post-processing logic, based on your use case
    }
}
