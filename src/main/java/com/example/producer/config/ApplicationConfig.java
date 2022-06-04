package com.example.producer.config;

import org.springframework.context.annotation.*;

/**
 * Класс ApplicationConfig
 */
@Configuration
@Import(ProducerConfig.class)
@PropertySource({"classpath:kafka.properties"})
@ComponentScan({
	"com.example.producer.config",
	"com.example.producer.controller",
	"com.example.producer.service"
})
public class ApplicationConfig {
}