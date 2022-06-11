<%@ page language="java" import = "entity.*,dao.*,impl.*,utils.*,java.util.List"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>评论页</title>
</head>
<%
	String pi = request.getParameter("pid");
	String sid = request.getParameter("sid");
    int pid = Integer.parseInt(pi);
	PhotoDAO dao = new PhotoDAOImpl();
  	Photo p  = dao.findByPid(pid);
 	String pname = p.getPname();
    String pdi = p.getPdiscription();
    
%>
<body>
<form id="form1" name="form1" method="post" action="CommentServlet">
  <table width="295" height="251" border="1">
    <tr>
      <td height="115" align="center">图片</td>
      <td><img src="/rootPath/<%=pname%>"  width="150" height="150"></img></td>
    </tr>
    <tr>
      <td height="115" align="center">照片介绍</td>
      <td><%=pdi%></td>
    </tr>
    <%
	String str = "select * from comment where pid =" + pid ;
	CommentDao dao_c = new CommentDaoImpl();
	LoginerDao dao_l =new LoginerDaoImpl();
	List<Comment> list = dao_c.getAll(str);
	String comment,userid,username;
	if(list!=null)
	{
	for(int i = 0;i< list.size();i++)
  {
	comment = list.get(i).getComment();
	userid = String.valueOf(list.get(i).getUid());
	username = dao_l.getBySid(userid).getUsername();
	%>
	<tr>
      <td ><%=username%>:</td>
      <td><%=comment %></td>
    </tr>
    <% 
	}}
	%>
    <tr>
      <td align="center">评论</td>
      <td><label>
        <textarea name="comment" rows="5" id="comment"></textarea>
      </label></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <input type="submit" name="Submit" value="提交" />
        <input type = "hidden" name = "pid" value = "<%=pid%>"/>
         <input type = "hidden" name = "sid" value = "<%=sid%>"/>
      </label></td>
    </tr>
  </table>

</form>
</body>
</html>
