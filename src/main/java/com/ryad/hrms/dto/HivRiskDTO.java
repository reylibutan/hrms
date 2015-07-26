package com.ryad.hrms.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HivRiskDTO {
	
	private Long id;
	private String name;
	private boolean hasChildren;
	private Long parentId;
	private Map<String, List<HivRiskDTO>> children = new LinkedHashMap<String, List<HivRiskDTO>>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isHasChildren() {
		return hasChildren;
	}
	
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Map<String, List<HivRiskDTO>> getChildren() {
		return children;
	}

	public void setChildren(Map<String, List<HivRiskDTO>> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "HivRiskDTO [id=" + id + ", name=" + name + ", hasChildren="
				+ hasChildren + ", parentId=" + parentId + ", children="
				+ children + "]";
	}
}