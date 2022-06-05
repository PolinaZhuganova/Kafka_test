package com.example.producer.config;

import com.example.producer.dto.MessageDto;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.*;

/**
 * Класс ProducerConfig
 */
@Configuration
public class ProducerConfig {

	@Value("${kafka.server}")
	private String kafkaServer;

	@Value("${kafka.producer.id}")
	private String kafkaProducerId;

	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		props.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
		props.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		props.put(org.apache.kafka.clients.producer.ProducerConfig.CLIENT_ID_CONFIG, kafkaProducerId);
		return props;
	}

	@Bean
	public ProducerFactory<Long, MessageDto> producerStarshipFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public KafkaTemplate<Long, MessageDto> kafkaTemplate() {
		KafkaTemplate<Long, MessageDto> template = new KafkaTemplate<>(producerStarshipFactory());
		template.setMessageConverter(new StringJsonMessageConverter());
		return template;
	}

}