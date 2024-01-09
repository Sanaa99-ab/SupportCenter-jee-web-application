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
                       <h1>Materials </h1>
						
						<table class="table table-striped">
                    		<thead>
                    			<tr>
                    				<th>Shedule ID</th>
                    				<th>Unit/Title</th>
                    				<th>File</th>
                    				<th>Download</th>
                    			</tr>
                    		</thead>
                    		<tbody>
							<c:forEach items="${requestScope.materials}" var="material">
						    	<tr>
						    		<td><c:out value="${material.getSheduleId()}"/></td>
						    		<td><c:out value="${material.getUnitName()}"/></td>
						    		<td><c:out value="${material.getFile()}"/></td>
						    		<td> <a target="_blank" href="C:/Users/Lenovo/Desktop/uploads/<c:out value="${material.getFile() }" />" class="btn btn-secondary">Download</a> </td>
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