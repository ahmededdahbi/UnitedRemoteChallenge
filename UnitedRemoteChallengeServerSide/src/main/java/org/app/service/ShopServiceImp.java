package org.app.service;

import java.util.List;

import org.app.dao.ShopRepository;
import org.app.entity.AppUser;
import org.app.entity.Shop;
import org.app.utils.DateComparator;
import org.app.utils.ShopSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShopServiceImp implements ShopService {

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private AccountServiceImp userService;

	@Override
	public List<Shop> getListOfShops(String username) {
		List<Shop> shops = shopRepository.findAll();
		AppUser user = userService.findUserByUsername(username);
		List<Shop> likedshops = (List<Shop>) user.getLikedshops();	
		shops = DateComparator.removeLikedShopFromList(shops, likedshops);
		shops = DateComparator.removeDislikedShopFromListBeforeTime(shops);
		return ShopSort.sortShopByDistanceFromUser(shops, user);
	}

	@Override
	public List<Shop> getListOfPreferredShops(String username) {
		AppUser user = userService.findUserByUsername(username);
		List<Shop> likedshops = (List<Shop>) user.getLikedshops();
		return ShopSort.sortShopByDistanceFromUser(likedshops, user);
	}

}
