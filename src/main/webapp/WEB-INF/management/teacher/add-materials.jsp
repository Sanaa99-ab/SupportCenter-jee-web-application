<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Teacher Home</title>
<%@include file="../includes/header.jsp"%>
</head>
<body class="sb-nav-fixed">
       <%@include file="includes/nav.jsp"%>
        <div id="layoutSidenav">
            <%@include file="includes/sidenav.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid mt-4">
                       <h1>Add course materials</h1>
						
						<form action="TeacherAddCourseMaterials" method="post" enctype="multipart/form-data">
							<div class="mb-3">
								<label>Unit / Title</label>
								<input type="hidden" value="${requestScope.sheduleId }" name="id" />
								<input type="text" name="unit" required class="form-control" />
							</div>
							<div class="mb-3">
								<label>Material</label>
								<input type="file" name="material" required class="form-control" />
							</div>
							<div class="mb-3">
								<input type="submit" name="submit" value="Add" class="btn btn-success" /> 
							</div>
						</form>

                    </div>
                </main>
            </div>
        </div>
    </body>
</html>