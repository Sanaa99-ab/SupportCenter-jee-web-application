<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Edit room</title>
</head>
<body class="sb-nav-fixed">
	<%@include file="includes/nav.jsp"%>
	<div id="layoutSidenav">
		<%@include file="includes/sidenav.jsp"%>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4 mt-4">
					<h1>Edit Class Room</h1>
					<form action="CenterManagerUpdateRoom" method="post">
						<div class="mb-3">
							<label>Name</label> 
							<input type="hidden" name="id" value="${requestScope.room.getId() }" />
							<input type="text" name="name"
								class="form-control" required value="${requestScope.room.getName() }"/>
						</div>
						<div class="mb-3">
							<label>Number</label> <input type="text" name="number"
								class="form-control" required value="${requestScope.room.getNumber() }" />
						</div>
						<div class="mb-3">
							<label>Capacity</label> <input type="number" name="capacity"
								class="form-control" required value="${requestScope.room.getCapacity() }"/>
						</div>
						<div>
							<input type="submit" name="submit" value="Update"
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