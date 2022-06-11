<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action = "UserServlet" method = "post">
			<table border="1"> 
				<tr>
					<td>昵称</td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="sid"/></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="text" name="pwd"/></td>
				</tr>
				<tr>
					<td>注册类型</td>
					<td>
						<input name = "position" type="radio" value = "是"/>管理员
						<input name = "position" type="radio" value = "否"/>用户
					</td>
				<tr>
				<td></td>
				<td><input type = "submit" value = "提交"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>