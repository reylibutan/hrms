package com.ryad.hrms.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.ryad.hrms.annotation.NotNullOrEmpty;
import com.ryad.hrms.enums.SexType;

public class PatientDTO {
	
	// ========================================================================
	// Patient Information
	//	@TODO:
	//		1. Ask what are the required fields here
	//		2. Ask any specific validation rules
	// ========================================================================
	
	private Long id;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="First name")
	private String firstName;
	
	private String middleName;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="Last name")
	private String lastName;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="Sex")
	private String sex = SexType.MALE.toString(); // default value
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="Unique ID Code")
	private String uniqueIdCode;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="Birthdate")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthdate;
	
	private String momFirstName;
	
	private String momMiddleName;
	
	private String momLastName;
	
	private String address;
	
	private String city;
	
	private String contactNumber;
	
	private List<String> hivRisks = new ArrayList<String>();
	
	// ========================================================================
	// Getters and Setters
	// ========================================================================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUniqueIdCode() {
		return uniqueIdCode;
	}

	public void setUniqueIdCode(String uniqueIdCode) {
		this.uniqueIdCode = uniqueIdCode;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getMomFirstName() {
		return momFirstName;
	}

	public void setMomFirstName(String momFirstName) {
		this.momFirstName = momFirstName;
	}

	public String getMomMiddleName() {
		return momMiddleName;
	}

	public void setMomMiddleName(String momMiddleName) {
		this.momMiddleName = momMiddleName;
	}

	public String getMomLastName() {
		return momLastName;
	}

	public void setMomLastName(String momLastName) {
		this.momLastName = momLastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<String> getHivRisks() {
		return hivRisks;
	}

	public void setHivRisks(List<String> hivRisks) {
		this.hivRisks = hivRisks;
	}

	@Override
	public String toString() {
		return "PatientDTO [id=" + id + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", sex=" + sex + ", uniqueIdCode=" + uniqueIdCode + "]";
	}
}