package controllers.centermanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Teacher;
import services.centermanager.AddTeacher;
import utils.GetCurrentDate;

import java.io.IOException;

/**
 * Servlet implementation class CenterManagerAddTeacher
 */
public class CenterManagerAddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterManagerAddTeacher() {
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
		
		String name = request.getParameter("name");
		String address= request.getParameter("address");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String expertise = request.getParameter("expertise");
		String password = request.getParameter("password");
		String regDate = GetCurrentDate.getDate();
		
		Teacher teacher = new Teacher();
	
		teacher.setName(name);
		teacher.setAddress(address);
		teacher.setContactNo(contact);
		teacher.setEmail(email);
		teacher.setExpertise(expertise);
		teacher.setPassword(password);
		teacher.setRegistrationDate(regDate);
		
		boolean result = AddTeacher.addTeacher(teacher);
		
		response.sendRedirect("CenterManagerNavigation?to=TeacherManagerHome");
	}

}
