package controllers.centermanager.navigation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ClassRoom;
import models.Course;
import models.Level;
import models.Shedule;
import models.Student;
import models.Teacher;
import services.centermanager.GetAllCourses;
import services.centermanager.GetAllLevels;
import services.centermanager.GetAllRooms;
import services.centermanager.GetAllShedules;
import services.centermanager.GetAllStudents;
import services.centermanager.GetAllTeachers;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class CenterManagerNavigation
 */
public class CenterManagerNavigation extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterManagerNavigation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to = request.getParameter("to");
		
		if(to.equals("TeacherManagerHome")) {
		
			ArrayList<Teacher> teachers = GetAllTeachers.getAll();
			request.setAttribute("teachers", teachers);
			request.getRequestDispatcher("WEB-INF/management/center-manager/teacher-manage.jsp").forward(request, response);
		
		}else if(to.equals("StudentManagerHome")) {
			
			ArrayList<Student> students = GetAllStudents.getAll();
			request.setAttribute("students", students);
			request.getRequestDispatcher("WEB-INF/management/center-manager/student-manage.jsp").forward(request, response);
	
		}else if(to.equals("AddTeacher")) {
		
			request.getRequestDispatcher("WEB-INF/management/center-manager/add-teacher.jsp").forward(request, response);
		
		}else if(to.equals("RoomManagerHome")) {
			
			ArrayList<ClassRoom> rooms = GetAllRooms.getAll();
			request.setAttribute("rooms", rooms);
			request.getRequestDispatcher("WEB-INF/management/center-manager/room-manage.jsp").forward(request, response);
		
		}else if(to.equals("AddRoom")) {
			
			request.getRequestDispatcher("WEB-INF/management/center-manager/add-room.jsp").forward(request, response);
		
		}else if(to.equals("CourseManagerHome")) {
			
			ArrayList<Course> courses = GetAllCourses.getAll();
			request.setAttribute("courses", courses);
			request.getRequestDispatcher("WEB-INF/management/center-manager/course-manage.jsp").forward(request, response);
		
		}else if(to.equals("AddCourse")) {
		
			ArrayList<ClassRoom> rooms = GetAllRooms.getAll();
			request.setAttribute("rooms", rooms);
			request.getRequestDispatcher("WEB-INF/management/center-manager/add-course.jsp").forward(request, response);
		
		}else if(to.equals("Shedules")) {
			
			ArrayList<Shedule> shedules = GetAllShedules.getAll();
			request.setAttribute("shedules", shedules);
			request.getRequestDispatcher("WEB-INF/management/center-manager/shedules.jsp").forward(request, response);
		
		}else if(to.equals("Levels")) {
			
			ArrayList<Level> levels = GetAllLevels.getAll();
			request.setAttribute("levels", levels);
			request.getRequestDispatcher("WEB-INF/management/center-manager/level-manage.jsp").forward(request, response);
		
		}else if(to.equals("AddLevel")) {
			request.getRequestDispatcher("WEB-INF/management/center-manager/add-level.jsp").forward(request, response);
		
		}else if(to.equals("AddShedule")) {
			
			
			ArrayList<ClassRoom> rooms = GetAllRooms.getAll();
			request.setAttribute("rooms", rooms);
			ArrayList<Teacher> teachers = GetAllTeachers.getAll();
			request.setAttribute("teachers", teachers);
			ArrayList<Course> courses = GetAllCourses.getAll();
			request.setAttribute("courses", courses);
			ArrayList<Level> levels = GetAllLevels.getAll();
			request.setAttribute("levels", levels);
			request.getRequestDispatcher("WEB-INF/management/center-manager/add-shedule.jsp").forward(request, response);
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
