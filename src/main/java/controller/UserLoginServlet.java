package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginerDao;
import impl.LoginerDaoImpl;
import utils.FileUtil;


/** 
* @author 
* @version  
* 
*/
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    private static final int NAME_CODE_RIGHT = 0; //  
    private static final int CODE_WRONG = 1;     //  
    private static final int NAME_WRONG = 2;     //  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	response.setContentType("text/html;charset=utf-8");  
    	request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
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
			response.sendRedirect("Albums.jsp?sid="+sid);
			
			
		}
		else
		{
			response.getWriter().print("Error<br/><a herf=\"login.html\">点击这里</a>返回登录页");
		}
	}
        
    	
 

       //request.getRequestDispatcher("/index/info.jsp").forward(request, response);
}