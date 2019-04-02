<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title></title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<s:url value="/static/css/style.css" var="urlcss"></s:url>
<link href="${urlcss}" rel="stylesheet" />
</head>
<body>
<table border="1px" align="center" width="80%">
		<tr>
			<!--Header of Page  -->
			<td height="30px"><jsp:include page="./include/header.jsp"></jsp:include>

			</td>
		</tr>
		<tr>
			<!--Menu of Page  -->
			<td height="30px"><jsp:include page="./include/menus.jsp"></jsp:include>
			</td>
		</tr>
		<td height="400px" valign="top">
					<table border="1px">
					<tr>
						<td>Id</td>
						<td>Name</td>
						<td>Phone</td>
						<td>Address</td>
						<td>Email</td>
						<td>Role</td>
						<td>Login Name</td>
						<td>Created_At</td>
						<td>Updated_At</td>
					</tr>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td>${user.phone}</td>
							<td>${user.address}</td>
							<td>${user.email}</td>
							<td>${user.role}</td>
							<td>${user.loginname}</td>
							<td>${user.created_At}</td>
							<td>${user.updated_At}</td>
						</tr>
						<br>
					</c:forEach>
				</table>
			</td>
			<tr>
			<!--Footer of Page  -->
			<td height="50px">
			<jsp:include page="./include/footer.jsp"></jsp:include>

			</td>
		</tr>
</body>
</html>