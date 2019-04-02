<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

		<tr>
			<!--Body of Page  -->
			<td height="400px" valign="top">
				<h1>Registation Page</h1>
				<hr> <s:url value="./registrationProcess" var="registrationProcess"></s:url>
				<form:form action="${registrationProcess}" modelAttribute="user">
					<table align="center">
						<tr>
							<td><form:label path="name">Name: </form:label>
							</td>
							<td><form:input path="name" />
							</td>
							<td><div class="has-error"><form:errors path="name"></form:errors>
							</div></td>

						</tr>
						<tr>
							<td><form:label path="address">Address:</form:label></td>
							<td><form:input path="address" /></td>
							<td><div class="has-error"><form:errors path="address"></form:errors>
							</div></td>
						</tr>
						<tr>
							<td><form:label path="phone">Phone:</form:label></td>
							<td><form:input path="phone" /></td>
							<td><div class="has-error"><form:errors path="phone"></form:errors>
							</div></td>
						</tr>
							<tr>
							<td><form:label path="email">Email:</form:label></td>
							<td><form:input path="email" /></td>
							<td><div class="has-error"><form:errors path="email"></form:errors>
							</div></td>
						</tr>
							<tr>
							<td><form:label path="loginname">Login Name:</form:label></td>
							<td><form:input path="loginname" /></td>
							<td><div class="has-error"><form:errors path="loginname"></form:errors>
							</div></td>
						</tr>
							<tr>
							<td><form:label path="password">Password:</form:label></td>
							<td><form:password path="password" /></td>
							<td><div class="has-error"><form:errors path="password"></form:errors>
							</div></td>
						</tr>
						<tr>
							<td></td>
							<td align="left"><form:button class="btn btn-success">Register</form:button>
							</td>
						</tr>
					</table>
				</form:form>

			</td>

		</tr>
		<tr>
			<!--Footer of Page  -->
			<td height="50px"><jsp:include page="./include/footer.jsp"></jsp:include>

			</td>
		</tr>


	</table>
</body>
</html>
