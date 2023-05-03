package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class roles {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_role;

	private String role_name;
	
	public roles() {
	}

	public roles(Long id_role, String role_name)
	{
		this.id_role=id_role;
		this.role_name=role_name;
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
	@OneToMany(mappedBy = "roles")
	private List<user_role> user_rol;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user_role")
	public List<user_role> getUser_rol() {
		return user_rol;
	}
	public void setUser_rol(List<user_role> user_rol) {
		this.user_rol = user_rol;
	}

}
