<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<title>Level management</title>
</head>
<body class="sb-nav-fixed">
       <%@include file="includes/nav.jsp"%>
        <div id="layoutSidenav">
            <%@include file="includes/sidenav.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4 mt-4">
                    <h1>Levels</h1> <a href="CenterManagerNavigation?to=AddLevel" class="btn btn-success">Add new</a>
                    	<table class="table table-striped">
                    		<thead>
                    			<tr>
                    				<th>ID</th>
                    				<th>Name</th>
                    				<th>Delete</th>
                    			</tr>
                    		</thead>
                    		<tbody>
							<c:forEach items="${requestScope.levels}" var="level">
						    	<tr>
						    		<td><c:out value="${level.getId()}"/></td>
						    		<td><c:out value="${level.getName()}"/></td>
						    		<td> <a href="CenterManagerDeleteLevel?id=<c:out value="${level.getId()}" />" class="btn btn-danger">Delete</a> </td>
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