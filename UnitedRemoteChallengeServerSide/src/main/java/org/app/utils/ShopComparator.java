package org.app.utils;

import java.util.Comparator;

import org.app.entity.Shop;

public class ShopComparator implements Comparator<Shop> {

	@Override
	public int compare(Shop shop1, Shop shop2) {
		return shop1.getLocation().compareTo(shop2.getLocation());
	}
	
}
