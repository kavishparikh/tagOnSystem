<%@ include file="header.jsp" %>
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
<div id="page";>
<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;">
			<div class="featured">
			<%String uId=(String)session.getAttribute("userID"); %>
			<%=uId %><br>
			Your last login was at <%=session.getAttribute("lastLogin") %>
				<ul>
					<li>
						<img src="/MyTacks/images/food-and-dinning.png" alt="">
					</li>
					<li>
						<img src="/MyTacks/images/crazy-shopping.png" alt="">
					</li>
					<li>
						<img src="/MyTacks/images/discover-ef.png" alt="">
					</li>
					<li>
						<img src="/MyTacks/images/big-discount-fever.png" alt="">
					</li>
				</ul>
			</div>
			</div>
			</div>
		<%@ include file="footerShow.jsp" %>	