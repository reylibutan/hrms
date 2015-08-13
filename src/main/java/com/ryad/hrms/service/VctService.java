package com.ryad.hrms.service;

import java.util.List;

import com.ryad.hrms.dto.HivRiskDTO;
import com.ryad.hrms.dto.VctDTO;

public interface VctService {
	
	/*public DataSet<VctDTO> findVctWithDatatablesCriteria(DatatablesCriterias criteria);*/
	
	public VctDTO findById(Long id);
	
	public VctDTO save(VctDTO vctDTO);
	
	public List<HivRiskDTO> getHivRisks();
}