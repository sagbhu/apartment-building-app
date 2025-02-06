package com.daikin.apartmentbuildingapp.model;

import com.daikin.apartmentbuildingapp.model.enums.CommonRoomType;

public class CommonRoom extends Room {
	private CommonRoomType roomType;

	public CommonRoom(String id, CommonRoomType roomType) {
		super(id);
		this.roomType = roomType;
	}

	public CommonRoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(CommonRoomType roomType) {
		this.roomType = roomType;
	}

	@Override
	public String getRoomDetails() {
		return roomType.toString();
	}
}
