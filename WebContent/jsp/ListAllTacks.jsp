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

if(deleteCheck="deleteTack")
{
	var r=confirm("Are you sure you want to delete this Tack?");
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
<%@ include file="header.jsp" %>
<%int count=(Integer)request.getAttribute("totalcount"); %>

<div id="page";>
<!-- <div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;"> -->
		<%String tackName=""; %>
			<div id="content">
				<ul class="sale">
					<%for(int i=0;i<count;i++){ %>
<form name="listOfCategories" method="post" action="/MyTacks/UserServlet" onsubmit="return validateDelete();">

					
					<%String tackImage=(String)request.getAttribute("tackImage"+i); %>
					<%String tackURL=(String)request.getAttribute("tackURL"+i); %>
					
					
					
					<li>
					<%tackName=tackImage.substring(0,tackImage.length()-4); %>
					<table>
					<tr>
					<td id = "loginlabel">
					<input type="hidden" name="tackName" value="<%=tackName%>"></input>
					<%String redirectFrom=(String)request.getAttribute("RedirectFrom"); %>
					Tack Name: <%=tackName %>
					</td>
					</tr>
					<tr>
					<td>
					<a href="<%=tackURL %>"><img src="<%=request.getContextPath() %>/images/<%=tackImage%>" style="border: 2px solid pink;border-radius: 30px;-moz-border-radius: 30px;
-khtml-border-radius: 30px;
-webkit-border-radius: 30px;
width: 180px;height: 240px;  alt=""></a>
					</td>
					</tr>
					<tr>
					<td>
					<%if(redirectFrom.equals("updateTack")){ %>
					<input type="hidden" name="action" value="updateTack"></input>
					<input type="submit" name="updateTack" value="Update Tack" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"></input>
					<%} %>
					<%if(redirectFrom.equals("deleteTack")){ %>
					<input type="hidden" name="action" value="deleteTack"></input>
					<input type="hidden" name="checkVal" id="checkVal" value="deleteTack"></input>
					<input type="submit" name="deleteTack" value="Delete Tack" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"></input>
					<%} %>
					<%if(redirectFrom.equals("likeTacks")){ %>
					<input type="hidden" name="action" value="likeTack" id="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"></input>
					<input type="submit" name="likeTack" value="Like"></input>
					<%} %>
					
					</td>
					</tr>
					</table>
					
					
</li>
					
					<li>
					
															
					
					
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