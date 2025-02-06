package com.daikin.apartmentbuildingapp.model;

import java.util.ArrayList;
import java.util.List;

public class Building {
	private List<Room> rooms;
	private double defaultTemprature;

	public Building() {
		super();
		this.rooms = new ArrayList<>();
		this.defaultTemprature = 25.0;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void addRoom(Room room) {
		room.adjustTemprature(defaultTemprature);
		this.rooms.add(room);
	}

	public void reCalculateTemprature() {
		for (Room room : rooms) {
			if (room.isCoolingEnabled() && !room.isHeatingEnabled()) {
				double currentTemperature = room.getTemperature() - 0.1;
				room.setTemperature(currentTemperature);

			} else if (room.isHeatingEnabled() && !room.isCoolingEnabled()) {
				double currentTemperature = room.getTemperature() + 0.1;
				room.setTemperature(currentTemperature);
			}
		}
	}

}
