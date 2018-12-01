package org.app.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.app.entity.Shop;

public class DateComparator {

	private static final int NUMBER_OF_NOT_DISPLAY_HOURS = 2;

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	public static List<Shop> removeDislikedShopFromListBeforeTime(List<Shop> shops) {
		if (shops == null)
			return shops;
		List<Shop> shopstoRemove = new ArrayList<>();
		shops.forEach(shop -> {
			if (shop.getDisLikeOn() != null)
				if (DateComparator.getDateDiff(new Date(),shop.getDisLikeOn(), 
						TimeUnit.HOURS) < NUMBER_OF_NOT_DISPLAY_HOURS) {
					shopstoRemove.add(shop);
				}
		});
		shopstoRemove.forEach(shop -> {
			shops.remove(shop);
		});
		return shops;
	}

	public static List<Shop> removeLikedShopFromList(List<Shop> shops, List<Shop> likedshops) {
		if (shops == null || likedshops == null)
			return shops;
		likedshops.forEach(shop -> {
			if (shops.contains(shop)) {
				shops.remove(shop);
			}
		});
		return shops;
	}

}
