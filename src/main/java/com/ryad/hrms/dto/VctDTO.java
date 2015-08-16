package com.ryad.hrms.dto;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;

import com.ryad.hrms.annotation.NotNullOrEmpty;

public class VctDTO {
	
	// ========================================================================
	// Patient Information
	// ========================================================================
	
	@Valid
	private PatientDTO patient;
	
	// ========================================================================
	// VCT Information
	// ========================================================================
	
	private Long id;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="VCT Date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date vctDate;
	
	private Integer isHivTested;
	
	private Integer isHivPositive;
	
	private String reasonForNotTesting;
	
	private Integer providedCounselingAndResult;
	
	// ========================================================================
	// List Information
	// ========================================================================

	private String fullName;
	
	private String codeName;
	
	// ========================================================================
	// Getters and Setters
	// ========================================================================

	public PatientDTO getPatient() {
		return patient;
	}

	public void setPatient(PatientDTO patient) {
		this.patient = patient;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getVctDate() {
		return vctDate;
	}

	public void setVctDate(Date vctDate) {
		this.vctDate = vctDate;
	}

	public Integer getIsHivTested() {
		return isHivTested;
	}

	public void setIsHivTested(Integer isHivTested) {
		this.isHivTested = isHivTested;
	}

	public Integer getIsHivPositive() {
		return isHivPositive;
	}

	public void setIsHivPositive(Integer isHivPositive) {
		this.isHivPositive = isHivPositive;
	}

	public String getReasonForNotTesting() {
		return reasonForNotTesting;
	}

	public void setReasonForNotTesting(String reasonForNotTesting) {
		this.reasonForNotTesting = reasonForNotTesting;
	}

	public Integer getProvidedCounselingAndResult() {
		return providedCounselingAndResult;
	}

	public void setProvidedCounselingAndResult(Integer providedCounselingAndResult) {
		this.providedCounselingAndResult = providedCounselingAndResult;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return "VctDTO [id=" + id + ", vctDate=" + vctDate + ", isHivTested="
				+ isHivTested + ", isHivPositive=" + isHivPositive
				+ ", reasonForNotTesting=" + reasonForNotTesting
				+ ", providedCounselingAndResult="
				+ providedCounselingAndResult + "]";
	}
}