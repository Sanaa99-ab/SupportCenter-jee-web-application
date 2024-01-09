package controllers.centermanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Shedule;
import services.centermanager.AddShedule;
import services.centermanager.UpdateShedule;

import java.io.IOException;

/**
 * Servlet implementation class CenterManagerUpdateShedule
 */
public class CenterManagerUpdateShedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterManagerUpdateShedule() {
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
		int course = Integer.parseInt(request.getParameter("course"));
		int teacher = Integer.parseInt(request.getParameter("teacher"));
		int room = Integer.parseInt(request.getParameter("room"));
		int level = Integer.parseInt(request.getParameter("level"));
		int day = Integer.parseInt(request.getParameter("day"));
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		Shedule shedule = new Shedule();
		
		shedule.setCourseId(course);
		shedule.setTeacherId(teacher);
		shedule.setRoomId(room);
		shedule.setLevelId(level);
		shedule.setDayOfWeek(day);
		shedule.setStartTime(start);
		shedule.setEndTime(end);
		
		UpdateShedule.update(shedule, id);
		
		response.sendRedirect("CenterManagerNavigation?to=Shedules");
	}

}
