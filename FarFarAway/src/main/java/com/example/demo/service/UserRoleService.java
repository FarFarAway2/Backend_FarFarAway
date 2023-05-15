package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserRoleDAO;
import com.example.demo.dto.UserRole;

@Service
public class UserRoleService {
	@Autowired
	IUserRoleDAO iUserRoleDAO;

	public List<UserRole> listUserRoles() {
		return iUserRoleDAO.findAll();
	}

	public UserRole saveUserRole(UserRole userRole) {
		return iUserRoleDAO.save(userRole);
	}

	public UserRole userRoleXID(Long id) {
		return iUserRoleDAO.findById(id).get();
	}

	public UserRole updateUserRole(UserRole userRole) {
		return iUserRoleDAO.save(userRole);
	}

	public void deleteUserRole(Long id) {
		iUserRoleDAO.deleteById(id);
	}
}
