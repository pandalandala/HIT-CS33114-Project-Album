<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆页</title>
<style type="text/css">
h1{text-align:center;}
body{
    background-image:url(D:/picture/jsp_background.jpg);
    background-repeat:repeat;
}
a{text-decoration:none;font-size:20px;color:black;}
a:hover{text-decoration:underline;font-size:24px;color:red;}
</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        //alert("测试jQuery是否能用");
        $("#form1").submit(function(){
            var name=$("#sid").val();//获取提交的值
            if(name.length==0){//进行判断，如果获取的值为0那么提示账号不能为空
                //alert("aa");//测试使用
                $("#nameError").html("账号不能为空");
                return false;
            }
            
            //密码进行验证不能为空
            var password=$("#pwd").val();//获取提交的密码的值
            if(password.length==0){
                $("#passwordError").html("密码不能为空");
                return false;
            }
            

        });
    
    });
</script>
</head>
<body>
<form action="UserLoginServlet" method="post">
    <h1>用户登录页面</h1>
    <hr/>
    <table align="center" bgcolor="#FFFFF0">
        <tr>
            <td>账号：</td>
            <td><input type="text" name="sid" id="sid">
            <div id="nameError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="pwd" id="pwd">
            <div id="passwordError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td colspan="1">
            </td>
            <td>
                <input type="submit" value="登陆"/>
                <input type="reset" value="重置"/>
                <a href="register.jsp">注册</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>