package controllers.teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import models.CourseMaterial;
import services.teacher.AddCourseMaterial;

import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class TeacherAddCourseMaterials extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATH = "C:\\Users\\Lenovo\\Desktop\\uploads\\";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherAddCourseMaterials() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sheduleId = Integer.parseInt(request.getParameter("id"));
		String unitName = request.getParameter("unit");
		Part filePart = request.getPart("material");
		String fileName = filePart.getSubmittedFileName();
		for (Part part : request.getParts()) {
			part.write(PATH + fileName);
		}
		
		CourseMaterial material = new CourseMaterial();
		material.setSheduleId(sheduleId);
		material.setUnitName(unitName);
		material.setFile(fileName);
		
		AddCourseMaterial.add(material);
		
		response.sendRedirect("TeacherNavigation?to=ViewMaterials&id="+sheduleId);
	}

}
