package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginerDao;
import entity.Loginer;
import impl.LoginerDaoImpl;
import utils.FileUtil;

/** 
* @author  
* @version 
* 注册的servlet
*/
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    private static final int INSERT_SUCCESS = 0; //  
    private static final int INSERT_ERROR = 1;     //  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	int ret ;  
    	response.setContentType("text/html;charset=utf-8");  
    	request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter out = response.getWriter(); 
        String sid = request.getParameter("sid");
        //name,password,birthday,sex
        String username = request.getParameter("username"); 
        //out.print(name);
        String pwd = request.getParameter("pwd"); 
        //out.print(password);
        String email = request.getParameter("email"); 
        //out.print(birthday);
        String phone = request.getParameter("phone"); 
        //out.print(sex);
        String position = request.getParameter("position");
      //���Ȼ�ȡ·������������·����������Ч����tomcat�ϲ����Ŀ¼�ṹ����
        //String path = this.getServletContext().getRealPath("/WEB-INF/user.txt");
        //Boolean flag=FileUtil.insertUser(username,pwd,email,phone,path);
        LoginerDao dao = new LoginerDaoImpl();
		dao.add(new Loginer(position,sid,username,pwd,email,phone));
		//if(flag)
		{
			ret=0;
		    request.setAttribute("info", "注册成功!");
		    out.print("注册成功!");
		    response.sendRedirect("login_1.jsp");
		}
		//else 
//		{
//			ret=1;
//			request.setAttribute("info", "注册失败�?");
//			out.print("注册失败�?");
//		}
		//request.getRequestDispatcher("/index/info.jsp").forward(request, response);
	        out.flush();  
	        out.close();  
      
        
    }
    
}