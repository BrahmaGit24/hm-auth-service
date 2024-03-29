package com.hm.auth.service.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private String userName;
	private String password;

	private Collection<GrantedAuthority> authorittyList = new ArrayList<GrantedAuthority>();
}
