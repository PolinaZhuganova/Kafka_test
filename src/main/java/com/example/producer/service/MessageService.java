package com.example.producer.service;

import com.example.producer.dto.MessageDto;

/**
 * Класс MessageService
 */
public interface MessageService {

	void send(MessageDto messageDto);
}