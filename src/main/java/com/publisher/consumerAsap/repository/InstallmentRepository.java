package com.publisher.consumerAsap.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.publisher.consumerAsap.model.Installment;

public interface InstallmentRepository extends JpaRepository<Installment, UUID>{
	
}
