package com.ryad.hrms.enums;

public enum SexType {
	MALE("Male"),
	FEMALE("Female");
	
	private String name;
	
	private SexType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}