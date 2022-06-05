package com.example.producer.messageDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Класс Message
 */
@Data
public class MessageDto implements Serializable {

	@ApiModelProperty(notes = "Текст передаваемого сообщения")
	private String msgTxt;
}