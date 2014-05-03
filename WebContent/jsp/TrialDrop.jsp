<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

var timeout	= 300;
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

<style type="text/css">
#sddm
{	margin: 0;
	padding: 0;
	z-index: 30}

#sddm li
{	margin: 0;
	padding: 0;
	list-style: none;
	float: left;
	font: bold 11px arial}

#sddm li a
{	display: block;
	margin: 0 1px 0 0;
	padding: 4px 10px;
	width: 60px;
	background: #5970B2;
	color: #FFF;
	text-align: center;
	text-decoration: none}

#sddm li a:hover
{	background: #49A3FF}

#sddm div
{	position: absolute;
	visibility: hidden;
	margin: 0;
	padding: 0;
	background: #EAEBD8;
	border: 1px solid #5970B2}

	#sddm div a
	{	position: relative;
		display: block;
		margin: 0;
		padding: 5px 10px;
		width: auto;
		white-space: nowrap;
		text-align: left;
		text-decoration: none;
		background: #EAEBD8;
		color: #2875DE;
		font: 11px arial}

	#sddm div a:hover
	{	background: #49A3FF;
		color: #FFF}
</style>
</head>
<body>
<ul id="sddm">
    <li><a href="#" 
        onmouseover="mopen('m1')" 
        onmouseout="mclosetime()">Home</a>
        <div id="m1" 
            onmouseover="mcancelclosetime()" 
            onmouseout="mclosetime()">
        <a href="#">HTML/CSS</a>
        <a href="#">DHTML Menu</a>
        <a href="#">JavaScript</a>
        </div>
    </li>
    <li><a href="#" 
        onmouseover="mopen('m2')" 
        onmouseout="mclosetime()">Download</a>
        <div id="m2" 
            onmouseover="mcancelclosetime()" 
            onmouseout="mclosetime()">
        <a href="#">ASP Server-side</a>
        <a href="#">Pulldown navigation</a>
        <a href="#">AJAX Drop Submenu</a>
        <a href="#">DIV Cascading </a>
        </div>
    </li>
    <li><a href="#">Order</a></li>
    <li><a href="#">Help</a></li>
    <li><a href="#">Contact</a></li>
</ul>
<div style="clear:both"></div>
</body>
</html>