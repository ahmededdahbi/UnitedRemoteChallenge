package org.app.service;

import java.util.Date;

import org.app.dao.AppRoleRepository;
import org.app.dao.AppUserRepository;
import org.app.dao.ShopRepository;
import org.app.entity.AppRole;
import org.app.entity.AppUser;
import org.app.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AppUserRepository userRepository;
	
	@Autowired
	private AppRoleRepository roleRepository;
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Override
	public AppUser saveUser(AppUser user) {
		String hash = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hash);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		AppRole role = roleRepository.findByRolename(rolename);
		AppUser user = userRepository.findByUsername(username);
		user.getRoles().add(role);
	}

	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void addLikedShops(String username, long idshop) {
		AppUser user = userRepository.findByUsername(username);
		Shop shop = shopRepository.findById(idshop).get();
		user.getLikedshops().add(shop);
	}

	@Override
	public void removeLikedShop(String username, long idshop) {
		AppUser user = userRepository.findByUsername(username);
		Shop shop = shopRepository.findById(idshop).get();
		shop.setDisLikeOn(new Date());
		user.getLikedshops().remove(shop);
	}

}
