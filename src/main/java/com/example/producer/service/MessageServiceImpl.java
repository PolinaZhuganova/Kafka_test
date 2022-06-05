package com.example.producer.service;

import com.example.producer.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Класс MessageServiceImpl
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

	private final KafkaTemplate<Long, MessageDto> kafkaTemplate;
	@Value("${kafka.topic}")
	private String kafkaTopic;

	@Override
	public void send(MessageDto message) {
		log.info("sending message:" + message);
		kafkaTemplate.send(kafkaTopic, message);
	}
}