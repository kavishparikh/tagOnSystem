<%@ include file="header.jsp" %>
<div id="page";>
<div id="body" style="background-image:url('/MyTacks/images/pinkbackground.gif');min-length:389px;">
<form name="form1" method="post" action="/MyTacks/FbServlet">		
<input type="hidden" name="action" value="check"></input>
<%String next=request.getParameter("code"); %>
<input type="hidden" name="code" value=<%=next %>></input>		
		
		<%request.setAttribute("next",next); %>
<%out.println("the value is"+next);%>
<input type="submit" name="go" value="go"></input>
</form>
			<div id="content">
				<ul class="sale">
					<li>
						<a href="sale.html"><img src="/MyTacks/images/big-discount-fever-hot-sale.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/ushape.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/skin-naturals.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/veauty-salon.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/take-2-for-price-of-1.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/free-lipsticks.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/go-natural.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/shoe-much-in-love.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/fresh-fruits-and-vegetables.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/fit-it-while-you-dance.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/eat-all-you-can.png" alt=""></a>
					</li>
					<li>
						<a href="sale.html"><img src="/MyTacks/images/jewelized.png" alt=""></a>
					</li>
				</ul>
		
			</div>
		</div>
		</div>
		<%@ include file="footerShow.jsp" %>