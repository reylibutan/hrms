package com.reylibutan.tabularasa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reylibutan.tabularasa.dto.PersonDTO;
import com.reylibutan.tabularasa.mapper.GeneralMapper;
import com.reylibutan.tabularasa.repository.PersonRepository;
import com.reylibutan.tabularasa.service.SampleService;

@Service
@Transactional
public class SampleServiceImpl implements SampleService {

	@Autowired
	private GeneralMapper generalMapper;
	
	@Autowired
	private PersonRepository personRepo;
	
	@Override
	public List<PersonDTO> findAll() {
		return generalMapper.personsToPersonDtos(personRepo.findAll());
	}
}