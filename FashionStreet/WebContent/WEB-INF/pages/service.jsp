<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Fashion Street</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script> 
<!-- start top_js_button -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js"></script>
   <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>

</head>
<body>
<!-- start header -->
<jsp:useBean id="userBean" class="com.sapient.model.User" scope="session"></jsp:useBean>
<div class="header_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<a href="home.jsp"><img src="${pageContext.request.contextPath}/images/logo.png" alt=""/> </a>
		</div>
		<div class="h_icon">
		<ul class="icon1 sub-icon1">
			<li><a class="active-icon c1" href="#"><i>$0</i></a>
				<ul class="sub-icon1 list">
					<li><h3>shopping cart empty</h3><a href=""></a></li>
					<li><p>if items in your wish list are missing, <a href="contact.jsp">contact us</a> to view them</p></li>
				</ul>
			</li>
		</ul>
		</div>
		<div class="h_search">
    		<form>
    			<input type="text" id="searchText" value="">
    			<input type="submit" value="" id="searchButton">
    			<script src="js/code.js"></script>
    		</form>
		</div>
		<div class="clear"></div>
	</div>
</div>
</div>
<div class="header_btm">
<div class="wrap">
	<div class="header_sub">
		<div class="h_menu">
			<ul>
				<li><a href="home.jsp">Home</a></li> |
				<li><a href="handbags.jsp">handbags</a></li> |
				<li><a href="jewelry.jsp">jewelry</a></li> |
				<li><a href="wallets.jsp">wallets</a></li> |
				<li><a href="belts.jsp">belts</a></li> |
				<li><a href="shoes.jsp">shoes</a></li> |
				<li><a href="sale.jsp">sale</a></li>
				<c:set var="name" value="${sessionScope.userBean.firstName}"/>
				<c:choose>
    				<c:when test="${not empty name}">
       					<li><a href="profile.jsp">${name}</a></li> |
    					<li><a href="logout">logout</a></li>
    					
    				</c:when>
    				<c:otherwise>
        				<li><a href="login.jsp">login</a></li> |
						<li><a href="register.jsp">register</a></li>
    				</c:otherwise>
				</c:choose>
			</ul>
		</div>
		
		<div class="top-nav">
	          <nav class="nav">	        	
	    	    <a href="#" id="w3-menu-trigger"> </a>
	                  <ul class="nav-list" style="">
	            	        <li class="nav-item"><a class="active" href="index.jsp">Home</a></li>
							<li class="nav-item"><a href="handbags.jsp">Handbags</a></li>
							<li class="nav-item"><a href="jewelry.jsp">jewelry</a></li>
							<li class="nav-item"><a href="wallets.jsp">wallets</a></li>
							<li class="nav-item"><a href="belts.jsp">belts</a></li>
							<li class="nav-item"><a href="shoes.jsp">shoes</a></li>
							<li class="nav-item"><a href="sale.jsp">sale</a></li>
							<li class="nav-item"><a href="login.jsp">login</a></li>
	                 </ul>
	           </nav>
	             <div class="search_box">
				<form>
				   <input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
			    </form>
			</div>
	          <div class="clear"> </div>
	          <script src="${pageContext.request.contextPath}/js/responsive.menu.js"></script>
         </div>	
	<div class="clear"></div>
</div>
</div>
</div>
<!-- start main -->
<div class="main_bg">
<div class="wrap">	
	<div class="main">
	<!-- start service -->
	  <div class="service">
		<div class="ser-main">
			<h4>Our Services</h4>
			<p class="para">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting.</p>
			<div class="ser-grid">
				<div class="ser-grid-list">
					<a href="details.jsp"><img src="${pageContext.request.contextPath}/images/icon1.png" alt=""></a>
					<h5><a href="details.jsp">24/7 customer support</a></h5>
					<p class="para">It is a long established fact that a reader will be distracted by the page when looking at its layout.</p>
				</div>
				<div class="ser-grid-list">
					<a href="details.jsp"><img src="${pageContext.request.contextPath}/images/icon2.png" alt=""></a>
					<h5><a href="details.jsp">hygienic branded</a></h5>
					<p class="para"> The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters.</p>
				</div>
				<div class="ser-grid-list">
					<a href="details.jsp"><img src="${pageContext.request.contextPath}/images/icon3.png" alt=""></a>
					<h5><a href="details.jsp">safely dispatch</a></h5>
					<p class="para">It is a long established fact that a reader will be distracted by the page when looking at its layout.</p>
				</div>
				<div class="clear"></div>
			</div>
			<div class="ser-grid">
				<div class="ser-grid-list">
					<a href="details.jsp"><img src="${pageContext.request.contextPath}/images/icon4.png" alt=""></a>
					<h5><a href="details.jsp">100% look book</a></h5>
					<p class="para">It is a long established fact that a reader will be distracted by the page when looking at its layout.</p>
				</div>
				<div class="ser-grid-list">
					<a href="details.jsp"><img src="${pageContext.request.contextPath}/images/icon5.png" alt=""></a>
					<h5><a href="details.jsp">authentic products</a></h5>
					<p class="para"> The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters.</p>
				</div>
				<div class="ser-grid-list">
					<a href="details.jsp"><img src="${pageContext.request.contextPath}/images/icon6.png" alt=""></a>
					<h5><a href="details.jsp">100% guarantee</a></h5>
					<p class="para">It is a long established fact that a reader will be distracted by the page when looking at its layout.</p>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="left_sidebar">
					<div class="sellers">
						<h4>Best Sellers</h4>
						<div class="single-nav">
			                <ul>
			                   <li><a href="#">Always free from repetition</a></li>
			                    <li><a href="#">Always free from repetition</a></li>
			                    <li><a href="#">The standard chunk of Lorem Ipsum</a></li>
			                    <li><a href="#">The standard chunk of Lorem Ipsum</a></li>
			                    <li><a href="#">Always free from repetition</a></li>
			                    <li><a href="#">The standard chunk of Lorem Ipsum</a></li>
			                    <li><a href="#">Always free from repetition</a></li>
			                    <li><a href="#">Always free from repetition</a></li>
			                    <li><a href="#">Always free from repetition</a></li>
			                    <li><a href="#">The standard chunk of Lorem Ipsum</a></li>
			                    <li><a href="#">Always free from repetition</a></li>
			                    <li><a href="#">Always free from repetition</a></li>
			                    <li><a href="#">Always free from repetition</a></li>			                    
			                </ul>
			              </div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
	</div>
</div>
</div>		
<!-- start footer -->
<div class="footer_bg">
<div class="wrap">	
	<div class="footer">
		<!-- start grids_of_4 -->	
		<div class="grids_of_4">
			<div class="grid1_of_4">
				<h4><a href="contact.jsp">Contact Us</a></h4>
			</div>
			<div class="grid1_of_4">
				<h4><a href="service.jsp">About F Street</a></h4>
			</div>
			<div class="grid1_of_4">
				<h4><a href="service.jsp">Common Questions</a></h4>
			</div>
			<div class="grid1_of_4">
				<h4><a href="contact.jsp">Store Locator</a></h4>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
</div>	
<!-- start footer -->
<div class="footer_bg1">
<div class="wrap">
	<div class="footer">
		<!-- scroll_top_btn -->
	    <script type="text/javascript">
			$(document).ready(function() {
			
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		</script>
		 <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
		<!--end scroll_top_btn -->
		<div class="copy">
			<p class="link">&copy;  All rights reserved | Template by&nbsp;&nbsp;<a href="http://w3layouts.com/"> W3Layouts</a></p>
		</div>
		<div class="clear"></div>
	</div>
</div>
</div>
</body>
</html>