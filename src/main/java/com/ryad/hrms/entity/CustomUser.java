package com.ryad.hrms.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	
	private static final long serialVersionUID = -641415870753106414L;
	
	private String displayName;
	private String displayRole;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String displayName, String displayRole) {
		super(username, password, authorities);
		this.displayName = displayName;
		this.displayRole = displayRole;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayRole() {
		return displayRole;
	}

	public void setDisplayRole(String displayRole) {
		this.displayRole = displayRole;
	}
}