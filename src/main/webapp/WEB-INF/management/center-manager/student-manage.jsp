<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Student management</title>
</head>
<body class="sb-nav-fixed">
	<%@include file="includes/nav.jsp"%>
	<div id="layoutSidenav">
		<%@include file="includes/sidenav.jsp"%>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4 mt-4">
					<h1>Students</h1>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Student Number</th>
								<th>Name</th>
								<th>Date of birth</th>
								<th>Address</th>
								<th>Contact No</th>
								<th>Email</th>
								<th>Address</th>
								<th>Registration date</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.students}" var="student">
								<tr>
									<td><c:out value="${student.getStudentNumber()}" /></td>
									<td><c:out value="${student.getName()}" /></td>
									<td><c:out value="${student.getDob()}" /></td>
									<td><c:out value="${student.getAddress()}" /></td>
									<td><c:out value="${student.getContactNo()}" /></td>
									<td><c:out value="${student.getEmail()}" /></td>
									<td><c:out value="${student.getAddress()}" /></td>
									<td><c:out
											value="${student.getRegistrationDate().substring(0,10)}" /></td>
									<td><a
										href="CenterManagerDeleteStudent?id=<c:out value="${student.getId() }" />"
										class="btn btn-danger">Delete</a></td>
								</tr>

							</c:forEach>
						</tbody>

					</table>

				</div>
			</main>
		</div>
	</div>
	<%@include file="../includes/footer.jsp"%>
</body>
</html>