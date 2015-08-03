package com.ryad.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryad.hrms.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
}