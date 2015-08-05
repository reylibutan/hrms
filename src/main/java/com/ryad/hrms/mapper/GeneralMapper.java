package com.ryad.hrms.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.ryad.hrms.dto.HivRiskDTO;
import com.ryad.hrms.dto.VctDTO;
import com.ryad.hrms.entity.HivRisk;
import com.ryad.hrms.entity.Patient;

@Mapper(componentModel = "spring")
public interface GeneralMapper {
	
	HivRiskDTO hivRiskToHivRiskDto(HivRisk hivRisks);
	
	List<HivRiskDTO> hivRisksToHivRiskDtos(List<HivRisk> hivRisks);
	
	@Mappings({
		@Mapping(source = "patientId", target = "id"),
		@Mapping(target = "hivRisks", ignore = true)
	})
	Patient vctDTOToPatient(VctDTO vctDTO);
}