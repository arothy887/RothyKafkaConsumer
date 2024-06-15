package com.rothy.rothykafkaconsumer.consumer.service;

import com.rothy.rothykafkaconsumer.consumer.repository.Chamber;
import com.rothy.rothykafkaconsumer.consumer.repository.Message;
import com.rothy.rothykafkaconsumer.consumer.repository.MessageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StringConsumerService {

    private final MessageRepository messageRepository;


    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    @Transactional
    public void consume(String message) {

        Chamber chamberA = Chamber.builder()
                .high(1)
                .middle(0)
                .low(0)
                .chamberType("A")
                .build();
        Chamber chamberB = Chamber.builder()
                .high(0)
                .middle(1)
                .low(1)
                .chamberType("B")
                .build();
        Chamber chamberC = Chamber.builder()
                .high(1)
                .middle(1)
                .low(0)
                .chamberType("C")
                .build();
        Chamber chamberD = Chamber.builder()
                .high(1)
                .middle(0)
                .low(1)
                .chamberType("D")
                .build();
        List<Chamber> chamberList = Arrays.asList(chamberA, chamberB, chamberC, chamberD);
        Message message1 = Message.builder()
                .chambers(chamberList)
                .build()
        ;

        messageRepository.save(message1);

        log.info("Received message >>>>>>>>>>>>>> : {}", message);
        // 메시지 처리 로직 추가
    }
}
