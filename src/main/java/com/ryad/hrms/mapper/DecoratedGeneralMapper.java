package com.ryad.hrms.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ryad.hrms.dto.HivRiskDTO;
import com.ryad.hrms.dto.PatientDTO;
import com.ryad.hrms.dto.VctDTO;
import com.ryad.hrms.entity.HivRisk;
import com.ryad.hrms.entity.Patient;
import com.ryad.hrms.entity.Vct;

@Mapper(componentModel = "spring")
@DecoratedWith(GeneralMapperDecorator.class)
public interface DecoratedGeneralMapper {
	
	HivRiskDTO hivRiskToHivRiskDto(HivRisk hivRisks);
	
	List<HivRiskDTO> hivRisksToHivRiskDtos(List<HivRisk> hivRisks);
	
	@Mapping(target = "hivRisks", ignore = true)
	PatientDTO patientToPatientDTO(Patient patient);
	
	@Mapping(source = "patient", target = "patientDTO")
	VctDTO vctToVctDTO(Vct vct);
}