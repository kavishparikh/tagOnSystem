<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mytacks.group10.tagatTack.model.CategoryMaster"%>
<%@page import="com.mytacks.group10.tagatTack.model.BoardMaster"%>    
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
<%@ include file="header.jsp" %>
<%String tackName=(String)request.getAttribute("tackName"); %>
<%String tackURLOLD=(String)request.getAttribute("tackURL"); %>
<%String message=(String)request.getAttribute("boardName"); %>
<%String categoryName=(String)request.getAttribute("categoryName"); %>
<%ArrayList<CategoryMaster> listOfCategories=(ArrayList<CategoryMaster>)request.getAttribute("listOfCategories"); %>
<%ArrayList<BoardMaster> listOfBoards=(ArrayList<BoardMaster>)request.getAttribute("listOfBoards"); %>
<div id="page";">
		<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;">
		
		<form name="changeImage" method="post" action="/MyTacks/UserServlet" enctype="multipart/form-data">
		<input type="hidden" name="action" value="updateTackDetails"></input>
		<input type="hidden" name="oldTackName" id="oldTackName" value=<%=tackName %>></input>
		
		
				
				<div id="loginbox">
			<div>
			<table>
			<tr>
			<td id="loginlabel">
			ChangeTackImage
			</td>
			<td>
			<input type="file" name="tackImage" id="tackImage"/>
			</td>
			
			</tr>
			<tr>
			<td id="loginlabel">
			TackName
			</td>
			<td>
			<input type="text" name="tackName" id="tackName" value="<%=tackName%>"> 
			</td>
			</tr>
			<tr>
					
						<td id="loginlabel">
						Change Board
						
						</td>
						
						<td>
						<select name="boardName" id="boardName">
						<%int count=0; %>
 <option value=<%=message %>><%=message %></option>
 <%for(int i=0;i<listOfBoards.size();i++){ %>
 <%if(listOfBoards.get(i).getBoardName().equals(message)&&(i<listOfBoards.size()-1)){i++;count++;} %>
 <option value=<%= listOfBoards.get(i).getBoardName()%>><%= listOfBoards.get(i).getBoardName() %></option>
<%} %> 
 </select>
						</td>
					</tr>
						<tr>
						<td id="loginlabel">
						Tack URL:
						
						</td>
						<td><input type="text" name="tackURL" id="tackURL" value=<%=tackURLOLD %>></td>
						
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
<%@ include file="footerShow.jsp" %>

</body>
</html>