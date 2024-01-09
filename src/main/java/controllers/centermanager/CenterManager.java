package controllers.centermanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Course;
import models.Student;
import services.centermanager.GetAllCoursePayments;
import services.centermanager.GetAllCourses;
import services.centermanager.GetAllStudents;
import services.centermanager.GetAllTeachers;

import java.io.IOException;
import java.util.ArrayList;

import models.Teacher;

/**
 * Servlet implementation class CenterManagerHomeController
 */
public class CenterManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Student> students = GetAllStudents.getAll();
		ArrayList<Course> courses = GetAllCourses.getAll();
		ArrayList<Teacher> teachers = GetAllTeachers.getAll();
		double totalAmount = GetAllCoursePayments.getTotalPayments();
		
		request.setAttribute("student_count", students.size());
		request.setAttribute("course_count", courses.size());
		request.setAttribute("teacher_count", teachers.size());
		request.setAttribute("capital", totalAmount);
		request.getRequestDispatcher("WEB-INF/management/center-manager/center-manager-home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
