package com.ryad.hrms.service;

import java.util.List;

import com.ryad.hrms.dto.HivRiskDTO;
import com.ryad.hrms.dto.VctDTO;

public interface VctService {
	
	public List<HivRiskDTO> getHivRisks();
	
	public VctDTO save(VctDTO vctDTO); 
}