package com.hm.auth.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.auth.service.model.UserModel;

public interface UserDAO extends JpaRepository<UserModel, Long> {

	UserModel findByEmailId(String emailId);

	UserModel findByEmailIdIgnoreCase(String emailId);
}
