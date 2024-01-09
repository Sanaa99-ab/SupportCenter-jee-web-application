<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Course management</title>
</head>
<body class="sb-nav-fixed">
       <%@include file="includes/nav.jsp"%>
        <div id="layoutSidenav">
            <%@include file="includes/sidenav.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4 mt-4">
                    <h1>Courses</h1> <a href="CenterManagerNavigation?to=AddCourse" class="btn btn-success">Add new</a>
                    	<table class="table table-striped">
                    		<thead>
                    			<tr>
                    				<th>ID</th>
                    				<th>Name</th>
                    				<th>Description</th>
                    				<th>Duration(Months)</th>
                    				<th>Price</th>
                    				<th>Class ID</th>
                    				<th>Update</th>
                    				<th>Delete</th>
                    			</tr>
                    		</thead>
                    		<tbody>
							<c:forEach items="${requestScope.courses}" var="course">
						    	<tr>
						    		<td><c:out value="${course.getId()}"/></td>
						    		<td><c:out value="${course.getName()}"/></td>
						    		<td><c:out value="${course.getDescription()}"/></td>
						    		<td><c:out value="${course.getDuration()}"/></td>
						    		<td><c:out value="${course.getPrice()}"/></td>
						    		<td><c:out value="${course.getClassRoom()}"/></td>
						    		<td> <a href="CenterManagerGetCourseData?id=<c:out value="${course.getId()}" />" class="btn btn-warning">Update</a> </td>
						    		<td> <a href="CenterManagerDeleteCourse?id=<c:out value="${course.getId()}" />" class="btn btn-danger">Delete</a> </td>
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