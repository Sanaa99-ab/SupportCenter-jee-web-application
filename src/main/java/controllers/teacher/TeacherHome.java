package controllers.teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Shedule;
import models.Teacher;
import services.teacher.GetMyShedules;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class TeacherHomeController
 */
public class TeacherHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Shedule> shedules = new ArrayList<Shedule>();
		
		try {
			Teacher teacher = (Teacher)session.getAttribute("teacher");
			shedules = GetMyShedules.get(teacher.getId());
			request.setAttribute("shedules", shedules);
			request.getRequestDispatcher("WEB-INF/management/teacher/teacher-home.jsp").forward(request, response);
		}catch(NullPointerException e) {
			response.sendRedirect("teacher-login.jsp");
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
