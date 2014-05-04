<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/style1.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css">

</head>
<body>
<%@ include file="header.jsp" %>
<%String message=(String)request.getAttribute("Message"); %>

<div id="page";">
		<!-- <div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;"> -->
		<div><h1 id="loginlabel" style = "font-size:30px" >Hello Everyone! Welcome to tagOn. Share, organize and follow bookmarks that you find interesting </h1>
		<h2> Team Members:</h2>
		<h2> Darshit Kuwadia</h2>
		<h2> Dhrumit Sheth</h2>
		<h2> Kavish Parikh</h2>
		<h2> Manushi Doshi</h2>
		<h2>Nikita Varma</h2>
		<h2> Preeti Borade</h2>
		<h2> Rajvi Shah</h2>
		</div>
		<div style = "margin-left: 100px; margin-top:50px;">
<a href="http://www.youtube.com/watch?v=FoPYfJBJW_4"> A tutorial for Pinterest</a>
		</div>
		</div>
		</div>	
<%@ include file="footerShow.jsp" %>

</body>
</html>