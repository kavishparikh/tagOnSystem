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
<script type="text/javascript">

	function validateDelete()
	{
	var deleteCheck=document.getElementById("checkVal").value;

	if(deleteCheck="deleteBoardPage")
	{
		var r=confirm("Are you sure you want to delete this Board?");
		if (r==true)
		  {
			 
		 return true;
		  }
		else
		  {
		  return false;
		  } 
				
	}
	else
	{
	}
	
	}

	
</script>
</head>
<body>
<%@ include file="AdminHeader.jsp" %>
<%int count=(Integer)request.getAttribute("totalcount"); %>
<div id="page";>
<!-- <div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;"> -->
		<%String boardName=""; %>
		<%String redirectFrom=""; %>
			<div id="content">
				<ul class="sale">
					<%for(int i=0;i<count;i++){ %>
					
					<li>
<form name="listOfBoards" method="post" action="/MyTacks/AdminServlet" onsubmit="return validateDelete();">

					<%if(count==0){ %>SORRY THERE ARE NO BOARDS IN THIS CATEGORY<%} %>
					<%String boardImage=(String)request.getAttribute("boardImage"+i); %>
					
<%boardName=boardImage.substring(0,boardImage.length()-4); %>
<table>
<tr>
<td id="loginlabel">
<input type="hidden" name="boardName" value="<%=boardName %>"></input>
Board Name: <%=boardName %>
</td>
</tr>
<tr>
<td>
<img src="<%=request.getContextPath() %>/images/<%=boardImage%>" style="border: 2px solid pink;border-radius: 30px;-moz-border-radius: 30px;
-khtml-border-radius: 30px;
-webkit-border-radius: 30px;
width: 180px;height: 240px;  alt="">
</td>
</tr>
<tr>
<td>
		<%redirectFrom=(String)request.getAttribute("RedirectFrom"); %>
								<%if(redirectFrom.equals("deleteBoardByAdmin")){ %>
					<input type="hidden" name="action" value="deleteBoardsByAdmin"></input>
					<input type="hidden" name="redirectFrom" value="deleteBoardsByAdmin"></input>
						<input type="hidden" name="checkVal" id="checkVal" value="deleteBoardPage"></input>
					<input type="submit" size="40px" name="DELETE Board" value="DeleteBoard" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"></input>
					<%} %>
					
			
</form>
</td>
</tr>
</table>
					
</li>

					

					<li>
			
					</li>
					<%} %>
							</ul>
		
			</div>
		</div>
		</div>

		<%@ include file="footerShow.jsp" %>
</body>
</html>