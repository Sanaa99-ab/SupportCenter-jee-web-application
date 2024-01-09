<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
<title>Home</title>
</head>
<body>
	<%@include file="includes/nav.jsp"%>

	<div class="container">

		<c:set var="regOk" value="${requestScope.registerOk}" />

		<c:set var="regNo" value="${requestScope.registerNo}" />
		
		<c:set var="courseRegOK" value="${requestScope.success}" />
	
		<c:set var="courseRegFailed" value="${requestScope.failed}" />
		
		<c:set var="alreadyReg" value="${requestScope.alreadyReg}" />

		<c:choose>
			<c:when test="${regOk != null}">
				<div class="alert alert-success mt-1" role="alert">
					<c:out value="${regOk}" />
				</div>
			</c:when>
			<c:when test="${regNo != null}">
				<div class="alert alert-danger mt-2" role="alert">
					<c:out value="${regNo}" />
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		
			<c:choose>
			<c:when test="${courseRegOK != null}">
				<div class="alert alert-success mt-1" role="alert">
					<c:out value="${courseRegOK}" />
				</div>
			</c:when>
			<c:when test="${courseRegFailed != null}">
				<div class="alert alert-danger mt-2" role="alert">
					<c:out value="${courseRegFailed}" />
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${alreadyReg != null}">
				<div class="alert alert-warning mt-1" role="alert">
					<c:out value="${alreadyReg}" />
				</div>
			</c:when>
		</c:choose>
		

		<h1 class="mt-2">Courses</h1>
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-start">


			<c:forEach items="${requestScope.courses}" var="course">

				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="">
								<!-- Product name-->
								<h5 class="fw-bolder">
									<c:out value="${course.getName() }" />
								</h5>
								$
								<c:out value="${course.getPrice() }" />
							</div>
							<div class="card-text">
								<p class="text-secondary">
									<c:out value="${course.getDescription() }" />
								</p>
								duration - <b> <c:out value="${course.getDuration() }" />
									months
								</b> <br> classroom Id - <b> <c:out
										value="${course.getClassRoom() }" /></b>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="">
								<form action="StudentCourseRegController" method="POST">

									 <input type="hidden" name="courseId" value="<c:out value="${course.getId() }" />" />
									
										<c:if test="${not empty sessionScope.student}">
						
						                 <input type="submit" value="Register" class="btn btn-outline-dark mt-auto" />
										</c:if>
										<c:if test="${empty sessionScope.student}">
											
						                 <input disabled type="submit" value="Register" class="btn btn-outline-dark mt-auto" />
										</c:if>
										
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>


	</div>

</body>
</html>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="includes/header.jsp"%>
    <title>Home</title>
    <!-- Add custom CSS here if needed -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    <style>
            .container {
        padding-top: 20px; 
    }

    
			.col-md-6 h2 {
			    color: #0056b3; 
			    margin-bottom: 40px;
			}
			
			.col-md-6 p {
			    color: #333333; 
			    font-size: 1.1rem; 
			    line-height: 1.6; 
			}
			
			/* Image Enhancements */
			.col-md-6 img {
			    border-radius: 10px; 
			    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
			}
			
			@media (max-width: 768px) {
			    .col-md-6 {
			        margin-bottom: 20px; 
			    }
			}
     </style>   
</head>

<body>
    <%@include file="includes/nav.jsp"%>

    <div class="container">
        <!-- New Layout for School Description and Image -->
        <div class="row mt-3">
            <!-- School Description -->
            <div class="col-md-6">
                <h2>Welcome to Our Support Center for Schooling!</h2>
                <p>
                   Dedicated to enriching your educational journey, our center offers personalized tutoring, expert guidance, and a variety of resources to cater to every learner's needs. We believe in fostering a nurturing environment that empowers students to achieve academic
                   success and personal growth. Join us for a supportive and enriching learning experience!</p>
            </div>
            <!-- Image -->
            <div class="col-md-6">
                <img src="${pageContext.request.contextPath}/static/Teens_School.jpg" alt="School Image" class="img-fluid">
                
            </div>
        </div>






        <!-- Existing alerts and course display code -->
        <!-- Existing alerts and course display code -->
		<c:choose>
		    <c:when test="${regOk != null}">
		        <div class="alert alert-success mt-1" role="alert">
		            <c:out value="${regOk}" />
		        </div>
		    </c:when>
		    <c:when test="${regNo != null}">
		        <div class="alert alert-danger mt-2" role="alert">
		            <c:out value="${regNo}" />
		        </div>
		    </c:when>
		    
		    
		</c:choose>

        <h1 class="mt-4">Courses</h1>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-start">
            <c:forEach items="${requestScope.courses}" var="course">
                <!-- Existing course display code -->
                <div class="col mb-5">
					<div class="card h-100">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="">
								<!-- Product name-->
								<h5 class="fw-bolder">
									<c:out value="${course.getName() }" />
								</h5>
								dh
								<c:out value="${course.getPrice() }" />
								/mois
							</div>
							<div class="card-text">
								<p class="text-secondary">
									<c:out value="${course.getDescription() }" />
								</p>
								duration - <b> <c:out value="${course.getDuration() }" />
									months
								</b> <br> classroom Id - <b> <c:out
										value="${course.getClassRoom() }" /></b>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="">
								<form action="StudentCourseRegController" method="POST">

									 <input type="hidden" name="courseId" value="<c:out value="${course.getId() }" />" />
									
										<c:if test="${not empty sessionScope.student}">
						
						                 <input type="submit" value="Register" class="btn btn-outline-dark mt-auto" />
										</c:if>
										<c:if test="${empty sessionScope.student}">
											
						                 <input disabled type="submit" value="Register" class="btn btn-outline-dark mt-auto" />
										</c:if>
										
								</form>
							</div>
						</div>
					</div>
				</div>
            </c:forEach>
        </div>
        <!-- Reviews Carousel -->
		<div id="reviewsCarousel" class="carousel slide" data-bs-ride="carousel">
		    <div class="carousel-inner">
		        <!-- Carousel Item 1 -->
		        <div class="carousel-item active">
		            <p class="review-text">"This center has been a game-changer in my education journey!" - John Doe</p>
		        </div>
		        <!-- Carousel Item 2 -->
		        <div class="carousel-item">
		            <p class="review-text">"The tutors are knowledgeable and very helpful." - Jane Smith</p>
		        </div>
		        <!-- Carousel Item 3 -->
		        <div class="carousel-item">
		            <p class="review-text">"My grades have improved significantly since joining." - Alex Johnson</p>
		        </div>
		    </div>
		    <a class="carousel-control-prev" href="#reviewsCarousel" role="button" data-bs-slide="prev">
		        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		        <span class="visually-hidden">Previous</span>
		    </a>
		    <a class="carousel-control-next" href="#reviewsCarousel" role="button" data-bs-slide="next">
		        <span class="carousel-control-next-icon" aria-hidden="true"></span>
		        <span class="visually-hidden">Next</span>
		    </a>
		</div>
		<!-- Best Teachers Section -->
<div class="container mt-5">
    <h2 class="text-center mb-4">Our Best Teachers</h2>
    <div class="row">
        <!-- Teacher 1 -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="${pageContext.request.contextPath}/static/teacher1.png" class="card-img-top" alt="Teacher 1">
                <div class="card-body">
                    <h5 class="card-title">EL ALAMI Mouna</h5>
                    <p class="card-text">Brief description about Teacher 1...</p>
                </div>
            </div>
        </div>
        <!-- Teacher 2 -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="${pageContext.request.contextPath}/static/teacher1.png" class="card-img-top" alt="Teacher 2">
                <div class="card-body">
                    <h5 class="card-title">BENTAHER Wissal</h5>
                    <p class="card-text">Brief description about Teacher 2...</p>
                </div>
            </div>
        </div>
        <!-- Teacher 3 -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="${pageContext.request.contextPath}/static/teacher1.png" class="card-img-top" alt="Teacher 3">
                <div class="card-body">
                    <h5 class="card-title">ESSABI Khadija</h5>
                    <p class="card-text">Brief description about Teacher 3...</p>
                </div>
            </div>
        </div>
        <!-- Add more teachers as needed -->
    </div>
</div>
		
        
    </div>

    <!-- Footer with Center Information -->
    <footer class="bg-light text-center text-lg-start mt-4">
        <div class="text-center p-3">
            © 2023 Naja7 center | Address | 06-00-00-00-00
        </div>
    </footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
