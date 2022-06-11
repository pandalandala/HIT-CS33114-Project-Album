package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import dao.PhotoDAO;
import impl.PhotoDAOImpl;
import entity.Photo;

public class PhotoUploadServlet extends HttpServlet {

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
	           request.setCharacterEncoding("UTF-8");
			//��ȡͼƬ�ϴ�����������ָ��Ŀ¼
			String rootPath = this.getInitParameter("rootPath");
			try {
				//����SmartUpload����
				SmartUpload su = new SmartUpload();
				//��ʼ���ϴ�����
				su.initialize(this, request, response);
				//���������ϴ����ļ����ֵ
				su.setMaxFileSize(1024*1024*10);//���10M
				//���������ϴ��ļ�������
				su.setAllowedFilesList("jpg,png,bmp,gif,emf,JPG,PNG");
				//��ʼ�ϴ�
				su.upload();
				//��ȡ�����ļ�
				Files files = su.getFiles();
				//��ȡ�����ļ�
				File file = files.getFile(0);
				//��ȡ�ļ���
				String filename = file.getFileName();//ͼƬ����
				//�����ļ�(�����������ļ����Ƶ�����������ļ���Ŀ¼��)
				file.saveAs(rootPath+filename);
				
				//��ȡwebԪ��
				Request req = su.getRequest();
				String id = req.getParameter("aid");
				int aid = Integer.parseInt(id);//��ȡ���ID
				String adis = req.getParameter("pdiscription");//��ȡ���������Ϣ
				//�½�ͼƬ����
				Photo p = new Photo();
				p.setAid(aid);
				p.setPname(filename);
				p.setPdiscription(adis);
				
				PhotoDAO pdao = new PhotoDAOImpl();
				pdao.addPhoto(p);
					//�ϴ��ɹ�
				    request.setAttribute("info", "�ϴ��ɹ�!");
				    PrintWriter out = response.getWriter(); 
				    out.print("�ϴ��ɹ�!");
				    response.sendRedirect("Albums.jsp");
				
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			
	}

}
