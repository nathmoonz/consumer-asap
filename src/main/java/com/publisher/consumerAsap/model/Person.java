package com.publisher.consumerAsap.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_person")
public class Person {
	
	public Person(String id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Person() {}
	
	@Id
	private String id;

	@NotBlank
	private String name;

	@NotNull
	@Min(value = 18)
	private Integer age;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("person")
	private List<Transaction> transactions;

}
