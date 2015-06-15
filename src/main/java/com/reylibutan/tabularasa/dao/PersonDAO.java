package com.reylibutan.tabularasa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reylibutan.tabularasa.entity.Person;

@Repository
public class PersonDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Person> findAll() {
		
		String queryString = "SELECT p from Person p WHERE id > :number";
		TypedQuery<Person> query = entityManager.createQuery(queryString, Person.class);
		query.setParameter("number", (long)3); //just to test WEHRE conditions
		
		return query.getResultList();
	}
}