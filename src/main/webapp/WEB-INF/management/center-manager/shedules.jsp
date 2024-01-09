<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Schedules</title>
</head>
<body class="sb-nav-fixed">
       <%@include file="includes/nav.jsp"%>
        <div id="layoutSidenav">
            <%@include file="includes/sidenav.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4 mt-4">
                    <h1>Schedules</h1> <a href="CenterManagerNavigation?to=AddShedule" class="btn btn-success">Add new</a>
                    	<table class="table table-striped">
                    		<thead>
                    			<tr>
                    				<th>ID</th>
                    				<th>Course</th>
                    				<th>Teacher</th>
                    				<th>Room</th>
                    				<th>Level</th>
                    				<th>Day of week</th>
                    				<th>Start</th>
                    				<th>End</th>
                    				<th>Update</th>
                    				<th>Delete</th>
                    			</tr>
                    		</thead>
                    		<tbody>
							<c:forEach items="${requestScope.shedules}" var="shedule">
						    	<tr>
						    		<td><c:out value="${shedule.getId()}"/></td>
						    		<td><c:out value="${shedule.getCourseName()}"/></td>
						    		<td><c:out value="${shedule.getTeacherName()}"/></td>
						    		<td><c:out value="${shedule.getRoomName()}"/></td>
						    		<td><c:out value="${shedule.getLevel()}"/></td>
						    		<td><c:out value="${shedule.getDayOfWeek()}"/></td>
						    		<td><c:out value="${shedule.getStartTime()}"/></td>
						    		<td><c:out value="${shedule.getEndTime()}"/></td>
						    		<td> <a href="CenterManagerGetSheduleData?id=<c:out value="${shedule.getId()}" />" class="btn btn-warning">Update</a> </td>
						    		<td> <a href="CenterManagerDeleteShedule?id=<c:out value="${shedule.getId()}" />" class="btn btn-danger">Delete</a> </td>
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