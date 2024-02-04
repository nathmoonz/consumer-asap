package com.publisher.consumerAsap.model;

import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionCreatePayload {
	public UUID transacaoId;
	public String dataTransacao;
	public String documento;
	public String nome;
	public Integer idade;
	public Double valor;
	public Integer numParcelas;
	
	
	public static TransactionCreatePayload fromJson(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(json, TransactionCreatePayload.class);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
