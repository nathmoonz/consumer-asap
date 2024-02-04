package com.publisher.consumerAsap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.publisher.consumerAsap.model.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}