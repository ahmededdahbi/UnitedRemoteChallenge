package org.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.app.utils.ShopSort;

@Entity
public class Location implements Comparable<Location> {

	@Id
	@GeneratedValue
	private Long id;
	private double latitude;
	private double longitude;

	public Location() {
		super();
	}

	public Location(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getlatitude() {
		return latitude;
	}

	public void setlatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getlongitude() {
		return longitude;
	}

	public void setlongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public int compareTo(Location location) {
		double distance =  ShopSort.getDistanceBetweenTwoPoints(location.latitude, location.latitude, this.latitude, this.longitude);
		if(distance > 0) return -1;
		if(distance < 0) return 1;
		return  0;
	}

}
