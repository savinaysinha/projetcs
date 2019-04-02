<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${sessionScope.loggedInUserId == null }">
	<li><a href="index.jsp">Home</a></li>
	<li><a href="About.jsp">About</a></li>
	<li><a href="ContactUs.jsp">Contact us</a></li>
</c:if>
<c:if test="${sessionScope.loggedInUserId != null }">
	<li><a href="./toAddTraining.ds">Add Training</a></li>
	<li><a href="./UserDashboard.ds">Show Training</a></li>
	<li><a href="./logout.ds">Logout</a></li>
</c:if>