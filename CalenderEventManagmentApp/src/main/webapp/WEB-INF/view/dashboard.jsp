<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="style.css">
</head>


<%-- <%
SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");

String startDate = sm.format(request.getParameter("startDate1"));
String endDate = sm.format(request.getParameter("endDate1"));
%>

<c:set var="startDate" value=<%=startDate%>></c:set>
<c:set var="endDate" value=<%=endDate%>></c:set> --%>

<body>
	<div class="header">
		<jsp:include page="../static/header.jsp"></jsp:include>
	</div>
	<div class="main-body">
		<div class="container">
	<!-- 		<div class="input-group">
				<span class="input-group-btn">
					<form action="./SearchText.ds" method="post" id="form1">
						<input type="text" class="form-control" name="search"
							placeholder="Search for...">
						<button class="btn btn-default" type="submit" form="form1"
							value="Submit">Go!</button>
					</form>
				</span>
			</div> -->
			<div class="deleteSelected" style="text-align:right; position: relative; top: 25px; ">
			<form action="./deleteSelected.ds" method="get">
				<input class="btn btn-danger" type="submit" value="Delete Selected" />
				</div>
				<div>
					<table class="w3-table-all w3-hoverable w3-centered">
						<tr>
							<th>Select</th>
							<th>id</th>
							<th>Name</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Duration</th>
							<th>Event Type</th>
							<th>Eligibility</th>
							<th>Location</th>
							<th>Capacity</th>
							<th colspan="2">Operation
							</td>

						</tr>
						<tr>

							<c:forEach items="${listById}" var="event">
								<td><input type="checkbox" name="eventId"
									value="${event.id}" />
								</form></td>
								<td>${event.id}</td>
								<td>${event.name}</td>
								<td>${event.startDate}</td>
								<td>${event.endDate}</td>
								<td>${event.duration}</td>
								<td>${event.eventType}</td>
								<td>${event.eligibility}</td>
								<td>${event.location}</td>
								<td>${event.capacity}</td>
								<td><a href="./Delete.ds?eventId=${event.id}"
									class="btn btn-danger">Delete</a></td>
								<td><a href="./updateEventform.ds?eventId=${event.id}"
									class="btn btn-primary">update</a></td>
								</br>
						</tr>
						</c:forEach>


					</table>
				</div>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="../static/footer.jsp"></jsp:include>
	</div>
	<!-- <script language="JavaScript" type="text/javascript">
		window.history.forward(1);
	</script> -->
	<script
		src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>