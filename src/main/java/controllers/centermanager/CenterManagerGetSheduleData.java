package controllers.centermanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ClassRoom;
import models.Course;
import models.Level;
import models.Shedule;
import models.Teacher;
import services.centermanager.GetAllCourses;
import services.centermanager.GetAllLevels;
import services.centermanager.GetAllRooms;
import services.centermanager.GetAllTeachers;
import services.centermanager.GetSheduleData;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class CenterManagerGetSheduleData
 */
public class CenterManagerGetSheduleData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterManagerGetSheduleData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Shedule shedule = GetSheduleData.get(id);
		request.setAttribute("shedule", shedule);
		
		ArrayList<ClassRoom> rooms = GetAllRooms.getAll();
		request.setAttribute("rooms", rooms);
		ArrayList<Teacher> teachers = GetAllTeachers.getAll();
		request.setAttribute("teachers", teachers);
		ArrayList<Course> courses = GetAllCourses.getAll();
		request.setAttribute("courses", courses);
		ArrayList<Level> levels = GetAllLevels.getAll();
		request.setAttribute("levels", levels);
		request.getRequestDispatcher("WEB-INF/management/center-manager/edit-shedule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
