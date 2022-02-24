package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Role;

public interface IRoleService {
	List<Role> findAll();

	Role findOne(Long idRole);

	Role save(Role role);

	void delete(Long idRole);
}
