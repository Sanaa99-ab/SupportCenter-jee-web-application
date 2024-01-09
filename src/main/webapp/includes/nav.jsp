<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="IndexController">Naja7i
			Center</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">

			</ul>
			<div class="d-flex">
				<a class="btn btn-outline-primary ms-3"
					href="center-manager-login.jsp">Manager Login</a> <a
					class="btn btn-outline-primary ms-3" href="teacher-login.jsp">Teacher
					Login</a>

				<c:if test="${not empty sessionScope.student}">
				
					<a class="btn btn-secondary ms-3" href="MyLearnings">My learning</a>

					<a class="btn btn-danger ms-3" href="LogoutController">Logout</a>
				</c:if>
				<c:if test="${empty sessionScope.student}">
				<a class="btn btn-outline-primary ms-3" href="student-login.jsp">Student
						Login</a>
					<a class="btn btn-primary ms-3" href="student-register.jsp">Student
						Register</a>
					
				</c:if>

			</div>
		</div>
	</div>
</nav>