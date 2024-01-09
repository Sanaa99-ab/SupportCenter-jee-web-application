package controllers.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Course;
import models.Student;
import services.centermanager.GetCourseData;
import services.students.StudentRegisterCourse;

import java.io.IOException;

/**
 * Servlet implementation class StudentCourseRegController
 */
public class StudentCourseRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCourseRegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("IndexController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		
		if(student == null) {
			response.sendRedirect("student-login.jsp");
			return;
		}
		
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		session.setAttribute("course", courseId);
		
		boolean isReg = StudentRegisterCourse.isRegistered(student.getId(), courseId);
		Course course = GetCourseData.get(courseId);
		
		// calculate tution fee 
		double tutionFee = 0.1 * course.getPrice() ;
		
		
		if(isReg==false) {
			
			request.setAttribute("cost", course.getPrice());
			request.getRequestDispatcher("WEB-INF/payment/payment.jsp").forward(request, response);
			
		}else {
			request.setAttribute("alreadyReg", "You already enrolled this course");
			request.getRequestDispatcher("IndexController").forward(request, response);
		}
		
		
	}

}
