<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.project.model.Sport"%>
<%@ page import="com.project.model.School"%>
<%@ page import="com.project.model.Season"%>
<%@ page import="com.project.repo.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<title>Add Sport</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>


</head>
<body>
	<h1>Create New Sport</h1>

	<form action="/projectncaa-web-jsp/AddSport">

		<div class="form-group">
			<label for="name">Sport Name</label> <input type="text"
				class="form-control" name="name" placeholder="Enter name here">

		</div>



		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">School</label>
			</div>
			<select class="custom-select" id="inputGroupSelect01">
				<option selected>Select a School</option>
				<%
					int i = 1;
					SchoolRepo schoolrepo = new SchoolRepo();
					List<School> schoolList = schoolrepo.getSchools();
				for (School school : schoolList) {
   					%> <option value="<%out.print(i);%>"> <% out.print(school.getName()); %></option>
				<%
					i++;
					}
				%>
			</select>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect02">Season</label>
			</div>
			<select class="custom-select" id="inputGroupSelect01">
				<option selected>Select a Season</option>
				<%
					int j = 1;
					SportRepo sportrepo = new SportRepo();
					List<Season> seasonList = sportrepo.getSeasons();
				for (Season season : seasonList) {
   					%> <option value="<%out.print(j);%>"> <% out.print(season.getName()); %></option>
				<%
					j++;
					}
				%>
			</select>
		</div>

		<input type="submit" value="Submit">
	</form>

	<h3>
		<a href="newindex.html">Back to Homepage</a>
	</h3>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>


