package com.ryad.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ryad.hrms.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	public List<Patient> findByFirstNameContains(@Param("firstName") String firstName);
}