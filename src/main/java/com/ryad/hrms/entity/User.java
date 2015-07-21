package com.ryad.hrms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="`user`") //backticks are needed because PostgreSQL uses "user" as a keyword
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String username;
	
	@Column
	private String email;
	
	@Column
	private String firstName;
	
	@Column
	private String middleName;
	
	@Column
	private String lastName;
	
	@Column
	private String password;
	
	@ManyToMany
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles = new HashSet<Role>();

	// ========================================================================
	// getters and setters
	// ========================================================================
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	// ========================================================================
	// logic
	// ========================================================================
	
	public String getDisplayName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getDisplayRole() {
		Role displayRole = null;
		String displayRoleName = "";
		Set<Role> roles = this.getRoles();
		
		if(!roles.isEmpty()) {
			for(Role role : roles) {
				if(displayRole == null || role.getId().compareTo(displayRole.getId()) < 1) {
					displayRole = role;
				}
			}
			
			displayRoleName = displayRole.getName();
		}
		
		return displayRoleName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", password=" + password + "]";
	}
}