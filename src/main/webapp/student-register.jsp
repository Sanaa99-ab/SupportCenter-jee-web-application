<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp" %>
<title>Home</title>
</head>
<body>	
<%@include file="includes/nav.jsp" %>
	
	<div class="container mt-4">
		<h1>Register</h1>
		
		<form action="StudentRegisterController" method="post">
			<div class="mb-3">
				<label>Name</label>
				<input type="text" name="name" class="form-control" required />
			</div>
			<div class="mb-3">
				<label>Date of birth</label>
				<input type="date" name="dob" class="form-control" required />
			</div>
			<div class="mb-3">
				<label>Address</label>
				<textarea name="address" class="form-control" required></textarea>
			</div>
			<div class="mb-3">
				<label>Contact</label>
				<input type="text" name="contact" class="form-control" required />
			</div>
			<div class="mb-3">
				<label>Email</label>
				<input type="email" name="email" class="form-control" required />
			</div>
			<div class="mb-3">
				<label>Password</label>
				<input type="password" name="password" class="form-control" required />
			</div>
			<div>
				<input type="submit" name="submit" value="Register" class="btn btn-outline-primary" />
			</div>
		</form>
		
	</div>
	
</body>
</html>