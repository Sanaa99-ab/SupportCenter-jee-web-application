package controllers.centermanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Shedule;
import services.centermanager.AddShedule;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CenterManagerAddShedule
 */
public class CenterManagerAddShedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterManagerAddShedule() {
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
		PrintWriter out = response.getWriter();
		
		int course = Integer.parseInt(request.getParameter("course"));
		int teacher = Integer.parseInt(request.getParameter("teacher"));
		int room = Integer.parseInt(request.getParameter("room"));
		int level = Integer.parseInt(request.getParameter("level"));
		int day = Integer.parseInt(request.getParameter("day"));
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		Shedule shedule = new Shedule();
		
		System.out.println(teacher);
		
		String conflictStatus = AddShedule.checkTeacherAvailability(teacher, start, end);
		
		if(conflictStatus.equals("Conflict")) {
			
			request.setAttribute("conflict", "This teacher already enrolled for a course in the same time");
			request.getRequestDispatcher("WEB-INF/management/center-manager/add-shedule.jsp").forward(request, response);
			return;
			
		}else {
			shedule.setCourseId(course);
			shedule.setTeacherId(teacher);
			shedule.setRoomId(room);
			shedule.setLevelId(level);
			shedule.setDayOfWeek(day);
			shedule.setStartTime(start);
			shedule.setEndTime(end);
			
			AddShedule.add(shedule);
			
			response.sendRedirect("CenterManagerNavigation?to=Shedules");
		}
		

	}

}
