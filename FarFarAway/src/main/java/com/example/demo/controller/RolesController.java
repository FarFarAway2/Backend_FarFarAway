package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Roles;
import com.example.demo.service.RolesService;

@RestController
public class RolesController {

	@Autowired
	RolesService rolesService;

	@GetMapping("/roles")
	public List<Roles> listRoles() {
		return rolesService.listRoles();
	}

	@PostMapping("/roles")
	public Roles saveRoles(@RequestBody Roles roles) {
		return rolesService.saveRoles(roles);
	}

	@GetMapping("/roles/{id}")
	public Roles rolesXID(@PathVariable(name = "id") Long id) {
		return rolesService.rolesXID(id);
	}

	@PutMapping("/roles/{id}")
	public Roles updateRoles(@PathVariable(name = "id") Long id, @RequestBody Roles roles) {
		Roles rolesSelected = new Roles();
		Roles rolesUpdated = new Roles();

		rolesSelected = rolesService.rolesXID(id);
		rolesSelected.setRole_name(roles.getRole_name());

		rolesUpdated = rolesService.updateRoles(rolesSelected);

		return rolesUpdated;
	}

	@DeleteMapping("/roles/{id}")
	public void deleteRoles(@PathVariable(name = "id") Long id) {
		rolesService.deleteRoles(id);
	}
}
