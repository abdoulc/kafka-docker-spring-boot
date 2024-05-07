package com.codewithabdel.demo.producer;

import com.codewithabdel.demo.MyEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {
    @Value("${spring.kafka.topic-name}")
    private String topicName;

    private final KafkaTemplate<String, MyEvent> kafkaTemplate;

    public void sendFlightEvent(MyEvent event){
        String key = event.getKey();
        kafkaTemplate.send(topicName, key , event);
        log.info("Producer produced the message {}", event);
        // write your handlers and post-processing logic, based on your use case
    }


}
