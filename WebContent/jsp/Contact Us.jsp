<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/style1.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css">

</head>
<body>
<%@ include file="header.jsp" %>
<%String message=(String)request.getAttribute("Message"); %>
<div id="page";">
		<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;">
		<div>
		<div><h1 id="loginlabel" style = "font-size:30px" >Contact Us</h1></div>
		<div>
		<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=San+Jos%C3%A9+State+University,+Washington+Sq,+San+Jose,+CA&amp;aq=0&amp;oq=san&amp;sll=37.297016,-121.817413&amp;sspn=0.591016,1.352692&amp;ie=UTF8&amp;hq=San+Jos%C3%A9+State+University,+Washington+Sq,+San+Jose,+CA&amp;t=m&amp;ll=37.335839,-121.881251&amp;spn=0.005971,0.00912&amp;z=16&amp;iwloc=A&amp;output=embed"></iframe><br /><small><a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=San+Jos%C3%A9+State+University,+Washington+Sq,+San+Jose,+CA&amp;aq=0&amp;oq=san&amp;sll=37.297016,-121.817413&amp;sspn=0.591016,1.352692&amp;ie=UTF8&amp;hq=San+Jos%C3%A9+State+University,+Washington+Sq,+San+Jose,+CA&amp;t=m&amp;ll=37.335839,-121.881251&amp;spn=0.005971,0.00912&amp;z=16&amp;iwloc=A" style="color:#0000FF;text-align:left">View Larger Map</a></small>
		</div>
		
		</div>
		</div>
		</div>	
<%@ include file="footerShow.jsp" %>

</body>
</html>