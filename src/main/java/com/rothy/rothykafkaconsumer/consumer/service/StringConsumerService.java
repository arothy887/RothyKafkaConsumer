package com.rothy.rothykafkaconsumer.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rothy.rothykafkaconsumer.consumer.repository.Chamber;
import com.rothy.rothykafkaconsumer.consumer.repository.ChamberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class StringConsumerService {

    private final ChamberRepository chamberRepository;


    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    @Transactional
    public void consume(String message) {

        String testMessage = """
                {
                    "glossary": {
                        "title": "example glossary",
                		"GlossDiv": {
                            "title": "S",
                			"GlossList": {
                                "GlossEntry": {
                                    "ID": "SGML",
                					"SortAs": "SGML",
                					"GlossTerm": "Standard Generalized Markup Language",
                					"Acronym": "SGML",
                					"Abbrev": "ISO 8879:1986",
                					"GlossDef": {
                                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
                						"GlossSeeAlso": ["GML", "XML"]
                                    },
                					"GlossSee": "markup"
                                }
                            }
                        }
                    }
                }
                """;


        /**
         *
         * JSON SAMPLE
         * {
         *     "glossary": {
         *         "title": "example glossary",
         * 		"GlossDiv": {
         *             "title": "S",
         * 			"GlossList": {
         *                 "GlossEntry": {
         *                     "ID": "SGML",
         * 					"SortAs": "SGML",
         * 					"GlossTerm": "Standard Generalized Markup Language",
         * 					"Acronym": "SGML",
         * 					"Abbrev": "ISO 8879:1986",
         * 					"GlossDef": {
         *                         "para": "A meta-markup language, used to create markup languages such as DocBook.",
         * 						"GlossSeeAlso": ["GML", "XML"]
         *                     },
         * 					"GlossSee": "markup"
         *                 }
         *             }
         *         }
         *     }
         * }
         * */

//

//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            Map<String, Object> parsedData = objectMapper.readValue(testMessage, HashMap.class);
//            Map<String, Object> glossDiv = (Map<String, Object>) parsedData.get("GlossDiv");
//            Map<String, Object> glossList = (Map<String, Object>) glossDiv.get("GlossList");
//            Map<String, Object> glossEntry = (Map<String, Object>) glossList.get("GlossEntry");
//            String abbrev = (String) glossEntry.get("Abbrev");
//            System.out.println(abbrev);
//
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        // val aaa = GlossDiv.GlossList.GlossEntry.Acronym

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
        chamberRepository.saveAll(chamberList);

        log.info("Received message >>>>>>>>>>>>>> : {}", message);
        // 메시지 처리 로직 추가
    }
}
