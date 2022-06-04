package com.example.producer.controller;

import com.example.producer.messageDto.MessageDto;
import com.example.producer.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Класс ProducerController
 */
@RestController
@RequestMapping("/write/data")
@RequiredArgsConstructor
public class ProducerController {

	private final MessageService messageService;

	@PostMapping
	public void send(@RequestBody MessageDto dto) {
		messageService.send(dto);
	}

}