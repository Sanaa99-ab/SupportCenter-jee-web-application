<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../../includes/header.jsp"%>
<title>Schedules</title>
</head>
<body>
	<%@include file="../../includes/nav.jsp"%>

	<div class="container">
		<h1 class="mt-2 mb-2">My learning</h1>

		<h5 style="margin-top: 20px">
			Schedules -
			<c:out value="${ requestScope.courseName }" />
		</h5>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Schedule ID</th>
					<th>Course Name</th>
					<th>Teacher</th>
					<th>Class</th>
					<th>Day of week</th>
					<th>Level</th>
					<th>Start</th>
					<th>End</th>
					<th>Materials</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.shedules}" var="shedule">
					<tr>
						<td><c:out value="${shedule.getId() }" /></td>
						<td><c:out value="${shedule.getCourseName() }" /></td>
						<td><c:out value="${shedule.getTeacherName() }" /></td>
						<td><c:out value="${shedule.getRoomName() }" /></td>
						<td><c:out value="${shedule.getDayOfWeek() }" /></td>
						<td><c:out value="${shedule.getLevel() }" /></td>
						<td><c:out value="${shedule.getStartTime() }" /></td>
						<td><c:out value="${shedule.getEndTime() }" /></td>
						<td><c:forEach items="${shedule.getCourseUnits()}" var="c" varStatus="loop">
								<div class="accordion" id="accordionExample_<c:out value="${loop.index }" />">
									<div class="accordion-item">
										<h2 class="accordion-header">
											<button class="accordion-button" type="button"
												data-bs-toggle="collapse" data-bs-target="#collapseOne_<c:out value="${loop.index }" />"
												aria-expanded="true" aria-controls="collapseOne_<c:out value="${loop.index }" />">
												<c:out value="${c.getUnitName() }" />
												</button>
										</h2>
										<div id="collapseOne_<c:out value="${loop.index }" />" class="accordion-collapse collapse"
											data-bs-parent="#accordionExample_<c:out value="${loop.index }" />">
											<div class="accordion-body">
												   <a href="StudentDownloadMaterials?fileName=${c.getFile() }" target="_blank">${c.getUnitName()}</a>
										    </div>

										</div>
									</div>
								</div>
							</c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<%@include file="../../includes/footer.jsp"%>
</body>
</html>