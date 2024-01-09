<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../../includes/header.jsp"%>
<title>My learning</title>
</head>
<body>
	<%@include file="../../includes/nav.jsp"%>

	<div class="container">
		<h1 class="mt-2 mb-2">My learning</h1>

		<h5 style="margin-top:20px">Courses</h5>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Duration</th>
					<th>Class ID</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${requestScope.courses}" var="course">
					<tr>
						<td><c:out value="${course.getId()}" /></td>
						<td><c:out value="${course.getName()}" /></td>
						<td><c:out value="${course.getDescription()}" /></td>
						<td><c:out value="${course.getDuration()}" /> months</td>
						<td><c:out value="${course.getClassRoom()}" /></td>
						<td> <a href="ViewShedules?name=<c:out value="${course.getName()}" />" class="btn btn-success">View Schedule</a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@include file="../../includes/footer.jsp"%>
</body>
</html>