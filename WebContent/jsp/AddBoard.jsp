<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.servlet.RequestDispatcher"  %>
<%
response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
if(request.getSession()==null || request.getSession().getAttribute("userID")==null){
    RequestDispatcher rd=request.getRequestDispatcher("/jsp/Login.jsp");
    rd.forward(request,response);
    return;
}
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Board</title>
<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/style1.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css">

</head>
<body>
<!-- <%@ include file="header.jsp" %>  -->
<%String message=(String)request.getAttribute("categoryName"); %>

<div id="page";">
<!-- 		<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;">-->		
<form name="SignUp" method="post" action="/MyTacks/UserServlet" enctype="multipart/form-data">
				<input type="hidden" name="action" value="addBoardDetails"></input>
				<input type="hidden" name="categoryName" value=<%=message %>></input>
			
			<div Style = "padding:30px 30px 50px 70px;">
			<div Style = "padding:30px 30px 30px 30px;">
			<a href=""><img src="/MyTacks/images/noticeboard.jpg"  alt=""></a>
			</div>
			<div style = "margin-top:-250px; margin-left:150px;padding :30px 30px 30px 30px;">
			
			<table align="center">
			
								
					
					<tr>
					
						<td id="loginlabel">
						CategoryName :
						</td>
						<td id="loginlabel">
						 <%=message%>
						</td>
					</tr>
					<tr>
						<td id="loginlabel">
						Board Name :
						
						</td>
						<td><input type="text" name="boardName" id="boardName"></td>
						</tr>
						<tr>
						<td id="loginlabel">
						Board Image : 
						
						</td>
						<td><input type="file" name="boardImage" id="boardImage"></td>
						
					</tr>
					<tr>
					
					<td style="align:right;">
					<input type="submit" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" value="Add">
					
					</td>
					</tr>
			</table>
			</div>
			</div>
			
		
				</form>
				
		</div>
		</div>	
		
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@ include file="footerShow.jsp" %>

</body>
</html>