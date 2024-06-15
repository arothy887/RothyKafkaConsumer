package com.rothy.rothykafkaconsumer.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringConsumerService {



    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info("Received message >>>>>>>>>>>>>> : {}", message);
        // 메시지 처리 로직 추가
    }
}
