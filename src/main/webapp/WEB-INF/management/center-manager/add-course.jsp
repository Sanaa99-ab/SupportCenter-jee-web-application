<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Add Course</title>
</head>
<body class="sb-nav-fixed">
	<%@include file="includes/nav.jsp"%>
	<div id="layoutSidenav">
		<%@include file="includes/sidenav.jsp"%>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4 mt-4">
					<h1>Add new course</h1>
					<form action="CenterManagerAddCourse" method="post">
						<div class="mb-3">
							<label>Name</label> <input type="text" name="name"
								class="form-control" required />
						</div>
						<div class="mb-3">
							<label>Description</label>
							<textarea name="description" class="form-control" required></textarea>
						</div>
						<div class="mb-3">
							<label>Duration</label>
							<input type="number" name="duration" required class="form-control" />
						</div>
						<div class="mb-3">
							<label>Price</label>
							<input type="text" name="price" required class="form-control" />
						</div>
						<div class="mb-3">
							<label>Class Room</label>
							<select class="form-control" required name="classId">
									<c:forEach items="${requestScope.rooms}" var="room">
										<option value="<c:out value="${room.getId() }" />"> <c:out value="${ room.getName() }" /> </option>
									</c:forEach>
							</select>
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