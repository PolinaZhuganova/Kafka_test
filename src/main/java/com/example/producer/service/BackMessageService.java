package com.example.producer.service;

import com.example.producer.messageDto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Класс BackMessageService
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BackMessageService implements MessageService {

	private final KafkaTemplate<Long, MessageDto> kafkaStarshipTemplate;
	private final ObjectMapper objectMapper;

	@Override
	public void send(MessageDto messageDto) {
		log.info("<= sending {}", writeValueAsString(messageDto));
		kafkaStarshipTemplate.send("Data_Delivery", messageDto);
	}

// ответ в виде JSON как в task_with_token???
	private String writeValueAsString(MessageDto dto) {
		try {
			return objectMapper.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
		}
	}
}