package com.ryad.hrms.service;

import java.util.List;

import com.ryad.hrms.dto.DTCriteria;
import com.ryad.hrms.dto.DTDataSet;
import com.ryad.hrms.dto.HivRiskDTO;
import com.ryad.hrms.dto.VctDTO;

public interface VctService {
	
	public DTDataSet<VctDTO> findVctWithDatatablesCriteria(DTCriteria criteria);
	
	public VctDTO findById(Long id);
	
	public VctDTO save(VctDTO vctDTO);
	
	public List<HivRiskDTO> getHivRisks();
}