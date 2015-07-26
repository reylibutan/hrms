package com.ryad.hrms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryad.hrms.entity.HivRisk;

@Repository
public interface HivRiskRepository extends CrudRepository<HivRisk, Long> {
	
	List<HivRisk> findAllByOrderByIdAsc();
}