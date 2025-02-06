package com.daikin.apartmentbuildingapp.model;

import java.util.Random;

public class Room {
	private String id;
	private double temperature;
	private boolean heatingEnabled;
	private boolean coolingEnabled;

	public Room(String id) {
		this.id = id;
		this.temperature = 10 + new Random().nextInt(31);
		this.heatingEnabled = false;
		this.coolingEnabled = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public boolean isHeatingEnabled() {
		return heatingEnabled;
	}

	public void setHeatingEnabled(boolean heatingEnabled) {
		this.heatingEnabled = heatingEnabled;
	}

	public boolean isCoolingEnabled() {
		return coolingEnabled;
	}

	public void setCoolingEnabled(boolean coolingEnabled) {
		this.coolingEnabled = coolingEnabled;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", " + getRoomDetails() + ", temperature=" + temperature + ", heatingEnabled="
				+ heatingEnabled + ", coolingEnabled=" + coolingEnabled + "]";
	}

	public String getRoomDetails() {
		return null;
	}

	public void adjustTemprature(double requestedTemp) {
		if (temperature < requestedTemp) {
			setHeatingEnabled(true);
			setCoolingEnabled(false);
		} else if (temperature > requestedTemp) {
			setHeatingEnabled(false);
			setCoolingEnabled(true);
		} else {
			setHeatingEnabled(false);
			setCoolingEnabled(false);
		}
	}
}
