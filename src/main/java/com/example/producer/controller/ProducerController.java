package com.example.producer.controller;

import com.example.producer.messageDto.*;
import com.example.producer.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Класс ProducerController
 */
@RestController
@RequestMapping("/write/data")
@RequiredArgsConstructor
@Slf4j
public class ProducerController {
	private final MessageService messageService;

	@PostMapping
	public ResponseDto send(@RequestBody MessageDto dto) {
		try {
			log.info("message sent: " + dto);
			messageService.send(dto);
			return new ResponseDto("ok");

		} catch (Exception e) {
			log.error("failed to send a message: " + dto);
			e.printStackTrace();// потом удалить вывод в консоль

			return new ResponseDto("error");
		}


	}

}