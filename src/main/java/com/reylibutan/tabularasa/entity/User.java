package com.reylibutan.tabularasa.entity;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	@NotNull(message="{err.required}")
	@Size(min=1, message="{err.required}")
	private String email;
	
	@NotNull(message="{err.required}")
	@Size(min=1, message="{err.required}")
	private String firstName;
	
	private String middleName;
	
	@NotNull(message="{err.required}")
	@Size(min=1, message="{err.required}")
	private String lastName;
	
	@NotNull(message="{err.required}")
	@Size(min=1, message="{err.required}")
	private String password;
	
	@Transient
	private String confirmPassword;

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}