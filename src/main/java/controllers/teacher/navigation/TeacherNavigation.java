package controllers.teacher.navigation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.CourseMaterial;
import services.teacher.GetMaterialsByShedule;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class TeacherNavigation
 */
public class TeacherNavigation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherNavigation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to = request.getParameter("to");
		if(to.equals("AddMaterials")) {
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("sheduleId", id);
			}catch(Exception e) {
				
			}
			
			request.getRequestDispatcher("WEB-INF/management/teacher/add-materials.jsp").forward(request, response);
		}else if(to.equals("ViewMaterials")) {
			
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				ArrayList<CourseMaterial> materials = GetMaterialsByShedule.getAll(id);
				request.setAttribute("sheduleId", id);
				request.setAttribute("materials", materials);
			}catch(Exception e) {
				
			}
			
			request.getRequestDispatcher("WEB-INF/management/teacher/materials.jsp").forward(request, response);
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
