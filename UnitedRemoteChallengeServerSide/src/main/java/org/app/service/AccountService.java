package org.app.service;

import org.app.entity.AppRole;
import org.app.entity.AppUser;
import org.app.entity.Shop;

public interface AccountService {
	
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username, String rolename);
	public AppUser findUserByUsername(String username);
	public void addLikedShops(String username, long idshop);
	public void removeLikedShop(String username, long idshop);

}
