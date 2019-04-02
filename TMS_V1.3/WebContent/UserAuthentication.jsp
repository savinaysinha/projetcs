<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Log In</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="commons/css/style.css">
</head>
<body>
	<div class="header">
		<jsp:include page="./static/header.jsp"></jsp:include>
	</div>
	
	<div class="main-body">
		<div class="container">
			<div class="jumbotron" style="margin-top: 30px;">
			<h2 style="color:red; text-align: center;">${param.msg}</h2>
			<c:if test="${sessionScope.loggedInUserId == null}">
				<form action="UserAuthenticationController" method="post">
					<div class="form-group">
						<label for="loginName">Login Name:</label> <input type="text"
							class="form-control" name="loginName">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" name="password">
					</div>
					<button type="submit" class="btn btn-info">LogIn</button>
					<a href="UserRegistration.jsp" class="btn btn-success">Register</a>
				</form>
				</c:if>
				<c:if test="${sessionScope.loggedInUserId != null}">
				<% response.sendRedirect("UserDashboardController"); %>
				</c:if>
			</div>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="./static/footer.jsp"></jsp:include>
	</div>
	<script
		src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>