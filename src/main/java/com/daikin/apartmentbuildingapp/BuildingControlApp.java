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
	private static final long serialVersionUID = 1L;
	private Building building = new Building();
	private ScheduledExecutorService scheduler;

	// this is a Scheduler which re calculate temprature in every 5 minutes.
	@Override
	public void init() throws ServletException {
		super.init();
		scheduler = Executors.newScheduledThreadPool(1);
		ServletContext context = getServletContext();

		scheduler.scheduleAtFixedRate(() -> {
			building.reCalculateTemprature();
			context.setAttribute("building", building);
		}, 0, 1, TimeUnit.MINUTES);
	}

	// This method will handle all GET requests, coming from client. 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("building", building);
		RequestDispatcher dispacher = request.getRequestDispatcher("/index.jsp");
		dispacher.forward(request, response);
	}

	// This method will handle all POST requests, coming from client. 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("changeTemprature") != null) {
			double temp = Double.parseDouble(request.getParameter("changeTemprature"));
			building.getRooms().forEach(room -> room.adjustTemprature(temp));
			request.setAttribute("building", building);
			RequestDispatcher dispacher = request.getRequestDispatcher("/index.jsp");
			dispacher.forward(request, response);
		}

		if (request.getParameter("submit") != null) {
			String id = request.getParameter("roomId");
			String roomType = request.getParameter("roomType");
			String ownerName = request.getParameter("ownerName");
			if (roomType.equalsIgnoreCase("Apartment") && (ownerName != null)) {
				building.addRoom(new Apartment(id, ownerName));
			} else {
				if (roomType.equalsIgnoreCase(CommonRoomType.GYM.toString())) {
					building.addRoom(new CommonRoom(id, CommonRoomType.GYM));
				} else if (roomType.equalsIgnoreCase(CommonRoomType.LIBRARY.toString())) {
					building.addRoom(new CommonRoom(id, CommonRoomType.LIBRARY));
				} else {
					building.addRoom(new CommonRoom(id, CommonRoomType.LAUNDRY));
				}
			}

			RequestDispatcher dispacher = request.getRequestDispatcher("/index.jsp");
			dispacher.forward(request, response);
		}
	}

	// This method will shutdown executor service after completion the task.
	@Override
	public void destroy() {
		if (scheduler != null) {
			scheduler.shutdown();
		}
	}

}
