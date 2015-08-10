package com.ryad.hrms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@RestResource
public class Patient {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String middleName;
	
	@Column
	private String lastName;
	
	@Column
	@Size(max = 50)
	private String sex;
	
	@Column
	private String uniqueIdCode;
	
	@Column
	private Date birthdate;
	
	@Column
	private String momFirstName;
	
	@Column
	private String momMiddleName;
	
	@Column
	private String momLastName;
	
	@Column
	private String address;
	
	@Column
	private String city;
	
	@Column
	@Size(max = 50)
	private String contactNumber;
	
	@ManyToMany
	@JoinTable(name = "patient_hiv_risk", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "hiv_risk_id"))
	private List<HivRisk> hivRisks = new ArrayList<HivRisk>();
	
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

	public List<HivRisk> getHivRisks() {
		return hivRisks;
	}

	public void setHivRisks(List<HivRisk> hivRisks) {
		this.hivRisks = hivRisks;
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

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", sex=" + sex + ", uniqueIdCode=" + uniqueIdCode
				+ ", birthdate=" + birthdate + "]";
	}
}