package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IRolesDAO;
import com.example.demo.dto.Roles;

@Service
public class RolesService {
	@Autowired
	IRolesDAO RolesDAO;

	public List<Roles> listRoles() {
		return RolesDAO.findAll();
	}

	public Roles saveRoles(Roles Roles) {
		return RolesDAO.save(Roles);
	}

	public Roles rolesXID(Long id) {
		return RolesDAO.findById(id).get();
	}

	public Roles updateRoles(Roles Roles) {
		return RolesDAO.save(Roles);
	}

	public void deleteRoles(Long id) {
		RolesDAO.deleteById(id);
	}
}
