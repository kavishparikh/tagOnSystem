<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/style1.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css">
	<link href="/MyTacks/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css">
	<script src="js/jquery-1.9.1.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>
	<script type="text/javascript">
	$(function() {
	
		$( "#accordion" ).accordion();
		

		
		var availableTags = [
			"ActionScript",
			"AppleScript",
			"Asp",
			"BASIC",
			"C",
			"C++",
			"Clojure",
			"COBOL",
			"ColdFusion",
			"Erlang",
			"Fortran",
			"Groovy",
			"Haskell",
			"Java",
			"JavaScript",
			"Lisp",
			"Perl",
			"PHP",
			"Python",
			"Ruby",
			"Scala",
			"Scheme"
		];
		$( "#autocomplete" ).autocomplete({
			source: availableTags
		});
		

		
		$( "#button" ).button();
		$( "#radioset" ).buttonset();
		

		
		$( "#tabs" ).tabs();
		

		
		$( "#dialog" ).dialog({
			autoOpen: false,
			width: 400,
			buttons: [
				{
					text: "Ok",
					click: function() {
						$( this ).dialog( "close" );
					}
				},
				{
					text: "Cancel",
					click: function() {
						$( this ).dialog( "close" );
					}
				}
			]
		});

		// Link to open the dialog
		$( "#dialog-link" ).click(function( event ) {
			$( "#dialog" ).dialog( "open" );
			event.preventDefault();
		});
		

		
		$( "#datepicker" ).datepicker({
			inline: true
		});
		

		
		$( "#slider" ).slider({
			range: true,
			values: [ 17, 67 ]
		});
		

		
		$( "#progressbar" ).progressbar({
			value: 20
		});
		

		// Hover states on the static widgets
		$( "#dialog-link, #icons li" ).hover(
			function() {
				$( this ).addClass( "ui-state-hover" );
			},
			function() {
				$( this ).removeClass( "ui-state-hover" );
			}
		);
	});
	</script>
	

</head>
<body>

<%if(request.getSession().getAttribute("userID").equals("parths.303@gmail.com")){ %>
<%@ include file="/jsp/AdminHeader.jsp" %>
<%}else {%>
<%@ include file="/jsp/header.jsp" %>
<%} %>
<div id="page";">
		<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;margin-top:30px">

<!-- Accordion -->
<div class="ui-widget">
<div id="accordion" >
	
	<h3>Add</h3>
	<div>
	<form name="addcategory" id="addcategory" action="/MyTacks/AdminServlet" enctype="multipart/form-data" method="post">
	<input type="hidden" name="action" value="addCategory"></input>
	<table>
					<tr>
						<td id="loginlabel">
						Category:
						
						</td>
						<td><input type="text" name="categoryName" id="categoryName"></td>
					</tr>
					<tr>
					<td id="loginlabel">
						Image:
					</td>
				
					<td id="loginlabel">
					<input type="file" name="categoryImage" id="categoryImage">
					</td>
					</tr>
					<tr>
					
					<td style="align:right;">
					<input type="submit" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" value="Add">
					
					</td>
					</tr>
	</table>
	</form></div>
	<h3>Delete</h3>
	
	<div><form name="deletecategory">
	<table>
					<tr>
						<td id="loginlabel">
						Category:
						
						</td>
						<td><input type="text" name="deleteCategory"></td>
					</tr>
					<tr>
					
					<td style="align:right;">
					<input type="submit" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" value="Delete">
					
					</td>
					</tr>
	</table>
	</form></div>
	<h3>Update</h3>
	<div><form name="updatecategory">
	<table>
					<tr>
						<td id="loginlabel">
						Category:
						
						</td>
						<td><input type="text" name="updateCategory"></td>
					</tr>
					<tr>
					
					<td style="align:right;">
					<input type="submit" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" value="Update">
					
					</td>
					</tr>
	</table>
	</form></div>
	<h3>show</h3>
	<div><form name="showcategory" id="showcategory" method="post" action="/MyTacks/AdminServlet">
	<input type="hidden" name="action" value="listAllCategories"></input>
	<table>
					<tr>
						<td id="loginlabel">
						Category:
						
						</td>
						<td><input type="text" name="categoryName" id="categoryName"></td>
					</tr>
					<tr>
					
					<td style="align:right;">
					<input type="submit" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" value="Show">
					
					</td>
					</tr>
	</table>
	</form></div>
</div>
</div>
</div>
</div>
<%@ include file="../jsp/footerShow.jsp" %>

</body>
</html>