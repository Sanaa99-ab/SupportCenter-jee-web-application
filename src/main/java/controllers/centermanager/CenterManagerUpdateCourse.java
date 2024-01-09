package controllers.centermanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Course;
import services.centermanager.AddCourse;
import services.centermanager.UpdateCourse;

import java.io.IOException;

/**
 * Servlet implementation class CenterManagerUpdateCourse
 */
public class CenterManagerUpdateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterManagerUpdateCourse() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description  = request.getParameter("description");
		double duration = Double.parseDouble(request.getParameter("duration"));
		double price = Double.parseDouble(request.getParameter("price"));
		int classRoom = Integer.parseInt(request.getParameter("classId"));
		
		
		Course course = new Course();
		
		course.setName(name);
		course.setDescription(description);
		course.setDuration(duration);
		course.setPrice(price);
		course.setClassRoom(classRoom);
		
		UpdateCourse.update(course , id);
		
		response.sendRedirect("CenterManagerNavigation?to=CourseManagerHome");
	}

}
