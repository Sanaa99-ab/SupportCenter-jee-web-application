<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Edit teacher</title>
</head>
<body class="sb-nav-fixed">
       <%@include file="includes/nav.jsp"%>
        <div id="layoutSidenav">
            <%@include file="includes/sidenav.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4 mt-4">
                       	<h1>Edit Teacher</h1>
                     	<form action="CenterManagerUpdateTeacher" method="post">
			<div class="mb-3">
				<label>Name</label>
				<input type="hidden" name="id"  value="${requestScope.teacher.getId() }" />
				<input type="text" name="name" class="form-control" value="${requestScope.teacher.getName() }" />
			</div>
			<div class="mb-3">
				<label>Address</label>
				<textarea name="address" class="form-control">
					<c:out  value="${requestScope.teacher.getAddress() }" />
				</textarea>
			</div>
			<div class="mb-3">
				<label>Contact</label>
				<input type="text" name="contact" class="form-control" value="${requestScope.teacher.getContactNo() }" />
			</div>
			<div class="mb-3">
				<label>Email</label>
				<input type="email" name="email" class="form-control" value="${requestScope.teacher.getEmail() }" />
			</div>
			<div class="mb-3">
				<label>Expertise</label>
				<textarea name="expertise" class="form-control">
					<c:out  value="${requestScope.teacher.getExpertise() }" />
				</textarea>
			</div>
				<div class="mb-3">
				<label>Password</label>
				<input type="text" name="password" class="form-control" value="${requestScope.teacher.getPassword() }" />
			</div>
			<div>
				<input type="submit" name="submit" value="Update" class="btn btn-outline-primary" />
			</div>
		</form>
                    </div>
                </main>
            </div>
        </div>
        <%@include file="../includes/footer.jsp"%>
    </body>
</html>