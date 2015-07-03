package com.reylibutan.tabularasa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reylibutan.tabularasa.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	
	public List<Person> findAll();
}