package controllers.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Student;
import services.students.StudentRegisterService;
import utils.GetCurrentDate;
import utils.StudentNumberGenerator;

import java.io.IOException;
import java.util.Objects;

/**
 * Servlet implementation class StudentRegisterController
 */
public class StudentRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterController() {
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
		
		// get student register form values
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// generate unique student number
		String studentNumber = StudentNumberGenerator.generateNumber();
		
		String registrationDate = GetCurrentDate.getDate();
		
		Student student = new Student();
		StudentRegisterService studentRegService = new StudentRegisterService();
		
		student.setName(name);
		student.setDob(dob);
		student.setAddress(address);
		student.setContactNo(contact);
		student.setEmail(email);
		student.setStudentNumber(studentNumber);
		student.setRegistrationDate(registrationDate);
		student.setPassword(password);
		
		boolean isReg = studentRegService.studentRegister(student);
		
		
		if(isReg==true) {
			request.setAttribute("registerOk", "Registration is successfull");
		}else {
			request.setAttribute("registerNo", "Something went wrong");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
