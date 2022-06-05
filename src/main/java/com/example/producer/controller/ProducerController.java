package com.example.producer.controller;

import com.example.producer.messageDto.*;
import com.example.producer.service.MessageService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Класс ProducerController
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@Api(value = "тестовое задание для прохождения в компанию Ключ Авто")
public class ProducerController {
	private final MessageService messageService;

	@ApiOperation(value = "Отправка сообщения в очередь", response = ResponseDto.class)
	@PostMapping("/write/data")
	public ResponseDto send(@RequestBody MessageDto dto) {
		try {
			log.info("message has been sent: " + dto);
			messageService.send(dto);
			return new ResponseDto("ok");

		} catch (Exception e) {
			log.error("failed to send a message: " + dto);
			return new ResponseDto("error");
		}


	}

}