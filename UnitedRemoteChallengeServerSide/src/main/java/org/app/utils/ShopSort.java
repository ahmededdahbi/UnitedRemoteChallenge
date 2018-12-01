package org.app.utils;

import java.util.Collections;
import java.util.List;

import org.app.entity.AppUser;
import org.app.entity.Shop;

public class ShopSort {

	public static List<Shop> sortShopByDistanceFromUser(List<Shop> shops, AppUser user) {
		Collections.sort(shops, new ShopComparator());
		return shops;
	}

	public static double getDistanceBetweenTwoPoints(double lat1, double lon1, double lat2, double lon2) {
		double R = 6371;
		double dLat = deg2rad(lat2 - lat1);
		double dLon = deg2rad(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R * c;
		return d;
	}

	private static double deg2rad(double deg) {
		return deg * (Math.PI / 180);
	}
}
