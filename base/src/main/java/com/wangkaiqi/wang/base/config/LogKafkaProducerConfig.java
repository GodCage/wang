package com.wangkaiqi.wang.base.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * 生成kafka配置类
 * @author wangkaiqi
 */
@Configuration
@EnableKafka
public class LogKafkaProducerConfig {

   // @Value("${spring.kafka.secondary.servers.log.bootstrap-servers}")
    private String servers="172.16.239.7:9092";
    
   

    public Map<String, Object> producerConfigs() {

        Map<String, Object> props = new HashMap<>(7);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 4096);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 40960);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean(autowire = Autowire.BY_NAME,value = "myKafkaTemplate")
    public KafkaTemplate<String, String> myKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
