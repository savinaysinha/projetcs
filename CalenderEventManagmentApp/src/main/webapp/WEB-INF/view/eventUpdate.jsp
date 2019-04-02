<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Event</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="header">
		<%-- <jsp:include page=" ../static/header.jsp"></jsp:include> --%>
	</div>
	<div class="main-body">
		<div class="container">
			<div class="jumbotron">
				<form action="./updatedEvent.ds" method="post">
					<div class="form-group">
						<label for="name">Name:</label> <div> <form:errors path="event.name"/></div>
						<input type="text" class="form-control" name="name"  value="${event.name}">
					</div>
					<div class="form-group">
						<label for="startDate">Start Date:</label> <div style="color: red;"><form:errors path="event.startDate"/></div>
						<input type="date" class="form-control" name="startDate" value="${event.startDate}" class="form-control" >
					</div>
					<div class="form-group">
						<label for="endDate">End Date:</label> <div style="color: red;"><form:errors path="event.endDate"/></div>
						<input type="date" class="form-control" name="endDate" value="${event.endDate}" class="form-control" >
					</div>
					<div class="form-group">
						<label for="eventType">Event Type:</label> <div style="color: red;"><form:errors path="event.eventType"/></div>
						<input type="text" name="eventType" value="${event.eventType}" class="form-control">	
					</div>
					<div class="form-group">
						<label for="eligibility">Eligibility:</label> <div style="color: red;"><form:errors path="event.eligibility"/></div>
						<input type="text" name="eligibility" value="${event.eligibility}" class="form-control">	
					</div>
						
					<div class="form-group">
						<label for="location">Location:</label> <div style="color: red;"><form:errors path="event.location"/></div>
						<input type="text" name="location" value="${event.location}" class="form-control">	
					</div>

					<div class="form-group">
						<label for="capacity">Capacity:</label> <div style="color: red;"><form:errors path="event.capacity"/></div>
						<input type="text" class="form-control" name="capacity" value="${event.capacity}">
					</div>
					<input type="hidden" name="id" value="${event.id}">
					<button type="submit" class="btn btn-success">Update</button>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<%-- 	<jsp:include page="../static/footer.jsp"></jsp:include> --%>
	</div>
	<script
		src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>