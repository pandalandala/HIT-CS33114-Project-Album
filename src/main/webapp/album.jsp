<%@ page language="java" import = "entity.*,dao.*,impl.*,utils.*,java.util.List" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<%
	String id = request.getParameter("aid");
	int aid = Integer.valueOf(id);
	String sid = request.getParameter("sid");
%>
<body>
<table width="400" border="1">
  <tr>
    <td width="78">照片名</td>
	<td width="78">上传时间</td>
  </tr>
  <%
  PhotoDAO dao = new PhotoDAOImpl();
  List<Photo> phList = dao.findAll(aid);
  String pname;
  String time;
  int pid;
  for(int i = 0;i< phList.size();i++)
  {
	pname = phList.get(i).getPname();
	time = String.valueOf(phList.get(i).getPuploadTime());
	pid = phList.get(i).getPid();
  %>
  <tr>
    <td><%=pname %></td>
    <td><%=time %></td>
    <td><a href="comment.jsp?sid=<%=sid%>&pid=<%=pid%>">浏览</a></td>
    <td><a href="UserServlet?sid=<%=sid%>&pid=<%=pid%>" onclick="return confirm('确定要删除吗')">删除</a></td>
  </tr>
  <%
  }
  %>
</table>
</body>
</html>