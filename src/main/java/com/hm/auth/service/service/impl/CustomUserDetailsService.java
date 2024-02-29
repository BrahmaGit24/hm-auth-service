package com.hm.auth.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hm.auth.service.dao.UserDAO;
import com.hm.auth.service.dto.UserDTO;
import com.hm.auth.service.model.UserModel;

@Service("customUserService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel model = userDao.findByEmailId(username);
		UserDTO dto = new UserDTO();
		dto.setUserName(username);
		dto.setPassword(username);
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(model.getUserRole().getRole().getRoleName());
		grantedAuthorities.add(authority);
		
		dto.setAuthorittyList(grantedAuthorities);
		com.hm.auth.service.util.UserDetails userDetails = new com.hm.auth.service.util.UserDetails(dto);
		
		return userDetails;
	}

}
