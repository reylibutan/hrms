package com.ryad.hrms.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ryad.hrms.dto.HivRiskDTO;
import com.ryad.hrms.dto.PatientDTO;
import com.ryad.hrms.dto.VctDTO;
import com.ryad.hrms.entity.HivRisk;
import com.ryad.hrms.entity.Patient;
import com.ryad.hrms.entity.Vct;

@Mapper(componentModel = "spring", uses = HivRiskMapper.class)
public interface GeneralMapper {
	
	HivRiskDTO hivRiskToHivRiskDto(HivRisk hivRisks);
	
	List<HivRiskDTO> hivRisksToHivRiskDtos(List<HivRisk> hivRisks);
	
	PatientDTO patientToPatientDTO(Patient patient);
	
	VctDTO vctToVctDTO(Vct vct);
	
	Patient patientDTOToPatient(PatientDTO patientDTO);
	
	Vct vctDTOToVct(VctDTO vctDTO);
	
	List<VctDTO> vctsToVctDTOs(List<Vct> vcts);
}