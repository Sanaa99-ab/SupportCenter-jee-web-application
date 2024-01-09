package controllers.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Shedule;
import models.Student;
import services.students.GetShedulesByCourse;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ViewShedules
 */
public class ViewShedules extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewShedules() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		
		try {
			String name = request.getParameter("name");
			request.setAttribute("courseName", name);
			
			ArrayList<Shedule> shedules = GetShedulesByCourse.getShedules(student.getId());
			request.setAttribute("shedules", shedules);
			request.getRequestDispatcher("WEB-INF/student/shedules.jsp").forward(request, response);
		}catch(NullPointerException e) {
			response.sendRedirect("student-login.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
