package com.ryad.hrms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ryad.hrms.dto.PatientDTO;
import com.ryad.hrms.entity.HivRisk;
import com.ryad.hrms.entity.Patient;

@Component
@Primary
public abstract class GeneralMapperDecorator implements DecoratedGeneralMapper {
	
	@Autowired
	@Qualifier("delegate")
	private DecoratedGeneralMapper delegate;

    public GeneralMapperDecorator() {
    	
	}

    // ===================================================================================================
    // @TODO: currently doesn't work according to: https://github.com/mapstruct/mapstruct/issues/592
    // ===================================================================================================
	@Override
    public PatientDTO patientToPatientDTO(Patient patient) {
    	PatientDTO dto = delegate.patientToPatientDTO(patient);
        
    	// set HIV risks
    	List<Long> hrs = new ArrayList<Long>();
    	for(HivRisk hr : patient.getHivRisks()) {
    		hrs.add(hr.getId());
    	}
    	
        return dto;
    }
}