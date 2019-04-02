<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Training</title>
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
				<form action="./AddTraining.ds" method="post">
					<div class="form-group">
						<label for="Title">Title:</label> <input type="text"
							class="form-control" name="title" required="required" placeholder="Hibernate">
					</div>
					<div class="form-group">
						<label for="objective">Objective:</label> <input type="text"
							class="form-control" name="objective" required="required" placeholder="To train for ...">
					</div>
					<div class="form-group">
						<label for="course">Course:</label> <input type="text"
							class="form-control" name="course" required="required" placeholder="Hibernate">
					</div>
					<div class="form-group">
						<div class="input-group">
						<span class="input-group-addon">Mode</span>
							<span class="input-group-addon"> <input type="radio" name="mode" value=0
								aria-label="Online">
							</span><label for="online" class="form-control">Online</label>
							<span class="input-group-addon"> <input type="radio" name="mode" value=1
								aria-label="Offline">
							</span><label for="online" class="form-control">Offline</label>
						</div>
					</div>

					<div class="form-group">
						<label for="batchSize">Batch Size:</label> <input type="text" class="form-control" name="batchSize" required="required" placeholder="2 (in person)">
					</div>
					<div class="form-group">
						<label for="Expectation">Expectation:</label> 
						<textarea 	class="form-control" name="expectation" cols=15 rows="10" placeholder="Expectations from L&D"> </textarea>
					</div>
					<div class="form-group">
						<label for="Duration">Duration:</label> <input type="text"
							class="form-control" name="duration" required="required" placeholder="2 (in months)">
					</div>
					<button type="submit" class="btn btn-success">Submit</button>
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