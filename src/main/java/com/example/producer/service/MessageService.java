package com.example.producer.service;

import com.example.producer.messageDto.MessageDto;

/**
 * Класс MessageService
 */
public interface MessageService {

	void send(MessageDto messageDto);
}