<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="form1" id="form1" method="post" action="/MyTacks/UserServlet">
<input type="hidden" name="action" value="signIN"></input>
<table>
<tr>
<td>
<input type="text" name="UserID" id="UserID"></input>
</td>
</tr>
<tr>
<td>
<input type="text" name="Userpswd" id="Userpswd"></input>
</td>
</tr>
<tr>
<td>
<input type="submit" name="SIGNIN" value="SIGN IN"></input>
</td>
</tr>






</table>
</form>
</body>
</html>