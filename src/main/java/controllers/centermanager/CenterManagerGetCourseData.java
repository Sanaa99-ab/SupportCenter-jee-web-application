package controllers.centermanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ClassRoom;
import models.Course;
import services.centermanager.GetAllRooms;
import services.centermanager.GetCourseData;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class CenterManagerGetCourseData
 */
public class CenterManagerGetCourseData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterManagerGetCourseData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Course course = GetCourseData.get(id);
		ArrayList<ClassRoom> rooms = GetAllRooms.getAll();
		request.setAttribute("course", course);
		request.setAttribute("rooms", rooms);
		request.getRequestDispatcher("WEB-INF/management/center-manager/edit-course.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
