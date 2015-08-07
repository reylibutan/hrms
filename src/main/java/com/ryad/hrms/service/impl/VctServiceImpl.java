package com.ryad.hrms.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryad.hrms.dto.HivRiskDTO;
import com.ryad.hrms.dto.VctDTO;
import com.ryad.hrms.entity.HivRisk;
import com.ryad.hrms.entity.Vct;
import com.ryad.hrms.mapper.DecoratedGeneralMapper;
import com.ryad.hrms.repository.HivRiskRepository;
import com.ryad.hrms.repository.PatientRepository;
import com.ryad.hrms.repository.VctRepository;
import com.ryad.hrms.service.VctService;

@Service
public class VctServiceImpl implements VctService {

	private final int HIV_RISK_EXPECTED_TOKENS = 2;
	private final String HIV_RISK_CHILD_SEPARATOR = "___";
	
	@Autowired
	private DecoratedGeneralMapper decoratedMapper;
	
	@Autowired
	private VctRepository vctRepo;
	
	@Autowired
	private HivRiskRepository hivRiskRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Override
	public VctDTO findById(Long id) {
		VctDTO vctDTO = null;
		Vct vct = vctRepo.findOne(id);
		
		if(vct != null) {
			vctDTO = decoratedMapper.vctToVctDTO(vct);
			
			// ==========================================================================
		    // @TODO: this should be removed after MapStruct fixes abstract Decorators
		    // ==========================================================================
			this.mapHivRisks(vctDTO, vct);
		}
		
		return vctDTO;
	}
	
	@Override
	@Transactional
	public VctDTO save(VctDTO vctDTO) {
		/*Patient patient = generalMapper.vctDTOToPatient(vctDTO);
		UserPrincipal principal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User createdBy = principal.getUser();
		Date createdDate = new LocalDateTime().toDate();
		
		patient.setCreatedBy(createdBy);
		patient.setCreatedDate(createdDate);
		patient = patientRepo.save(patient);
		
		// ====================================================================
		// ====================================================================
		// @TODO: save to vct, patient and patient_hiv_risks
		// ====================================================================
		// ====================================================================
		
		return vctDTO;*/
		
		return null;
	}
	
	@Override
	public List<HivRiskDTO> getHivRisks() {
		List<HivRiskDTO> hivRiskDtoList = null;
		List<HivRisk> hivRiskList = hivRiskRepo.findAllByOrderByIdAsc();
		
		if(!(hivRiskList == null || hivRiskList.isEmpty())) {
			Map<Long, HivRiskDTO> parents = new LinkedHashMap<Long, HivRiskDTO>();
			hivRiskDtoList = new ArrayList<HivRiskDTO>();
			List<HivRiskDTO> tempList = decoratedMapper.hivRisksToHivRiskDtos(hivRiskList);
			
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
	
	// ==========================================================================
    // @TODO: this should be removed after MapStruct fixes abstract Decorators
    // ==========================================================================
	private void mapHivRisks(VctDTO vctDTO, Vct vct) {
    	List<Long> hrs = new ArrayList<Long>();
    	for(HivRisk hr : vct.getPatient().getHivRisks()) {
    		hrs.add(hr.getId());
    	}
    	
    	vctDTO.getPatientDTO().setHivRisks(hrs);
	}
}