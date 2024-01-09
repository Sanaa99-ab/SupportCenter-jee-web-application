<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Add Shedule</title>
</head>
<body class="sb-nav-fixed">
	<%@include file="includes/nav.jsp"%>
	<div id="layoutSidenav">
		<%@include file="includes/sidenav.jsp"%>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4 mt-4">
					<h1>Add new shedule</h1>
					
					
					<c:if test="${not empty requestScope.conflict}">
						<div class="alert alert-danger" role="alert">
						  This teacher cannot reserved for this time frame
						</div>
					</c:if>
										
					<form action="CenterManagerAddShedule" method="post">
						<div class="mb-3">
							<label>Course</label> 
							<select class="form-control" name="course" required>
								<c:forEach items="${requestScope.courses}" var="course">
										<option value="<c:out value="${course.getId() }" />"> <c:out value="${ course.getName() }" /> </option>
									</c:forEach>
							</select>
						</div>
						<div class="mb-3">
							<label>Teacher</label>
							<select class="form-control" name="teacher" required>
									<c:forEach items="${requestScope.teachers}" var="teacher">
										<option value="<c:out value="${teacher.getId() }" />"> <c:out value="${ teacher.getName() }" /> </option>
									</c:forEach>
							</select>
						</div>
						<div class="mb-3">
							<label>Class Room</label>
							<select class="form-control" required name="room" required>
									<c:forEach items="${requestScope.rooms}" var="room">
										<option value="<c:out value="${room.getId() }" />"> <c:out value="${ room.getName() }" /> </option>
									</c:forEach>
							</select>
						</div>
						<div class="mb-3">
							<label>Level</label>
							<select class="form-control" name="level" required>
									<c:forEach items="${requestScope.levels}" var="level">
										<option value="<c:out value="${level.getId() }" />"> <c:out value="${ level.getName() }" /> </option>
									</c:forEach>
							</select>
						</div>
						<div class="mb-3">
							<label>Day of the week</label>
							<input type="number" name="day" class="form-control" required/>
						</div>
						<div class="mb-3">
							<label>Start time</label>
							<input type="time" name="start" class="form-control" required/>
						</div>
						<div class="mb-3">
							<label>End time</label>
							<input type="time" name="end" class="form-control" required/>
						</div>
						<div>
							<input type="submit" name="submit" value="Add"
								class="btn btn-outline-primary" />
						</div>
					</form>
				</div>
			</main>
		</div>
	</div>
	<%@include file="../includes/footer.jsp"%>
</body>
</html>