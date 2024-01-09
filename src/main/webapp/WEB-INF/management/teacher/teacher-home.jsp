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
                       <h1>My shedules</h1>
						
						<table class="table table-striped">
                    		<thead>
                    			<tr>
                    				<th>ID</th>
                    				<th>Course</th>
                    				<th>Room</th>
                    				<th>Level</th>
                    				<th>Day of week</th>
                    				<th>Start</th>
                    				<th>End</th>
                    				<th>Add materials</th>
                    				<th>View materials</th>
                    			</tr>
                    		</thead>
                    		<tbody>
							<c:forEach items="${requestScope.shedules}" var="shedule">
						    	<tr>
						    		<td><c:out value="${shedule.getId()}"/></td>
						    		<td><c:out value="${shedule.getCourseName()}"/></td>
						    		<td><c:out value="${shedule.getRoomName()}"/></td>
						    		<td><c:out value="${shedule.getLevel()}"/></td>
						    		<td><c:out value="${shedule.getDayOfWeek()}"/></td>
						    		<td><c:out value="${shedule.getStartTime()}"/></td>
						    		<td><c:out value="${shedule.getEndTime()}"/></td>
									<td> <a href="TeacherNavigation?to=AddMaterials&id=<c:out value="${ shedule.getId() }" />" class="btn btn-outline-success" >Add materials</a> </td>
						    		<td> <a href="TeacherNavigation?to=ViewMaterials&id=<c:out value="${ shedule.getId() }" />" class="btn btn-secondary">View</a> </td>
						    	</tr>    
						        
						    </c:forEach>
                    		</tbody>

                    	</table>
						

                    </div>
                </main>
            </div>
        </div>
    </body>
</html>