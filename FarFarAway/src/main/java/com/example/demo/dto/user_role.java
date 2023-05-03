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
public class user_role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@ManyToOne
	@JoinColumn(name = "id_user")
	private users id_user;

	@ManyToOne
	@JoinColumn(name = "id_role")
	private roles id_role;

	public user_role() {
		
	}
	public user_role(users id_user, roles id_role)
	{
		this.id_role=id_role;
		this.id_user=id_user;
	}

	public users getId_user() {
		return id_user;
	}

	public void setId_user(users id_user) {
		this.id_user = id_user;
	}

	public roles getId_role() {
		return id_role;
	}

	public void setId_role(roles id_role) {
		this.id_role = id_role;
	}

}
