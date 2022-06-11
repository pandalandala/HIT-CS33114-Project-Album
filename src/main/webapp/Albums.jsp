<%@ page language="java" import = "entity.*,dao.*,impl.*,utils.*,java.util.List" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>相册列表</title>
	    <style type="text/css">
<!--
.STYLE1 {font-size: 12px}
-->
        </style>
</head>
<%
	String sid = request.getParameter("sid");
%>
<body>
<a href="addPhoto_main.jsp?">添加照片</a>
<table width="200" border="1">
  <tr>
    <td width="78">相册编号</td>
  </tr>
  <%
  
  for(int i = 1;i< 10;i++)
  {
	
  %>
  <tr>
    <td>相册<%=i %></td>
    <td><a href="album.jsp?aid=<%=i%>&sid=<%=sid%>">浏览</a></td>
  </tr>
  <%
  }
  %>
</table>
</body>
</html>