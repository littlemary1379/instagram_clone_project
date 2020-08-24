package com.mary.instragram.domain.user;

import lombok.Getter;

@Getter
public enum UserRole {
	USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

	UserRole(String key) {
		// TODO Auto-generated constructor stub
		this.key=key;
	}
	
	private String key;
	
}
