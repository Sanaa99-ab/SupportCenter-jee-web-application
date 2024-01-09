<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
<title>Center Manager Login</title>
</head>
<body>
	<%@include file="includes/nav.jsp"%>

	<div class="container">

		<c:set var="regOk" value="${requestScope.registerOk}" />
		<c:set var="regNo" value="${requestScope.registerNo}" />
		<c:choose>
			<c:when test="${regOk != null}">

				<div class="alert alert-success mt-1" role="alert">
					<c:out value="${regOk}" />
				</div>
			</c:when>
			<c:when test="${regNo != null}">
				<div class="alert alert-danger mt-2" role="alert">
					<c:out value="${regNo}" />
				</div>
			</c:when>
			<c:otherwise>
		  </c:otherwise>
		</c:choose>
		
		<form action="CenterManagerLogin" method="post" class="w-50 m-auto mt-4">
		<h2>Center Manager Login</h2>
			<div class="mb-3">
				<label>Username</label>
				<input type="text" name="username" class="form-control" />
			</div>
			<div class="mb-3">
				<label>Password</label>
				<input type="password" name="password" class="form-control" />
			</div>
			<div class="mb-3">
				<input type="submit" name="login" value="Login" class="btn btn-primary" />
			</div>
		</form>

	</div>


</body>
</html>