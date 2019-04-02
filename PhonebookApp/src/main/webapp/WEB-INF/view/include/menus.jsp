<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<s:url value="/logout" var="logout"></s:url>
<c:if test="${sessionScope.user==null}">
	<a href="./index">Home</a> |
<a href="./services">Services</a> |
<a href="./about">About</a> |
<a href="./contacts">Contact</a>
</c:if>

<c:if test="${sessionScope.userRole==1}">
	<a href="./dashboard">Home</a> |
<a href="./addUser">Add User</a> |
<a href="./listUser">List User</a> |
<a href="${logout}">Logout</a>
</c:if>

<c:if test="${sessionScope.userRole==2}">
	<a href="#">Home</a> |
<a href="#">Add Contact</a> |
<a href="#">List Contact</a> |
<a href="${logout}">Logout</a>
</c:if>
