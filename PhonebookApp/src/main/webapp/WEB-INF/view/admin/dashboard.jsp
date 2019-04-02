<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<table border="1px">
			<tr>
				<th>Select</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Email</th>
				<th>Role</th>
				<th>Login Name</th>
				<th>Created_At</th>
				<th>Updated_At</th>
				<th>Operation</th>
			</tr>
			<tr>
			<form action="./deleteSelected" method="get">
				<input type="submit" value="Delete Selected" />
				<c:forEach items="${fetchedUsers}" var="fetcheduser">
					<td><input type="checkbox" name="id" value="${fetcheduser.id}" /></td>
					<td>${fetcheduser.name}</td>
					<td>${fetcheduser.phone}</td>
					<td>${fetcheduser.address}</td>
					<td>${fetcheduser.email}</td>
					<td>${fetcheduser.role}</td>
					<td>${fetcheduser.loginname}</td>
					<td>${fetcheduser.created_At}</td>
					<td>${fetcheduser.updated_At}</td>
					<td><a href="./delete?id=${fetcheduser.id}">Delete</a></td>
					</br>
					</tr>
				</c:forEach>
			</form>

		</table>