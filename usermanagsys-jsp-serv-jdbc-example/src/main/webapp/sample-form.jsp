<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>User Management Application</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div>
			<a href="" class="navbar-brand">User Management Application</a>
		</div>
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/list">Users </a> </li>
		</ul>
	</nav>
	
	<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
				<h2>
					<c:if test="${user != null }">Edit User</c:if>
					<c:if test="${user == null }">Add New User</c:if>			
				</h2>
				
			
				<c:if test="${user != null}">
					<form action="update" method="post">
						<input type="hidden" name="id" value="<c:out value = '${user.id}'/>" />
				</c:if>

				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>
					
					<fieldset class="form-group">
						<label>User Name : </label>
						<input type="text" class="form-control" name = "name" value = "<c:out value = '${user.name}'/>" required>
					</fieldset>
					
					<fieldset class="form-group">
						<label>User Email : </label>
						<input type="text" class="form-control" name = "email" value = "<c:out value = '${user.email}'/>" required>
					</fieldset>
					
					<fieldset class="form-group">
						<label>User Country : </label>
						<input type="text" class="form-control" name = "country" value = "<c:out value = '${user.country}'/>" required>
					</fieldset> 
					
					<button class="btn btn-success">Save</button>
					
					</form>
			</div>
		
		</div>
	</div>
	
	
	
	
</body>
</html>