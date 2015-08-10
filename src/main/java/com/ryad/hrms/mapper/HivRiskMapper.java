package com.ryad.hrms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ryad.hrms.entity.HivRisk;
import com.ryad.hrms.repository.HivRiskRepository;

@Component
public class HivRiskMapper {

	@Autowired
	HivRiskRepository hivRiskRepo;
	
	public List<Long> hivRiskToLong(List<HivRisk> hivRisks) {
    	List<Long> hivRiskIds = new ArrayList<Long>();
    	for(HivRisk hr : hivRisks) {
    		hivRiskIds.add(hr.getId());
    	}
    	
    	return hivRiskIds;
	}
	
	public List<HivRisk> longToHivRisk(List<Long> hivRiskIds) {
		List<HivRisk> hivRisks = new ArrayList<HivRisk>();
		
		for(Long hivRiskId : hivRiskIds) {
			HivRisk hivRisk = hivRiskRepo.findOne(hivRiskId);
			if(hivRisk != null) {
				hivRisks.add(hivRisk);
			}
		}
		
		return hivRisks;
	}
}