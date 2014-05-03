<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/style1.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="page";>
		<div id="header" >
			<div>
				<a href="/MyTacks/jsp/Login.jsp" class="logo"><img  src="/MyTacks/images/logo.png" alt=""></a>
				
			</div>
</div>
</div>
<div id="page";">
		<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;">
		<br></br>
		<br></br>
		
		<form name="form1" id="form1" method="post" action="/MyTacks/UserServlet">
		<input type="hidden" name="action" value="forgotPassword"></input>
		<div id="loginbox" style="margin-left:600px;">
			<div>
				<table>
					<tr>
						<td id="loginlabel">
						Email Address:
						
						</td>
						<td><input type="text" name="UserID" id="UserID"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" name="submit" value="Send Password"></td>
					</tr>
					</table>
					</div>
					</div>
					</form>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		
		</div>
		</div>	
<%@ include file="footerShow.jsp" %>

</body>
</html>