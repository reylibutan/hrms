package com.reylibutan.tabularasa.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reylibutan.tabularasa.entity.User;

@Repository
public class UserDAO {
	
	@Autowired
	EntityManager em;
	
	public void save(User user) {
		em.persist(user);
	}
}