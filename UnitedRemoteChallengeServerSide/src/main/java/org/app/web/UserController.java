package org.app.web;

import org.app.entity.AppUser;
import org.app.entity.Location;
import org.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private AccountService accountService; 
	
	@PostMapping("/register")
	public AppUser saveUser(@RequestBody AppUser user){
		user.setLocation(new Location(28, -10));
		accountService.saveUser(user);
		accountService.addRoleToUser(user.getUsername(), "USER");
		return user;
	}
	
}
