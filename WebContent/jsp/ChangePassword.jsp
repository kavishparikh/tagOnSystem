<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<script type="text/javascript">
	function validateFun()
		{
		var OldPassword = document.getElementById("OldPassword").value;
		var pswd= document.getElementById("Password").value;
		var confirmPassword = document.getElementById("ConfirmPassword").value;
		
		var passWordRegEx = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$/;
		
		if("" == OldPassword)
			{
			alert("Please enter old password.");
			return false;
			}
		if(""==pswd)
		{
			alert("Please enter New Password.");
			return false;
		}
		if(passWordRegEx.test(pswd) == false)
		{
			alert("Password must be at least 4 characters, no more than 8 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.");
			return false;
		}
		if(pswd != confirmPassword)
		{
			alert("The passwords are not matching");
			return false;
		}
		}
</script>
</head>
<body>
<form name="changePasswordFrom" id="changePasswordFrom" action="/MyTacks/UserServlet" method="post" onsubmit="return validateFun();">
<input type="hidden" name="action" value="changePassword">
<%if(request.getSession().getAttribute("userID").equals("parths.303@gmail.com")){ %>
<%@ include file="/jsp/AdminHeader.jsp" %>
<%}else {%>
<%@ include file="/jsp/header.jsp" %>
<%} %>
<div id="page";>
<!-- <div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;"> -->
			<table>
					<tr>
						<td id="loginlabel">
						
						*Old Password:
						
						</td>
						<td><input type="password" name="OldPassword" id="OldPassword"></td>
					</tr>
					<tr>
						<td id="loginlabel">
						
						*Password:
						
						</td>
						<td><input type="password" name="Password" id="Password"></td>
					</tr>
					<tr>
						<td id="loginlabel">
						*ConfirmPassword:
						
						</td>
						<td><input type="password" name="ConfirmPassword" id="ConfirmPassword"></td>
					</tr>
					
					<tr>
					<td></td>
					<td >
					<input type="submit" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" value="Submit">
					
					</td>
					
					</tr>
			</table>
</div>
</div>
<%@ include file="footerShow.jsp" %>
</form>
</body>
</html>