<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Room management</title>
</head>
<body class="sb-nav-fixed">
       <%@include file="includes/nav.jsp"%>
        <div id="layoutSidenav">
            <%@include file="includes/sidenav.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4 mt-4">
                    <h1>Class Rooms</h1> <a href="CenterManagerNavigation?to=AddRoom" class="btn btn-success">Add new</a>
                    	<table class="table table-striped">
                    		<thead>
                    			<tr>
                    				<th>ID</th>
                    				<th>Name</th>
                    				<th>Number</th>
                    				<th>Capacity</th>
                    				<th>Update</th>
                    				<th>Delete</th>
                    			</tr>
                    		</thead>
                    		<tbody>
							<c:forEach items="${requestScope.rooms}" var="room">
						    	<tr>
						    		<td><c:out value="${room.getId()}"/></td>
						    		<td><c:out value="${room.getName()}"/></td>
						    		<td><c:out value="${room.getNumber()}"/></td>
						    		<td><c:out value="${room.getCapacity()}"/></td>
						    		<td> <a href="CenterManagerGetRoomData?id=<c:out value="${room.getId()}" />" class="btn btn-warning">Update</a> </td>
						    		<td> <a href="CenterManagerDeleteRoom?id=<c:out value="${room.getId()}" />" class="btn btn-danger">Delete</a> </td>
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