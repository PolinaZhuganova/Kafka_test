package com.example.producer.messageDto;

import lombok.Data;

import java.io.Serializable;

/**
 * Класс Message
 */
@Data
public class MessageDto implements Serializable {

	private String message;
}