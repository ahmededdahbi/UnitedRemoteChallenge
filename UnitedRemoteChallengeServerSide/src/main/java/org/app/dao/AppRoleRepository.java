package org.app.dao;

import org.app.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

	public AppRole findByRolename(String rolename);
	
}
