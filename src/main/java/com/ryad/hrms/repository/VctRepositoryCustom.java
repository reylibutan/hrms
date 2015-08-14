package com.ryad.hrms.repository;

import java.util.List;

import com.ryad.hrms.dto.DTCriteria;
import com.ryad.hrms.entity.Vct;

public interface VctRepositoryCustom {
	
	public List<Vct> findVctWithDatatablesCriteria(DTCriteria criteria);
	
	public Long getFilteredCount(DTCriteria criterias);
}