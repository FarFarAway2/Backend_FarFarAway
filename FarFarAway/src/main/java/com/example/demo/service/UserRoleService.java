package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserRoleDAO;
import com.example.demo.dto.UserRole;
import com.example.demo.dto.Users;

@Service
public class UserRoleService {
	@Autowired
	IUserRoleDAO userRoleDAO;

	public List<UserRole> listarUserRoles() {
		return userRoleDAO.findAll();
	}

	public UserRole guardarUserRole(UserRole userRole) {
		return userRoleDAO.save(userRole);
	}

	public UserRole userRoleXID(Users id) {
		return userRoleDAO.findById(id).get();
	}

	public UserRole actualizarUserRole(UserRole userRole) {
		return userRoleDAO.save(userRole);
	}

	public void eliminarUserRole(Users id) {
		userRoleDAO.deleteById(id);
	}
}
