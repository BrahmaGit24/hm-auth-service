package com.hm.auth.service.util;

import org.springframework.security.core.userdetails.User;

import com.hm.auth.service.dto.UserDTO;

public class UserDetails extends User{

	public UserDetails(UserDTO user) {
		super(user.getUserName(), user.getPassword(), user.getAuthorittyList());
	}

}
