package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user_role;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users id_user;

	@ManyToOne
	@JoinColumn(name = "id_role")
	private Roles id_role;

	public UserRole() {

	}

	public UserRole(Long id_user_role, Users id_user, Roles id_role) {
		this.id_user_role = id_user_role;
		this.id_role = id_role;
		this.id_user = id_user;
	}

	public Users getId_user() {
		return id_user;
	}

	public void setId_user(Users id_user) {
		this.id_user = id_user;
	}

	public Roles getId_role() {
		return id_role;
	}

	public void setId_role(Roles id_role) {
		this.id_role = id_role;
	}

}
