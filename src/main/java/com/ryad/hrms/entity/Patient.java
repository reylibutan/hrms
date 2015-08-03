package com.ryad.hrms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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
	private String contactNumber;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "ID")
	private User createdBy;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "ID")
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

	public User getCreated_by() {
		return createdBy;
	}

	public void setCreated_by(User created_by) {
		this.createdBy = created_by;
	}

	public User getUpdated_by() {
		return updatedBy;
	}

	public void setUpdated_by(User updated_by) {
		this.updatedBy = updated_by;
	}

	public Date getCreated_date() {
		return createdDate;
	}

	public void setCreated_date(Date created_date) {
		this.createdDate = created_date;
	}

	public Date getUpdated_date() {
		return updatedDate;
	}

	public void setUpdated_date(Date updated_date) {
		this.updatedDate = updated_date;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", sex=" + sex + ", uniqueIdCode=" + uniqueIdCode
				+ ", birthdate=" + birthdate + "]";
	}
}