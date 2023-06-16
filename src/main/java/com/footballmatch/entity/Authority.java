package com.footballmatch.entity;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {
	
	private String authority;
	
	@Override
	public String getAuthority() {
		return this.authority;
	}
	   
}
