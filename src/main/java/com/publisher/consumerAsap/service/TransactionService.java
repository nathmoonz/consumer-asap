package com.publisher.consumerAsap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publisher.consumerAsap.model.Installment;
import com.publisher.consumerAsap.model.Person;
import com.publisher.consumerAsap.model.Transaction;
import com.publisher.consumerAsap.model.TransactionCreatePayload;
import com.publisher.consumerAsap.repository.InstallmentRepository;
import com.publisher.consumerAsap.repository.PersonRepository;
import com.publisher.consumerAsap.repository.TransactionRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private InstallmentRepository installmentRepository;

	public void create(TransactionCreatePayload payload) {

		Optional<Person> person = personRepository.findById(payload.documento);

		if (person.isEmpty()) {
			personRepository.save(new Person(payload.documento, payload.nome, payload.idade));
		}

		transactionRepository.save(new Transaction(payload.transacaoId, payload.dataTransacao, payload.valor));

		createInstallmentTransaction(payload);
	}

	private void createInstallmentTransaction(TransactionCreatePayload payload) {
		Double installmentValue = payload.valor / payload.numParcelas;
		for (int installmentNumber = 1; installmentNumber <= payload.numParcelas; installmentNumber++) {
			installmentRepository.save(new Installment(installmentNumber, installmentValue));
		}
	}

}