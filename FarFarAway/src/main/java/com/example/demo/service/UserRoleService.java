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

	public List<UserRole> listUserRoles() {
		return userRoleDAO.findAll();
	}

	public UserRole saveUserRole(UserRole userRole) {
		return userRoleDAO.save(userRole);
	}

	public UserRole userRoleXID(Long id) {
		return userRoleDAO.findById(id).get();
	}

	public UserRole updateUserRole(UserRole userRole) {
		return userRoleDAO.save(userRole);
	}

	public void deleteUserRole(Long id) {
		userRoleDAO.deleteById(id);
	}
}
