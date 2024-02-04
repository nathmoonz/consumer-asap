package com.publisher.consumerAsap.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_installment")
public class Installment {

	public Installment(Integer parcela, double value) {
		this.parcela = parcela;
		this.value = value;
	}
	
	public Installment() {}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotNull
	private Integer parcela;

	@NotNull
	private double value;

	@ManyToOne
	@JsonIgnoreProperties("installments")
	private Transaction transaction;

}