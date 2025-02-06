package com.daikin.apartmentbuildingapp.model;

public class Apartment extends Room {

	private String ownerName;

	public Apartment(String id, String ownerName) {
		super(id);
		this.ownerName = ownerName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String getRoomDetails() {
		return ownerName;
	}

}
