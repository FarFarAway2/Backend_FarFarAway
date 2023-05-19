package com.farfaraway.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_role;

	private String role_name;

	@OneToMany
	@JoinColumn(name = "id_role")
	private List<UserRole> user_role;

	public Roles() {
	}

	public Roles(String role_name) {
		this.role_name = role_name;
	}

	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@OneToMany(mappedBy = "UserRole")
	private List<UserRole> user_role() {
		return user_role;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "UserRole")
	public List<UserRole> getUser_role() {
		return user_role;
	}

	public void setUser_rol(List<UserRole> user_role) {
		this.user_role = user_role;
	}

}
