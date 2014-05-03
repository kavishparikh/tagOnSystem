<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tag@Tack</title>
	
	<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/style1.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">

	var timeout	= 100;
	var closetimer	= 0;
	var ddmenuitem	= 0;

	// open hidden layer
	function mopen(id)
	{	
		// cancel close timer
		mcancelclosetime();

		// close old layer
		if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';

		// get new layer and show it
		ddmenuitem = document.getElementById(id);
		ddmenuitem.style.visibility = 'visible';

	}
	// close showed layer
	function mclose()
	{
		if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
	}

	// go close timer
	function mclosetime()
	{
		closetimer = window.setTimeout(mclose, timeout);
	}

	// cancel close timer
	function mcancelclosetime()
	{
		if(closetimer)
		{
			window.clearTimeout(closetimer);
			closetimer = null;
		}
	}

	// close layer when click-out
	document.onclick = mclose; 


</script>
	
</head>
<body>
<div id="page" style="length:50%;">
		<div id="header" >
			<div >
				<a href="/MyTacks/jsp/Login.jsp" class="logo"><img  src="/MyTacks/images/logo.png" alt=""></a>
				<ul class="sddm">
					<li>
						<a href="about.html" onmouseover="mopen('m1')" onmouseout="mclosetime()">Boards</a>
						<div id="m1" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
        			<a href="/MyTacks/UserServlet?action=listAllCategories&redirectFrom=addBoard">Create Board</a>
        			<a href="/MyTacks/UserServlet?action=listAllBoards&redirectFrom=showBoards">Show Board</a>
        			<a href="/MyTacks/UserServlet?action=listAllBoards&redirectFrom=updateBoard">Update Board</a>
        			<a href="/MyTacks/UserServlet?action=listAllBoards&redirectFrom=delteBoard">Delete Board</a>
        			
        </div>
						
					</li>
					<li>
						<a href="about.html" onmouseover="mopen('m2')" onmouseout="mclosetime()">Tacks</a>
						<div id="m2" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
        <a href="/MyTacks/UserServlet?action=listAllBoards&redirectFrom=addTack">Create Tack</a>
        <a href="/MyTacks/UserServlet?action=listAllBoards&redirectFrom=viewTacks">View Tacks</a>
        <a href="/MyTacks/UserServlet?action=listAllBoards&redirectFrom=updateTack">Update Tack</a>
        <a href="/MyTacks/UserServlet?action=listAllBoards&redirectFrom=deleteTack">Delete Tack</a>
        </div>
			
					</li>
					<li class="middle">
					<a href="about.html" onmouseover="mopen('m3')" onmouseout="mclosetime()">Category</a>
						<div id="m3" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
						<a href="/MyTacks/UserServlet?action=listAllCategories&redirectFrom=showCategories">Show All</a>
						<a href="/MyTacks/UserServlet?action=listAllCategories&redirectFrom=viewBoards">Boards</a>
						<a href="/MyTacks/UserServlet?action=listAllFollowedBoards">Followed</a>
					</div>
					</li>
					<li>
						<a href="about.html" onmouseover="mopen('m4')" onmouseout="mclosetime()">Settings</a>
						<div id="m4" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
						<a href="/MyTacks/UserServlet?action=viewUser">Edit Profile</a>
						<a href="/MyTacks/jsp/ChangePassword.jsp">Change Password</a>
						</div>
					</li>
					<li>
						<a href="sale.html" onmouseover="mopen('m5')" onmouseout="mclosetime()">About</a>
						<div id="m5" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
						<a href="/MyTacks/jsp/AboutUs.jsp">About Us</a>
						<a href="/MyTacks/jsp/Contact Us.jsp">Contact Us</a>
						</div>
					</li>
					<li>
						<a href="/MyTacks/UserServlet?action=logOut">LogOut</a>
					</li>
				</ul>
			</div>
		</div>
		</div>
		</body>
		