<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/MyTacks/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="header.jsp" %>
<%int count=(Integer)request.getAttribute("totalcount"); %>
<div id="page";>
<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;">
		<%String categoryName=""; %>
			<div id="content">
				<ul class="sale">
					<%for(int i=0;i<count;i++){ %>
					
					<%String categoryImage=(String)request.getAttribute("categoryImage"+i); %>
					<li>
					<%categoryName=categoryImage.substring(0,categoryImage.length()-4); %>
					<%=categoryName %>
					
					</li>
					<li>
					&nbsp
					</li>
					<li>
					
<a href="/MyTacks/UserServlet?action=goToBoardPage&categoryName=<%=categoryImage %>"><img src="<%=request.getContextPath() %>/images/<%=categoryImage%>" style="border: 2px solid pink;border-radius: 30px;-moz-border-radius: 30px;
-khtml-border-radius: 30px;
-webkit-border-radius: 30px;
width: 180px;height: 240px; height="218px" width="218px" alt=""></a>
					
					</li>
					
				
					<%} %>
							</ul>
		
			</div>
		</div>
		</div>
		<%@ include file="footerShow.jsp" %>
</body>
</html>