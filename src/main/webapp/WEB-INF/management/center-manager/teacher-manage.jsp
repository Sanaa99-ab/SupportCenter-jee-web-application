<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Teacher management</title>
</head>
<body class="sb-nav-fixed">
       <%@include file="includes/nav.jsp"%>
        <div id="layoutSidenav">
            <%@include file="includes/sidenav.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4 mt-4">
                       	<h1>Teachers</h1><a href="CenterManagerNavigation?to=AddTeacher" class="btn btn-success">Add new</a>
						<table class="table table-striped">
                    		<thead>
                    			<tr>
                    				<th>Id</th>
                    				<th>Name</th>
                    				<th>Address</th>
                    				<th>Contact No</th>
                    				<th>Email</th>
                    				<th>Expertise</th>
                    				<th>Registration date</th>
									<th>Password</th>
									<th>Update</th>
                    				<th>Delete</th>
                    			</tr>
                    		</thead>
                    		<tbody>
							<c:forEach items="${requestScope.teachers}" var="teacher">
						    	<tr>
						    		<td><c:out value="${teacher.getId()}"/></td>
						    		<td><c:out value="${teacher.getName()}"/></td>
						    		<td><c:out value="${teacher.getAddress()}"/></td>
						    		<td><c:out value="${teacher.getContactNo()}"/></td>
						    		<td><c:out value="${teacher.getEmail()}"/></td>
						    		<td><c:out value="${teacher.getExpertise()}"/></td>
						    		<td><c:out value="${teacher.getRegistrationDate().substring(0,10)}"/></td>
						    		<td><c:out value="${teacher.getPassword()}"/></td>
						    		<td> <a href="CenterManagerGetTeacherData?id=<c:out value="${teacher.getId()}" />" class="btn btn-warning">Update</a> </td>
						    		<td> <a href="CenterManagerDeleteTeacher?id=<c:out value="${teacher.getId()}" />" class="btn btn-danger">Delete</a> </td>
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