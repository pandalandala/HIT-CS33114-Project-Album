package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UpLoad"})
@MultipartConfig(location="C:\\Users\\zxr\\Documents\\Pictures\\Camera Roll")

public class UploadServlet extends HttpServlet {

    
    private String fileNameExtractorRegex="filename=\".+\"";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("UTF-8");
            String path=this.getServletContext().getRealPath("/");
            System.out.println(path);
            out.println("<html> <head>");
            out.println("<style>");
            out.println(".xue{ background-image:url(D:/picture/jsp_background.jpg);"
            		+ "background-repeat:repeat;} ");
            out.println("</style>");
            out.println("</head> ");
            out.println("<body class=\"xue\"></body></html>");
            
            out.println("<p>上传成功！</p>");
            out.write("服务器本地路径："+path+"<br/>\n");
            for(Part p:request.getParts()){
                if(p.getContentType().contains("image")){
                    String fname=getFileName(p);
                    p.write(path+fname);
                    System.out.println(fname);
                    System.out.println(p.getContentType());
                }
            }   
      
        }finally{
            out.close();
        }
    }
    
    private String getFileName(Part part){
        String cotentDesc=part.getHeader("content-disposition");
        String fileName=null;
        Pattern pattern=Pattern.compile(fileNameExtractorRegex);
        Matcher matcher=pattern.matcher(cotentDesc);
        if(matcher.find()){
            fileName=matcher.group();
            fileName=fileName.substring(10,fileName.length()-1);
        }
        return fileName;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}