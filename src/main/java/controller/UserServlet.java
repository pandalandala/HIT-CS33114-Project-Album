package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.LoginerDao;
import dao.PhotoDAO;
import entity.*;
import entity.Loginer;
import impl.LoginerDaoImpl;
import impl.PhotoDAOImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid =  request.getParameter("sid");
		LoginerDao dao_l = new LoginerDaoImpl();
		String position = dao_l.getBySid(sid).getPosition();

		if(position.equals("y"))
		{
		int pid =Integer.parseInt(request.getParameter("pid"));
		PhotoDAO dao = new PhotoDAOImpl();
		dao.delPhotoByPid(pid);
		response.sendRedirect("Albums.jsp?position="+position);
		}
		else
		{
			response.sendRedirect("Albums.jsp?position="+position);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
