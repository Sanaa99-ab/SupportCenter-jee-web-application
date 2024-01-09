<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Add teacher</title>
</head>
<body class="sb-nav-fixed">
       <%@include file="includes/nav.jsp"%>
        <div id="layoutSidenav">
            <%@include file="includes/sidenav.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4 mt-4">
                       	<h1>Add Teacher</h1>
                     	<form action="CenterManagerAddTeacher" method="post">
			<div class="mb-3">
				<label>Name</label>
				<input type="text" name="name" class="form-control" />
			</div>
			<div class="mb-3">
				<label>Address</label>
				<textarea name="address" class="form-control"></textarea>
			</div>
			<div class="mb-3">
				<label>Contact</label>
				<input type="text" name="contact" class="form-control" />
			</div>
			<div class="mb-3">
				<label>Email</label>
				<input type="email" name="email" class="form-control" />
			</div>
			<div class="mb-3">
				<label>Expertise</label>
				<textarea name="expertise" class="form-control"></textarea>
			</div>
				<div class="mb-3">
				<label>Password</label>
				<input type="password" name="password" class="form-control" />
			</div>
			<div>
				<input type="submit" name="submit" value="Register" class="btn btn-outline-primary" />
			</div>
		</form>
                    </div>
                </main>
            </div>
        </div>
        <%@include file="../includes/footer.jsp"%>
    </body>
</html>