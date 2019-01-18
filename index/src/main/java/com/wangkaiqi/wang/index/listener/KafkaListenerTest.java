package com.wangkaiqi.wang.index.listener;

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
    @KafkaListener(topics = "${spring.kafka.consumer.topic-1}")
  //@KafkaListener(topics = "test_test")
  public void listen(ConsumerRecord<?, String> record) {

        Optional<String> kafkaMessage = Optional.ofNullable(record.value());
        if (!kafkaMessage.isPresent()) {
            return;
        }
        log.info("listen(), topic = " + record.topic() + ", value = " + record.value());
    }
}