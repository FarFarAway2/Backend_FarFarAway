package com.farfaraway.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farfaraway.app.dao.IRolesDAO;
import com.farfaraway.app.dto.Roles;

@Service
public class RolesService {
	@Autowired
	IRolesDAO iRolesDAO;

	public List<Roles> listRoles() {
		return iRolesDAO.findAll();
	}

	public Roles saveRoles(Roles Roles) {
		return iRolesDAO.save(Roles);
	}

	public Roles rolesXID(Long id) {
		return iRolesDAO.findById(id).get();
	}

	public Roles updateRoles(Roles Roles) {
		return iRolesDAO.save(Roles);
	}

	public void deleteRoles(Long id) {
		iRolesDAO.deleteById(id);
	}
}
