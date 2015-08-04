package com.ryad.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryad.hrms.entity.Vct;

@Repository
public interface VctRepository extends JpaRepository<Vct, Long> {
	
}