package com.publisher.consumerAsap;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ConsumerAsap1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerAsap1Application.class, args);
	}

}
