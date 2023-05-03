package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRoleDAO;
import com.example.demo.dto.user_role;

@Service
public class UserRoleService {
	@Autowired
	UserRoleDAO userRoleDAO;

	public List<UserRoles> listarUserRoles() {
		return userRoleDAO.findAll();
	}

	public UserRole guardarUserRole(UserRole userRole) {
		return userRoleDAO.save(userRole);
	}

	public UserRole userRoleXID(Long id) {
		return userRoleDAO.findById(id).get();
	}

	public UserRole actualizarUserRole(UserRole userRole) {
		return userRoleDAO.save(userRole);
	}

	public void eliminarUserRole(int id) {
		userRoleDAO.deleteById(id);
	}
}
