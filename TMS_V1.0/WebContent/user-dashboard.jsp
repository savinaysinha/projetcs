<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.yash.tmsapp.domain.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="commons/css/style.css">
</head>
<body>
	<div class="header">
		<jsp:include page="./static/header.jsp"></jsp:include>
	</div>
	<div class="main-body">
		<span><h2>
				Welcome&nbsp;
				<c:out value="${sessionScope.loggedInUser.getName()}"></c:out>
				<h1>
					<c:out value="${requestScope.msg}"></c:out>
				</h1>
			</h2></span>
		<div class="container">
			<div class="input-group">
				<span class="input-group-btn">
					<form action="SearchTextController" method="post" id="form1">
						<input type="text" class="form-control" name="search"
							placeholder="Search for...">
						<button class="btn btn-default" type="submit" form="form1"
							value="Submit">Go!</button>
					</form>
				</span>
			</div>
			<form action="DeleteSelectedController" method="get">
				<input class="btn btn-danger" type="submit" value="Delete Selected" />
				<div>
					<table class="w3-table-all w3-hoverable w3-centered">
						<tr>
							<th>Select</th>
							<!-- <th>id</th>
							<th>userId</th> -->
							<th>Title</th>
							<th>Objective</th>
							<th>Course</th>
							<th>Mode</th>
							<th>Batch Size</th>
							<th>Expectation</th>
							<th>Duration</th>
							<th colspan="2">Operation
							</td>

						</tr>
						<tr>

							<c:forEach items="${listByUserId}" var="training">
								<td><input type="checkbox" name="trainingId"
									value="${training.id}" />
								</form></td>
								<%-- <td>${training.id}</td>
								<td>${training.userId}</td> --%>
								<td>${training.title}</td>
								<td>${training.objective}</td>
								<td>${training.course}</td>
								<td>${training.mode}</td>
								<td>${training.batchSize}</td>
								<td>${training.expectation}</td>
								<td>${training.duration}</td>
								<td><a href="DeleteTraining?trainingId=${training.id}"
									class="btn btn-danger">Delete</a></td>
								<td><a href="UpdateTraining?trainingId=${training.id}"
									class="btn btn-primary">update</a></td>
								</br>
						</tr>
						</c:forEach>


					</table>
				</div>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="./static/footer.jsp"></jsp:include>
	</div>
	<script language="JavaScript" type="text/javascript">
		window.history.forward(1);
	</script>
	<script
		src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>