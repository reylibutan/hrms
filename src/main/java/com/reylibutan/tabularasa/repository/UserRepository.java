package com.reylibutan.tabularasa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reylibutan.tabularasa.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
}