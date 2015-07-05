package com.reylibutan.tabularasa.dto;

import com.reylibutan.tabularasa.validator.FieldsMatch;
import com.reylibutan.tabularasa.validator.NotNullOrEmpty;
import com.reylibutan.tabularasa.validator.ValidEmail;

@FieldsMatch(message="{err.msg.fieldValuesMatch}", field1="password", field2="confirmPassword", fieldName1="Password", fieldName2="Confirm password")
public class UserDTO {
	
	private Long id;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="Email")
	@ValidEmail(message="{err.msg.validEmail}")
	private String email;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="First name")
	private String firstName;
	
	private String middleName;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="Last name")
	private String lastName;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="Password")
	private String password;
	
	@NotNullOrEmpty(message="{err.msg.required}", fieldName="Confirm password")
	private String confirmPassword;

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}
}