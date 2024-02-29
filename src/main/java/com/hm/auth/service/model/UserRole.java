package com.hm.auth.service.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_roles", schema = "login")
@JsonIgnoreProperties(ignoreUnknown = true, value = { "user" })
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userRoleId;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = true)
	private UserModel user;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = true)
	private Roles role;

	private Date roleStartDate;

	private Date roleEndDate;

	private boolean isActive;

	private Long createdById;

	private Date createdDate;

	private Long modifiedById;

	private Date modifiedDate;
}
