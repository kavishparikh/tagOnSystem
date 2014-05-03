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
</head>
<body>
<%if(request.getSession().getAttribute("userID").equals("parths.303@gmail.com")){ %>
<%@ include file="AdminHeader.jsp" %>
<%}else {%>
<%@ include file="header.jsp" %>
<%} %>
<%String logout=(String)request.getAttribute("RedirectFrom"); %>
<%int count=(Integer)request.getAttribute("totalcount"); %>

<div id="page";>
<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;">
		<%String categoryName=""; %>
			<div id="content">
				<ul class="sale">
					<%for(int i=0;i<count;i++){ %>
<form name="listOfCategories" method="post" action="/MyTacks/UserServlet">

					
					<%String categoryImage=(String)request.getAttribute("categoryImage"+i); %>
					
					
					
					
					<li>
					<%categoryName=categoryImage.substring(0,categoryImage.length()-4); %>
					<table>	
					<tr>
					<td id="loginlabel"> 
					<input type="hidden" name="categoryName" value="<%=categoryName%>"></input>
					Category: <%=categoryName %>
					</td>
					</tr>
					<tr>
					<td>
					<img src="<%=request.getContextPath() %>/images/<%=categoryImage%>" style="border: 2px solid pink;border-radius: 30px;-moz-border-radius: 30px;
-khtml-border-radius: 30px;
-webkit-border-radius: 30px;
width: 180px;height: 240px;  alt="">
					</td>
					</tr>
					<tr>
					<td>
					
					<%String redirectFrom=(String)request.getAttribute("RedirectFrom"); %>
					<%if(redirectFrom.equals("addBoard")){ %>					
					<input type="hidden" name="action" value="goToAddBoardPage"></input>
					<input type="submit" size="40px" name="addBoards" value="Add Board" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"></input>
					<%} %>
					<%if(redirectFrom.equals("viewBoards")){ %>					
					<input type="hidden" name="action" value="viewBoardsPage" ></input>
					<input type="hidden" name="RedirectFrom" id="RedirectFrom" value="viewBoardsPage"></input>
					<input type="submit" size="10px" name="viewBoards" value="Boards" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"></input>
					<%} %>
					
					
					</td>
					</tr>
					
					</table>
					

					</li>
					
					
				
		</form>
					
				
					<%} %>
							</ul>
		
			</div>
		</div>
		</div>
		<%@ include file="footerShow.jsp" %>
</body>
</html>