package com.ryad.hrms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vct {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private Patient patient;
	
	@Column
	private Date vctDate;
	
	@Column
	private Integer isHivTested;
	
	@Column
	private Integer isHivPositive;
	
	@Column
	private String reasonForNotTesting;
	
	@Column
	private Integer providedCounselingAndResult;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", referencedColumnName = "id")
	private User createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by", referencedColumnName = "id")
	private User updatedBy;
	
	@Column
	private Date createdDate;
	
	@Column
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}