<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.RequestDispatcher" %>
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
<%@page import="java.util.ArrayList"%>
<%@page import="com.mytacks.group10.tagatTack.model.CategoryMaster"%>    
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
<%String message=(String)request.getParameter("boardName"); %>
<%String categoryName=(String)request.getAttribute("categoryName"); %>
<%ArrayList<CategoryMaster> listOfCategories=(ArrayList<CategoryMaster>)request.getAttribute("listOfCategories"); %>
<div id="page";">
		<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;">
		
		<form name="changeImage" method="post" action="/MyTacks/UserServlet" enctype="multipart/form-data">
		<input type="hidden" name="action" value="updateBoardDetails"></input>
		<input type="hidden" name="oldBoardName" id="oldBoardName" value=<%=message %>></input>
		
		
				
				<div id="loginbox">
			<div>
			<table>
			<tr>
			<td id="loginlabel">
			ChangeBoardImage
			</td>
			<td>
			<input type="file" name="boardImage" id="boardImage"/>
			</td>
			
			</tr>
			<tr>
					
						<td id="loginlabel">
						BoardName
						
						</td>
						
						<td><input type="text" name="boardName" id="boardName" value="<%=message%>"> </td>
					</tr>
					<tr>
						<td id="loginlabel">
						Board Type
						</td>
						<td><input type="radio" name="boardType" id="privateBoard" value="PRIVATE">Private<input type="radio" name="boardType" id="publicBoard" value="PUBLIC" checked>Public</td>
						</tr>
						<tr>
						<td id="loginlabel">
						Change Category
						</td>
						<td>
						<select name="categoryName" id="categoryName">
 <option value="default"><%=categoryName %></option>
 <%for(int i=0;i<listOfCategories.size();i++){ %>
 <%if(listOfCategories.get(i).getCategoryName().equals(categoryName)){i++;} %>
 <option value="<%= listOfCategories.get(i).getCategoryName() %>"><%= listOfCategories.get(i).getCategoryName() %></option>
<%} %> 
 </select>
						
						</td>
						
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