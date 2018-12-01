package org.app.service;

import java.util.List;

import org.app.entity.Shop;

public interface ShopService {

	public List<Shop> getListOfShops(String username);
	public List<Shop> getListOfPreferredShops(String username);
	
}
