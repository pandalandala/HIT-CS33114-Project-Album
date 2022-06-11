package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginerDao;
import impl.LoginerDaoImpl;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("sid");
		String pwd = request.getParameter("pwd");
		LoginerDao dao =new LoginerDaoImpl();
		Boolean flag = dao.login(sid, pwd);
		if(flag==true)
		{	HttpSession session = request.getSession();
			session.setAttribute("sid", sid);
			String check = request.getParameter("checkbox");
			if(check!=null)
			{
			Cookie c = new Cookie("sid",sid);
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
			}
			response.sendRedirect("album.jsp");
			
			
		}
		else
		{
			response.getWriter().print("Error<br/><a herf=\"login.html\">点击这里</a>返回登录页");
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
