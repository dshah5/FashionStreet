<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Fashion Street</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- start slider -->		
	<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/modernizr.custom.28468.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cslider.js"></script>

	<script type="text/javascript">
		$(function() {
			$('#da-slider').cslider();
		});
	</script>
		<!-- Owl Carousel Assets -->
		<link href="${pageContext.request.contextPath}/css/owl.carousel.css" rel="stylesheet">
		     <!-- Owl Carousel Assets -->
		    <!-- Prettify -->
		    <script src="${pageContext.request.contextPath}/js/owl.carousel.js"></script>
		        <script>
		    $(document).ready(function() {
		
		      $("#owl-demo").owlCarousel({
		        items : 4,
		        lazyLoad : true,
		        autoPlay : true,
		        navigation : true,
			    navigationText : ["",""],
			    rewindNav : false,
			    scrollPerPage : false,
			    pagination : false,
    			paginationNumbers: false,
		      });
		
		    });
		    </script>
		   <!-- //Owl Carousel Assets -->
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
<!--<jsp:useBean id="userBean" class="com.sapient.model.User" scope="session"></jsp:useBean>-->

<div class="header_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<a href="/FashionStreet/home"><img src="${pageContext.request.contextPath}/images/logo.png" alt=""/> </a>
		</div>
		<div class="h_icon">
		<ul class="icon1 sub-icon1">
			<li><a class="active-icon c1" href="#"><i>$0</i></a>
				<ul class="sub-icon1 list">
					<li><h3>Your Cart</h3><a href=""></a></li>
					<li><p><a href="/FashionStreet/ViewCartController">ViewCart</a></p></li>
				</ul>
			</li>
		</ul>
		</div>
		<div class="h_search">
    		<form method="POST" action="/FashionStreet/test">
    			<input type="text" id="searchText" value="">
    			<input type="submit" value="" id="searchButton">
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
				<li><a href="/FashionStreet/home">Home</a></li> |
				<li><a href="/FashionStreet/handbags">handbags</a></li> |
				<li><a href="/FashionStreet/jewelry">jewelry</a></li> |
				<li><a href="/FashionStreet/wallets">wallets</a></li> |
				<li><a href="/FashionStreet/belts">belts</a></li> |
				<li><a href="/FashionStreet/shoes">shoes</a></li> |
				<li><a href="/FashionStreet/sale">sale</a></li>
				<c:set var="name" value="${sessionScope.userBean.firstName}"/>
				<c:choose>
    				<c:when test="${not empty logsesh}">
       					<li><a href="/FashionStreet/profile">${logsesh}</a></li> |
    					<li><a href="/FashionStreet/out">logout</a></li>
    					
    				</c:when>
    				<c:otherwise>
        				<li><a href="/FashionStreet/login">login</a></li> |
						<li><a href="/FashionStreet/register">register</a></li>
    				</c:otherwise>
				</c:choose>
			</ul>
		</div>
		
		
	            
	          	  
	


<!-- start main1 -->
<div class="main_bg1">
<div class="wrap">	
	<div class="main1">
		
	</div>
</div>
</div>
<!-- start main -->
<div class="main_bg">
<div class="wrap">	
	<div class="main">
		<!-- start grids_of_3 -->
		
		

<c:forEach var="items" items="${pID}" varStatus="status">

		<div class="grids_of_3">
			<div class="grid1_of_3">
				
					
					
					<div class="price">
						<h4><c:out value="${items}"></c:out><span>buy</span></h4>
					</div>
					<div class="price">
						<h4>Quantity:<c:out value="${quant[status.index]}"></c:out></h4>
					</div>
					<span class="b_btm"></span>
				
			</div>
			<div class="clear"></div>
		</div>
</c:forEach>
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
				<h4><a href="/FashionStreet/contact">Contact Us</a></h4>
			</div>
			<div class="grid1_of_4">
				<h4><a href="/FashionStreet/service">About F Street</a></h4>
			</div>
			<div class="grid1_of_4">
				<h4><a href="/FashionStreet/service">Common Questions</a></h4>
			</div>
			<div class="grid1_of_4">
				<h4><a href="/FashionStreet/contact">Store Locator</a></h4>
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