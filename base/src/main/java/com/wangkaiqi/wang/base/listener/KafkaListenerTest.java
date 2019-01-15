package com.wangkaiqi.wang.base.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author kd
 */
@Component
@Slf4j
public class KafkaListenerTest {

    
    @KafkaListener(topics = "${spring.kafka.secondary.servers.test.topic.topic-1}", containerFactory = "testConcurrentKafkaListenerContainerFactory")
    public void listen(ConsumerRecord<?, String> record) {

        Optional<String> kafkaMessage = Optional.ofNullable(record.value());
        if (!kafkaMessage.isPresent()) {
            return;
        }
        log.info("listen(), topic = " + record.topic() + ", value = " + record.value());
        
    }


}