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
				<li><a href="home.jsp">Home</a></li> |
				<li><a href="handbags.jsp">handbags</a></li> |
				<li><a href="jewelry.jsp">jewelry</a></li> |
				<li><a href="wallets.jsp">wallets</a></li> |
				<li><a href="belts.jsp">belts</a></li> |
				<li><a href="shoes.jsp">shoes</a></li> |
				<li><a href="sale.jsp">sale</a></li>
				<li><a href="profile.jsp">${logsesh}</a></li> |
				<li><a href="login.jsp">logout</a></li>
				<c:set var="name" value="${sessionScope.userModel.firstName}"/>
				<%-- <c:choose>
    				<c:when test="${not empty name}">
       					<li><a href="profile.jsp">${name}</a></li> |
    					<li><a href="logout">logout</a></li>
    					
    				</c:when>
    				<c:otherwise>
        				<li><a href="login.jsp">login</a></li> |
						<li><a href="register.jsp">register</a></li>
    				</c:otherwise>
				</c:choose> --%>
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
<!-- start slider -->
			<div id="da-slider" class="da-slider">
				<div class="da-slide">
					<h2>welcome to f street</h2>
					<p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane.</p>
					<a href="details.jsp" class="da-link">shop now</a>
					<div class="da-img"><img src="${pageContext.request.contextPath}/images/slider1.png" alt="image01" /></div>
				</div>
				<div class="da-slide">
					<h2>Easy management</h2>
					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
					<a href="details.jsp" class="da-link">shop now</a>
					<div class="da-img"><img src="${pageContext.request.contextPath}/images/slider2.png" alt="image01" /></div>
				</div>
				<div class="da-slide">
					<h2>Revolution</h2>
					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
					<a href="details.jsp" class="da-link">shop now</a>
					<div class="da-img"><img src="${pageContext.request.contextPath}/images/slider3.png" alt="image01" /></div>
				</div>
				<div class="da-slide">
					<h2>Quality Control</h2>
					<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
					<a href="details.jsp" class="da-link">shop now</a>
					<div class="da-img"><img src="${pageContext.request.contextPath}/images/slider4.png" alt="image01" /></div>
				</div>
				<nav class="da-arrows">
					<span class="da-arrows-prev"></span>
					<span class="da-arrows-next"></span>
				</nav>
			</div>
        </div>
<!----start-cursual---->
<div class="wrap">
<!----start-img-cursual---->
	<div id="owl-demo" class="owl-carousel">
		<div class="item" onclick="location.href='details.jsp';">
			<div class="cau_left">
				<img class="lazyOwl" data-src="${pageContext.request.contextPath}/images/c1.jpg" alt="Lazy Owl Image">
			</div>
			<div class="cau_left">
				<h4><a href="details.jsp">branded shoes</a></h4>
				<a href="details.jsp" class="btn">shop</a>
			</div>
		</div>	
		<div class="item" onclick="location.href='details.jsp';">
			<div class="cau_left">
				<img class="lazyOwl" data-src="${pageContext.request.contextPath}/images/c2.jpg" alt="Lazy Owl Image">
			</div>
			<div class="cau_left">
				<h4><a href="details.jsp">branded tees</a></h4>
				<a href="details.jsp" class="btn">shop</a>
			</div>
		</div>	
		<div class="item" onclick="location.href='details.jsp';">
			<div class="cau_left">
				<img class="lazyOwl" data-src="${pageContext.request.contextPath}/images/c3.jpg" alt="Lazy Owl Image">
			</div>
			<div class="cau_left">
				<h4><a href="details.jsp">branded jeens</a></h4>
				<a href="details.jsp" class="btn">shop</a>
			</div>
		</div>	
		<div class="item" onclick="location.href='details.jsp';">
			<div class="cau_left">
				<img class="lazyOwl" data-src="${pageContext.request.contextPath}/images/c2.jpg" alt="Lazy Owl Image">
			</div>
			<div class="cau_left">
				<h4><a href="details.jsp">branded tees</a></h4>
				<a href="details.jsp" class="btn">shop</a>
			</div>
		</div>	
		<div class="item" onclick="location.href='details.jsp';">
			<div class="cau_left">
				<img class="lazyOwl" data-src="${pageContext.request.contextPath}/images/c1.jpg" alt="Lazy Owl Image">
			</div>
			<div class="cau_left">
				<h4><a href="details.jsp">branded shoes</a></h4>
				<a href="details.jsp" class="btn">shop</a>
			</div>
		</div>	
		<div class="item" onclick="location.href='details.jsp';">
			<div class="cau_left">
				<img class="lazyOwl" data-src="${pageContext.request.contextPath}/images/c2.jpg" alt="Lazy Owl Image">
			</div>
			<div class="cau_left">
				<h4><a href="details.jsp">branded tees</a></h4>
				<a href="details.jsp" class="btn">shop</a>
			</div>
		</div>	
		<div class="item" onclick="location.href='details.jsp';">
			<div class="cau_left">
				<img class="lazyOwl" data-src="${pageContext.request.contextPath}/images/c3.jpg" alt="Lazy Owl Image">
			</div>
			<div class="cau_left">
				<h4><a href="details.jsp">branded jeens</a></h4>
				<a href="details.jsp" class="btn">shop</a>
			</div>
		</div>	
	</div>
	<!----//End-img-cursual---->
</div>
<!-- start main1 -->
<div class="main_bg1">
<div class="wrap">	
	<div class="main1">
		<h2>featured products</h2>
	</div>
</div>
</div>
<!-- start main -->
<div class="main_bg">
<div class="wrap">	
	<div class="main">
		<!-- start grids_of_3 -->
		<div class="grids_of_3">
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="${pageContext.request.contextPath}/images/pic1.jpg" alt=""/>
					<h3>branded shoes</h3>
					<div class="price">
						<h4>$300<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="${pageContext.request.contextPath}/images/pic2.jpg" alt=""/>
					<h3>branded t-shirts</h3>
					<div class="price">
						<h4>$300<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="${pageContext.request.contextPath}/images/pic3.jpg" alt=""/>
					<h3>branded tees</h3>
					<div class="price">
						<h4>$300<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="clear"></div>
		</div>
		<div class="grids_of_3">
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="${pageContext.request.contextPath}/images/pic4.jpg" alt=""/>
					<h3>branded bags</h3>
					<div class="price">
						<h4>$300<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="${pageContext.request.contextPath}/images/pic5.jpg" alt=""/>
					<h3>ems women bag</h3>
					<div class="price">
						<h4>$300<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="${pageContext.request.contextPath}/images/pic6.jpg" alt=""/>
					<h3>branded cargos</h3>
					<div class="price">
						<h4>$300<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="clear"></div>
		</div>	
		<!-- end grids_of_3 -->
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