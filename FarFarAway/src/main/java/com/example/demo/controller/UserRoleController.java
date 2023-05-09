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

import com.example.demo.dto.UserRole;
import com.example.demo.service.UserRoleService;

@RestController
public class UserRoleController {

	@Autowired
	UserRoleService userRoleService;

	@GetMapping("/userroles")
	public List<UserRole> listUserRoles() {
		return userRoleService.listUserRoles();
	}

	@PostMapping("/userroles")
	public UserRole saveUserRole(@RequestBody UserRole userRole) {
		return userRoleService.saveUserRole(userRole);
	}

	@GetMapping("/userroles/{id}")
	public UserRole userRoleXID(@PathVariable(name = "id") Long id) {
		return userRoleService.userRoleXID(id);
	}

	@PutMapping("/userroles/{id}")
	public UserRole updateUserRole(@PathVariable(name = "id") Long id, @RequestBody UserRole userRole) {

		UserRole userRoleSeleccionado = new UserRole();
		UserRole userRoleActualizado = new UserRole();

		userRoleSeleccionado = userRoleService.userRoleXID(id);
		userRoleSeleccionado.setId_user(userRole.getId_user());
		userRoleSeleccionado.setId_role(userRole.getId_role());

		userRoleActualizado = userRoleService.updateUserRole(userRoleSeleccionado);

		return userRoleActualizado;
	}

	@DeleteMapping("/userroles/{id}")
	public void deleteUserRole(@PathVariable(name = "id") Long id) {
		userRoleService.deleteUserRole(id);
	}
}
