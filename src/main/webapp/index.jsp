<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.daikin.apartmentbuildingapp.model.*"%>
<%
Building building = null;
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="refresh" content="300">
<title>Apartment Building App</title>
<style>
#addForm {
	display: none;
	margin-top: 20px;
}

#tempChangeForm {
	display: none;
	margin-top: 20px;
}

#currentStateForm {
	display: none;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div style="border: 1px solid black; width: 45%; margin-left: 25%;">
		<div style="border-bottom: 1px solid black; display: flex; justify-content: center">
			<h3>Building Control</h3>
		</div>
		<div style="padding: 50px;">
			<form action="BuildingControlApp" method="GET">
				<button type="button" onclick="addRoom()">Add Room</button>
				<button type="button" onclick="changeTemp()">Change Temprature</button>
				<button type="submit" name="show" onclick="getCurrentStatus()">Show Building Current Status</button>
			</form>


			<div id="addForm">
				<h3>Add Room</h3>
				<form action="BuildingControlApp" method="POST">
					<label for="roomId">Room ID:</label> 
					<input type="text" id="roomId" name="roomId" required>
					 <br> <br> 
					<label for="roomType">Room Type:</label> 
					<input type="text" id="roomType" name="roomType" required>
					 <br> <br> 
					<label for="ownerName">Owner Name:</label> 
					<input type="text" id="ownerName" name="ownerName" required>
					 <br> <br>
					<button type="submit" name="submit">Submit</button>
				</form>
			</div>

			<div id="tempChangeForm">
				<h3>Change Temprature</h3>
				<form action="BuildingControlApp" method="POST">
					<label for="temprature">Temprature:</label>
					<input type="text" id="temprature" name="changeTemprature" required>
					 <br><br>
					<button type="submit">Submit</button>
				</form>
			</div>

			<div id="currentStateForm">
				<h3>Current State</h3>
			</div>
			
			<div>
				<h3>Current Status:</h3>
				<%
				if (request.getAttribute("building") != null) {
					building = (Building) request.getAttribute("building");
				for (Room room : building.getRooms()) {
				%>
				<li><%=room%></li>
				<%
				}
				}
				%>
			</div>
		</div>

	</div>
	<script>
		
		function addRoom() {
			var addForm = document.getElementById("addForm");
			var tempChangeForm = document.getElementById("tempChangeForm");
			var currentStateForm = document.getElementById("currentStateForm");
			
			if (addForm.style.display === "none") {
				addForm.style.display = "block";
				tempChangeForm.style.display = "none";
				currentStateForm.style.display = "none";
			} else {
				addForm.style.display = "none";
			}
		}
		
		function changeTemp() {
			var addForm = document.getElementById("addForm");
			var tempChangeForm = document.getElementById("tempChangeForm");
			var currentStateForm = document.getElementById("currentStateForm");
			
			if (tempChangeForm.style.display === "none") {
				tempChangeForm.style.display = "block";
				currentStateForm.style.display = "none";
				addForm.style.display = "none";
			} else {
				tempChangeForm.style.display = "none";
			}
		}
		
		function getCurrentStatus() {
			var addForm = document.getElementById("addForm");
			var tempChangeForm = document.getElementById("tempChangeForm");
			var currentStateForm = document.getElementById("currentStateForm");
			
			if (currentStateForm.style.display === "none") {
				currentStateForm.style.display = "block";
				addForm.style.display = "none";
				tempChangeForm.style.display = "none";
			} else {
				currentStateForm.style.display = "none";
			}
		}
	</script>

</body>
</html>
