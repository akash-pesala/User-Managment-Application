<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div>
			<a href="" class="navbar-brand">User Management System</a>
		</div>
		<ul class="navbar-nav">
			<li><a href="/list">Users</a></li>
		</ul>
	</nav>
	<br>
	<div class="row"><
		<div class ="container">
			<h3 class="align-center">List of Users</h3>
			<hr>
			
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success"> Add New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<td>ID</td>
						<td>Name</td>
						<td>Email</td>
						<td>Country</td>
						<td>Actions</td>
					</tr>
				</thead>
			
				<tbody>
					<c:forEach var="user" items = "${listUser}">
						<tr>
							<td> <c:out value="${user.id}" /> </td>
							<td> <c:out value="${user.name}" /> </td>
							<td> <c:out value="${user.email}" /> </td>
							<td> <c:out value="${user.country}" /> </td>
						
							<td>
								<a href="edit?id=<c:out value = '${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="update?id=<c:out value = '${user.id}' />">Update</a>
							</td>
						</tr>
					
					</c:forEach>
				
				</tbody>
			</table>
		</div>
	
	
	</div>
</body>
</html>