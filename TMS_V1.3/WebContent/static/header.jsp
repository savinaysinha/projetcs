<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
	<div class="nav-head">
		<c:if test="${sessionScope.loggedInUserId == null }">
			<a class="navbar-brand" href="index.jsp"><span
				class="glyphicon glyphicon-tower" aria-hidden="true"></span>&nbspTMS</a>
			<button type="button" id="nav-toggle-button" class="navbar-toggle "
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		
		</c:if>
		<c:if test="${sessionScope.loggedInUserId != null }">
			<a class="navbar-brand" href=#><span
				class="glyphicon glyphicon-tower" aria-hidden="true"></span>&nbspTMS</a>
			<button type="button" id="nav-toggle-button" class="navbar-toggle "
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>

			</button>
		<h3><span  class="username label label-default pull-right"  style=" margin-top: 15px; margin-right: 10px;"><c:out
				value="${sessionScope.loggedInUser.getName()}"></c:out></span></h3>
		</c:if>
	</div>
	<div class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<jsp:include page="mainmenu.jsp"></jsp:include>
		</ul>
		<!-- <div class=" nav-button navbar-right">
				<button type="button" class="btn btn-primary">LogIn</button>
				<button type="button" class="btn btn-success">SignUp</button>
			</div> -->
	</div>
</nav>