package com.publisher.consumerAsap.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_transaction")
public class Transaction {

	public Transaction(UUID transacaoId, String transactionDate, Double amount) {
		this.id = transacaoId;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}
	
	public Transaction() {}

	@Id
	private UUID id;

	private String transactionDate;

	@NotNull
	private Double amount;

	@ManyToOne
	@JsonIgnoreProperties("transaction")
	private Person person;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("transaction")
	private List<Installment> installments;

}