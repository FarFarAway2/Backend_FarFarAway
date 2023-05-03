package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RolesDAO;
import com.example.demo.dto.roles;

@Service
public class RolesService {
	@Autowired
	RolesDAO rolesDAO;

	public List<Roles> listarRoles() {
		return rolesDAO.findAll();
	}

	public Roles guardarRoles(Roles roles) {
		return rolesDAO.save(roles);
	}

	public Roles rolesXID(Long id) {
		return rolesDAO.findById(id).get();
	}

	public Roles actualizarRoles(Roles roles) {
		return rolesDAO.save(roles);
	}

	public void eliminarRoles(int id) {
		rolesDAO.deleteById(id);
	}
}
