<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MyTacks</title>
	
	<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/style1.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function validateFun()
{
	var fName= document.getElementById("FirstName").value;
	var lName= document.getElementById("LastName").value;
	var genders = document.getElementsByName("gender");
	var email= document.getElementById("EmailID").value;
	var pwd= document.getElementById("Password").value;
	var pwdCnfrm = document.getElementById("ConfirmPassword").value;
	
	var emailRegEx = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var NamRegEx = /^([a-zA-z\s]{1,20})$/;
	var passWordRegEx = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$/;
	
	if("" == fName)
	{
		alert("Please enter First Name.");
		return false;
	}
	if(NamRegEx.test(fName) == false)
	{
		alert("Please enter correct First Name.");
		return false;
	}
	if(""==lName)
	{
		alert("Please enter Last Name.");
		return false;
	}
	if(NamRegEx.test(lName) == false)
	{
		alert("Please enter correct Last Name.");
		return false;
	}
	if(genders[0].checked == false && genders[1].checked == false)
		{
		alert("Please select your gender.");
		return false;
		}
	if(""==email)
	{
		alert("Please enter Email Address.");
		return false;
	}
	if(emailRegEx.test(email) == false)
	{
		alert("Please enter correct Email Address.");
		return false;
	}
	if(""==pwd)
	{
		alert("Please enter Password.");
		return false;
	}
	if(passWordRegEx.test(pwd) == false)
	{
		alert("Password must be at least 4 characters, no more than 8 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.");
		return false;
	}
	if(pwd != pwdCnfrm)
		{
		alert("The passwords are not matching");
		return false;
	}
	else
	{
		return true;
	}
}


</script>	
<script type="text/javascript">

function validateLogin()
{
var loginname=document.getElementById("UserID").value;
var password=document.getElementById("UserPwd").value;

if(loginname=="")
{
	
alert("Please enter UserName.");
return false;		
	
}
else if(password=="")
{
	alert("Please enter Password.");
	return false;
}
else if(loginname=="" && password=="")
{
	alert("Please Enter Login Name and Password.");
	return false;
}
}


</script>
	
</head>
<body>
<div id="page";>
		<div id="header" >
			<div>
				<a href="index.html" class="logo"><img  src="/MyTacks/images/logo.png" alt=""></a>
				
			</div>
		</div>
		</div>
		<div id="page" style="height:450px;">
		<div id="body" >
		<form name="login" method="post" action="/MyTacks/UserServlet" onsubmit="return validateLogin();">
		<%@page import="java.net.URLEncoder" %>
		<font color="red"><%String error=(String)request.getAttribute("error"); %>
<%String fbURL = "http://www.facebook.com/dialog/oauth?client_id=241581129322350&redirect_uri="+URLEncoder.encode("http://localhost:98/MyTacks/UserServlet?action=FBLogin")+"&scope=email";%>
		
		<input type="hidden" name="action" value="signIN"></input>
				<div style="background-image:url('/MyTacks/images/background.gif');" >
				<div id="loginbox" style="margin-left:600px;">
			<div>
				<table>
					<tr>
						<td id="loginlabel">
						User Name:
						
						</td>
						<td><input type="text" name="UserID" id="UserID"></td>
					</tr>
					<tr>
					<td id="loginlabel">Password:
						
						</td>
						<td><input type="Password" name="UserPwd" id="UserPwd"></td>
					</tr>
					<tr>
					
					<td style="align:right;">
					<input type="submit" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" value="Login">
					
					</td>
					<td>
					<a href="<%= fbURL %>"><img src="/MyTacks/images/facebooklogin.png"></a>
					</td>
					</tr>
					<tr>
					
					<td id="loginlabel"><a href="/MyTacks/jsp/ForgotPassword.jsp" >ForgotPassword?</a></td>
					<td><font color="red"><%if(error!=null){out.println(error);} %></font></td>
						
					</tr>
				</table>
				
			</div>
		</div>
	</div>
	</form>
				<div style="background-image:url('/MyTacks/images/signupbackground.gif');">
				<form name="SignUp" method="post" action="/MyTacks/UserServlet" onsubmit="return validateFun();">
				<input type="hidden" name="action" value="signup"></input>
				<div id="loginbox">
			<div>
			<h1 id="loginlabel" style="font-size:35px;">Sign up </h1>
				<table>
					
					<tr>
					
						<td id="loginlabel"  >
						FirstName* :
						
						</td>
						
						<td><input type="text" name="FirstName" id="FirstName"></td>
					
					
						<td id="loginlabel">
						LastName* :
						
						</td>
						<td><input type="text" name="LastName" id="LastName"></td>
					</tr>
					<tr>
						<td id="loginlabel">
						Male <input type="radio" name="gender" id="male" value="male"></input> 
						
						
						</td>
						<td id="loginlabel">
						Female<input type="radio" name="gender" id="female" value="female"></input></td>
					</tr>
					<tr>
						<td id="loginlabel">
						Email* :
						
						</td>
						<td><input type="text" name="EmailID" id="EmailID"></td>
					</tr>
					<tr>
						<td id="loginlabel">
						
						Password* :
						
						</td>
						<td><input type="password" name="Password" id="Password"></td>
					</tr>
					<tr>
						<td id="loginlabel">
						ConfirmPassword* :
						
						</td>
						<td><input type="password" name="ConfirmPassword" id="ConfirmPassword"></td>
					</tr>
					<tr>
						<td id="loginlabel">
						Phone No:
						
						</td>
						<td><input type="text" name="PhoneNo" id="PhoneNo"></td>
					</tr>
					
					<tr>
					<td></td>
					<td >
					<input type="submit" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" value="Signup">
					
					</td>
					
					</tr>
				</table>
				
			</div>
		</div>
			</form>
				</div>
				</div>
				
			</div>
	
		<%@ include file="footerShow.jsp" %>