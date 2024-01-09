<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Center Manager Home</title>
 <%@include file="../includes/header.jsp"%>
</head>
<body class="sb-nav-fixed">
       <%@include file="includes/nav.jsp"%>
        <div id="layoutSidenav">
            <%@include file="includes/sidenav.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        <div class="row">
                        	<div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">No of students</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a style="text-decoration:none" class="small text-white stretched-link" href="#"> <c:out value="${requestScope.student_count }" /> </a>
          
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-secondary text-white mb-4">
                                    <div class="card-body">No of teachers</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a style="text-decoration:none" class="small text-white stretched-link" href="#"> <c:out value="${requestScope.teacher_count }" /> </a>
          
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">No of courses</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a style="text-decoration:none" class="small text-white stretched-link" href="#"><c:out value="${requestScope.course_count }" /></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Capital raised of the year</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a style="text-decoration:none" class="small text-white stretched-link" href="#">dh<c:out value="${requestScope.capital }" /></a>
                                       
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <%@include file="../includes/footer.jsp"%>
    </body>
</html>