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
	var timeout	= 500;
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
			<div>
				<a href="/MyTacks/jsp/Login.jsp" class="logo"><img  src="/MyTacks/images/logo.png" alt=""></a>
				<ul class="sddm">
					<li>
						<a  href="index.html" onmouseover="mopen('m1')" onmouseout="mclosetime()">Board</a>
					<div id="m1" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
        <a href="#">HTML/CSS</a>
        <a href="#">DHTML Menu</a>
        <a href="#">JavaScript</a>
        </div>
					
					</li>
					<li>
						<a href="about.html" onmouseover="mopen('m2')" onmouseout="mclosetime()">Tacks</a>
						<div id="m2" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
        <a href="#">HTML1/CSS</a>
        <a href="#">DHTML1 Menu</a>
        <a href="#">JavaScrip1t</a>
        </div>
					</li>
					<li class="middle">
						<a href="/MyTacks/jsp/CategoryUser.jsp">Category</a>
					</li>
					<li>
						<a href="blog.html">Settings</a>
					</li>
					<li>
						<a href="sale.html">MyStuff</a>
					</li>
					<li>
						<a href="sale.html">LogOut</a>
					</li>
				</ul>
			</div>
		</div>
		</div>
		</body>
		