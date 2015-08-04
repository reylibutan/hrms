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
}