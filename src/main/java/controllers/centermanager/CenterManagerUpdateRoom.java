package controllers.centermanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ClassRoom;
import services.centermanager.AddClassRoom;
import services.centermanager.UpdateClassRoom;

import java.io.IOException;

/**
 * Servlet implementation class CenterManagerUpdateRoom
 */
public class CenterManagerUpdateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterManagerUpdateRoom() {
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
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		
		ClassRoom classRoom = new ClassRoom();
		classRoom.setNumber(number);
		classRoom.setCapacity(capacity);
		classRoom.setName(name);
		
		UpdateClassRoom.update(classRoom, id);
		response.sendRedirect("CenterManagerNavigation?to=RoomManagerHome");
		
	}

}
