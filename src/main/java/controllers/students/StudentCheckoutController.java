package controllers.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Student;
import services.students.StudentRegisterCourse;

import java.io.IOException;

/**
 * Servlet implementation class StudentCheckoutController
 */
public class StudentCheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCheckoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		int courseId = (int)session.getAttribute("course");
		
		boolean isRegistered = StudentRegisterCourse.register(student.getId(), courseId);
		if(isRegistered == true) {
			
			request.setAttribute("success", "You have sucessfully enrolled to the course");
			session.removeAttribute("course");

		}else {
			request.setAttribute("failed", "Something went wrong!!");
	
		}
		request.getRequestDispatcher("IndexController").forward(request, response);
		
	}

}
