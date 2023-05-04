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

	public List<Roles> listarRoles() {
		return RolesDAO.findAll();
	}

	public Roles guardarRoles(Roles Roles) {
		return RolesDAO.save(Roles);
	}

	public Roles RolesXID(Long id) {
		return RolesDAO.findById(id).get();
	}

	public Roles actualizarRoles(Roles Roles) {
		return RolesDAO.save(Roles);
	}

	public void eliminarRoles(Long id) {
		RolesDAO.deleteById(id);
	}
}
