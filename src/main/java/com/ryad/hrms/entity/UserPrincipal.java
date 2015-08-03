package com.ryad.hrms.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserPrincipal extends org.springframework.security.core.userdetails.User {
	
	private static final long serialVersionUID = -641415870753106414L;
	
	private String displayName;
	private String displayRole;
	private User user;
	
	public UserPrincipal(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String displayName, String displayRole, User user) {
		super(username, password, authorities);
		this.displayName = displayName;
		this.displayRole = displayRole;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}