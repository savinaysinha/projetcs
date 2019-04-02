<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>New Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="commons/css/style.css">
</head>
<body>
	<div class="header">
		<jsp:include page="../static/header.jsp"></jsp:include>
	</div>
	<div class="main-body">
		<div class="container">
			<div class="jumbotron">
				<form action="./addUser.ds" method="post">
					<div class="form-group">
						<label for="Name">Name:</label> <input type="text"
							class="form-control" name="name" required="required">
					</div>
					<div class="form-group">
						<label for="email">Email address:</label> <input type="text"
							class="form-control" name="email" required="required">
					</div>
					<div class="form-group">
						<label for="loginName">Login Name:</label> <input type="text"
							class="form-control" name="loginName" required="required">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" name="password" required="required">
					</div>
					<div class="form-group">
						<label for="phone">Phone Number:</label> <input type="text"
							class="form-control" name="phone" required="required">
					</div>
					<button type="submit" class="btn btn-success">Register</button>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="../static/footer.jsp"></jsp:include>
	</div>
	<script
		src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>