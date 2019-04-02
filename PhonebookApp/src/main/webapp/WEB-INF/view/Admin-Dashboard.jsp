<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
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

		<tr >
			<!--Body of Page  -->
			<td height="400px" valign="top">
				<h1>Admin-Dash Board Page</h1>
				<hr>
				<jsp:include page="./admin/dashboard.jsp"></jsp:include></td>
		</tr>
		<tr>
			<!--Footer of Page  -->
			<td height="50px">
			<jsp:include page="./include/footer.jsp"></jsp:include>

			</td>
		</tr>


	</table>
</body>
</html>
