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
<title>Insert title here</title>
<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/style1.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css">

</head>
<body>
<%if(request.getSession().getAttribute("userID").equals("abcd@gmail.com")){ %>
<%@ include file="/jsp/AdminHeader.jsp" %>
<%}else {%>
<%@ include file="/jsp/header.jsp" %>
<%} %>

<%String message=(String)request.getAttribute("Message"); %>
<div id="page";">
	<!-- 	<div id="body" style="background-image:url('/MyTacks/images/bg.jpg');min-length:389px;"> -->
		<br></br>
		<br></br>
		
		<h1 id="loginlabel" style="font-size:35px;"><%=message %></h1> 
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