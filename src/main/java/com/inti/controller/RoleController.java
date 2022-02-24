package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Role;
import com.inti.service.interfaces.IRoleService;

@RestController // RestFul WS (http: post, put, get et delete)
@CrossOrigin
public class RoleController {
	@Autowired // IRoleService roleService=new RoleService(); => @Service
	IRoleService roleService;

	// @RequestMapping(value="roles",method=RequestMethod.GET) //
	// localhost:9090/roles
	@GetMapping("roles") // localhost:9090/roles
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@GetMapping("roles/{idR}") // localhost:9090/roles/6
	// @RequestMapping(value="roles/{idR}",method=RequestMethod.GET)
	public Role findOne(@PathVariable("idR") Long idRole) { // (idRole = 6)
		return roleService.findOne(idRole); // roleService.findOne(6)
	}

	@PostMapping("roles") // localhost:9090/roles method: post => Les données (le body de la requête http)
	// @RequestMapping(value="roles",method=RequestMethod.POST)
	public Role saveRole(@RequestBody Role role) {
		return roleService.save(role);
	}

	@DeleteMapping("roles/{idRole}")
	// @RequestMapping(value="roles/{idRole}",method=RequestMethod.DELETE)
	public void deleteRole(@PathVariable("idRole") Long idRole) {
		roleService.delete(idRole);
	}

	@PutMapping("roles/{idR}")
	//@RequestMapping(value="roles/{idR}",method = RequestMethod.PUT)
	public Role updateRole(@PathVariable("idR") Long idRole, @RequestBody Role role) {
		Role currentRole = roleService.findOne(idRole);
		currentRole.setLibelle(role.getLibelle());
		return roleService.save(currentRole);
	}
}
