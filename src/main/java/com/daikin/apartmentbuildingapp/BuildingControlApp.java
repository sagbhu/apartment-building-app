package com.daikin.apartmentbuildingapp;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daikin.apartmentbuildingapp.model.Apartment;
import com.daikin.apartmentbuildingapp.model.Building;
import com.daikin.apartmentbuildingapp.model.CommonRoom;
import com.daikin.apartmentbuildingapp.model.enums.CommonRoomType;

/**
 * 
 * @author Sagar Dixir
 *
 *This is a web Servlet, used to handle all client request, coming to server.
 */
@WebServlet
public class BuildingControlApp extends HttpServlet {
	

	// This method will handle all GET requests, coming from client. 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	// This method will handle all POST requests, coming from client. 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
