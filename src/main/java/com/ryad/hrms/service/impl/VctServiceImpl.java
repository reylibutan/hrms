package com.ryad.hrms.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryad.hrms.dto.HivRiskDTO;
import com.ryad.hrms.entity.HivRisk;
import com.ryad.hrms.mapper.GeneralMapper;
import com.ryad.hrms.repository.HivRiskRepository;
import com.ryad.hrms.service.VctService;

@Service
public class VctServiceImpl implements VctService {

	private final int HIV_RISK_EXPECTED_TOKENS = 2;
	private final String HIV_RISK_CHILD_SEPARATOR = "___";
	
	@Autowired
	private GeneralMapper generalMapper;
	
	@Autowired
	HivRiskRepository hivRiskRepo;
	
	@Override
	public List<HivRiskDTO> getHivRisks() {
		List<HivRiskDTO> hivRiskDtoList = null;
		List<HivRisk> hivRiskList = hivRiskRepo.findAllByOrderByIdAsc();
		
		if(!(hivRiskList == null || hivRiskList.isEmpty())) {
			Map<Long, HivRiskDTO> parents = new LinkedHashMap<Long, HivRiskDTO>();
			hivRiskDtoList = new ArrayList<HivRiskDTO>();
			List<HivRiskDTO> tempList = generalMapper.hivRisksToHivRiskDtos(hivRiskList);
			
			// segregate parents
			// NOTE: this relies on the fact that parents have smaller IDs than children in the DB
			int tempListLength = tempList.size();
			for(int i = 0 ; i < tempListLength; i++) {
				HivRiskDTO temp = tempList.get(i);
				if(temp.isHasChildren()) {
					parents.put(temp.getId(), temp);
				} else if(temp.getParentId() != null) {
					// ex. Provided Post Exposure Prophylaxis___Yes
					// ex. Provided Post Exposure Prophylaxis___No
					String[] labelTokens = temp.getName().split(HIV_RISK_CHILD_SEPARATOR);	
					
					if(labelTokens == null || labelTokens.length == HIV_RISK_EXPECTED_TOKENS) {
						String label = labelTokens[0]; // ex. Provided Post Exposure Prophylaxis
						String name = labelTokens[1]; // ex. Yes
						HivRiskDTO parent = parents.get(temp.getParentId());
						
						if(parent != null) {
							Map<String, List<HivRiskDTO>> children = parent.getChildren();
							List<HivRiskDTO> subChildren = children.get(label);
							
							if(subChildren == null) {
								subChildren = new ArrayList<HivRiskDTO>();
								temp.setName(name);
								subChildren.add(temp);
								children.put(label, subChildren);
							} else {
								temp.setName(name);
								subChildren.add(temp);
							}
						}
					}
				} else {
					hivRiskDtoList.add(temp);
				}
			}
			
			// add parents to return array
			for(Entry<Long, HivRiskDTO> parentEntry : parents.entrySet()) {
				hivRiskDtoList.add(parentEntry.getValue());
			}
		}
		
		return hivRiskDtoList;
	}
}