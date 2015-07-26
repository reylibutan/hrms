package com.ryad.hrms.dto;

import java.util.ArrayList;
import java.util.List;

public class HivRiskSubDTO {
	
	private String label;
	private List<HivRiskDTO> children = new ArrayList<HivRiskDTO>();
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public List<HivRiskDTO> getChildren() {
		return children;
	}
	
	public void setChildren(List<HivRiskDTO> children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
		return "HivRiskSubDTO [label=" + label + ", children=" + children + "]";
	}
}