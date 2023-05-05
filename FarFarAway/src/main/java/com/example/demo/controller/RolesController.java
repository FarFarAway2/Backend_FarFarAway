package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Roles;
import com.example.demo.service.RolesService;

@RestController
@RequestMapping("/api")
public class RolesController {

	@Autowired
	RolesService rolesService;

	@GetMapping("/roles")
	public List<Roles> listarRoless() {
		return rolesService.listRoles();
	}

	@PostMapping("/roles")
	public Roles salvarRoles(@RequestBody Roles roles) {
		return rolesService.saveRoles(roles);
	}

	@GetMapping("/roles/{id}")
	public Roles rolesXID(@PathVariable(name = "id") Long id) {
		return rolesService.rolesXID(id);
	}

	@PutMapping("/roles/{id}")
	public Roles actualizarRoles(@PathVariable(name = "id") Long id, @RequestBody Roles roles) {

		Roles rolesSeleccionada = new Roles();
		Roles rolesActualizada = new Roles();

		rolesSeleccionada = rolesService.rolesXID(id);

		rolesSeleccionada.setId_role(roles.getId_role());
		rolesSeleccionada.setRole_name(roles.getRole_name());

		rolesActualizada = rolesService.updateRoles(rolesSeleccionada);

		return rolesActualizada;
	}

	@DeleteMapping("/roles/{id}")
	public void eliminarRoles(@PathVariable(name = "id") Long id) {
		rolesService.deleteRoles(id);
	}
}
