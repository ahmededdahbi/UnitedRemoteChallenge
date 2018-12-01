package org.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Shop {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private Date disLikeOn;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Location location;
	
	public Shop() {
		super();
	}

	public Shop(String nom, Location location) {
		super();
		this.nom = nom;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getDisLikeOn() {
		return disLikeOn;
	}

	public void setDisLikeOn(Date disLikeOn) {
		this.disLikeOn = disLikeOn;
	}	
}
