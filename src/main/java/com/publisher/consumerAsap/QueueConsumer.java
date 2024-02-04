package com.publisher.consumerAsap;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.publisher.consumerAsap.model.TransactionCreatePayload;
import com.publisher.consumerAsap.service.TransactionService;

@Component
public class QueueConsumer {

	@Autowired
	public TransactionService transactionService;
	
	@RabbitListener(queues = { "FilaCreate" })
	public void receiveCreate(@Payload String fileBody) {
		TransactionCreatePayload payload = TransactionCreatePayload.fromJson(fileBody);
		 System.out.println("Input: " + payload.dataTransacao);
		 transactionService.create(payload);
	}

}
