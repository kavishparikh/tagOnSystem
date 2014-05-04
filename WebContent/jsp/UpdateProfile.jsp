<%@page import="com.mytacks.group10.tagatTack.model.UserMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">

function validateFun()
{
	var email= document.getElementById("EmailID").value;
	var PhoneNo =  document.getElementById("PhoneNo").value;
	
	var validateEmailRegex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var validatePhnoRegex = /^(?:\([2-9]\d{2}\)\ ?|[2-9]\d{2}(?:\-?|\ ?))[2-9]\d{2}[- ]?\d{4}$/;
	
	if(""==email)
	{
		alert("Please enter your Email address.");
		return false;
	}
	if(validateEmailRegex.test(email) == false)
	{
		alert("Please enter correct Email address.");
		return false;
	}
	if(pswd != confirmPassword)
	{
		alert("The passwords are not matching");
		return false;
	}
	if("" != PhoneNo)
		{
			if(validatePhnoRegex.test(PhoneNo) == false)
				{
					alert("Enter correct phone number");
					return false;
				}	
		}
	else
	{
		return true;
	}
}


</script>
</head>
<body>
<form name="updateProfileForm" id="updateProfileForm" action="/MyTacks/UserServlet" method="post" onsubmit="return validateFun();">
<input type="hidden" name="action" value="updateProfile">
<%if(request.getSession().getAttribute("userID").equals("abcd@gmail.com")){ %>
<%@ include file="/jsp/AdminHeader.jsp" %>
<%}else {%>
<%@ include file="/jsp/header.jsp" %>
<%} %>
<div id="page";>
<!-- <div id="body" style="background-image:url('/MyTacks/images/bg.jpg');min-length:389px;"> -->
 <%UserMaster viewUserDetails =(UserMaster) request.getAttribute("viewUserDetails"); %>
<table>
					
					<%-- <tr>
					
						<td id="loginlabel"  >
						*FirstName:
						
						</td>
						
						<td><input type="text" name="FirstName" id="FirstName" disabled value="<%= viewUserDetails.getFirstName()%>"></td>
					
					
						<td id="loginlabel">
						*LastName:
						
						</td>
						<td><input type="text" name="LastName" id="LastName" disabled value="<%= viewUserDetails.getLastName()%>"></td>
					</tr>
					
					<%if (viewUserDetails.getGender().equalsIgnoreCase("male")) {%>
					<tr>
						<td id="loginlabel">
						Male<input type="radio" name="gender" id="male" value="male" disabled checked></input> 
						
						
						</td>
						<td id="loginlabel">
						Female<input type="radio" name="gender" id="female" value="female" disabled></input></td>
					</tr>
					<%} else{ %>
					<tr>
						<td id="loginlabel">
						Male <input type="radio" name="gender" id="male" value="male" disabled ></input> 
						
						
						</td>
						<td id="loginlabel">
						Female<input type="radio" name="gender" id="female" value="female" disabled checked></input></td>
					</tr>
					<%} %> --%>
					
					<tr>
						<td id="loginlabel">
						*Email:
						
						</td>
						<td><input type="text" name="EmailID" id="EmailID" value="<%= viewUserDetails.getEmailAddress()%>"></td>
					</tr>
					<tr>
						<td id="loginlabel">
						Phone No:
						
						</td>
						<td><input type="text" name="PhoneNo" id="PhoneNo" value="<%= viewUserDetails.getPhoneNo()%>"></td>
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