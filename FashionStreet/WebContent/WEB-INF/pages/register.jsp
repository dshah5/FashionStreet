<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<a href="/FashionStreet/home"><img src="${pageContext.request.contextPath}/images/logo.png" alt=""/> </a>
		</div>
		<div class="h_icon">
		<ul class="icon1 sub-icon1">
			<li><a class="active-icon c1" href="#"><i>$0</i></a>
				<ul class="sub-icon1 list">
					<li><h3>shopping cart empty</h3><a href=""></a></li>
					<li><p>if items in your wish list are missing, <a href="/FashionStreet/contact">contact us</a> to view them</p></li>
				</ul>
			</li>
		</ul>
		</div>
		<div class="h_search">
    		<form>
    			<script src="js/code.js"></script>
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
    					<li><a href="/FashionStreet/logout">logout</a></li>
    					
    				</c:when>
    				<c:otherwise>
        				<li><a href="/FashionStreet/login">login</a></li> |
						<li><a href="/FashionStreet/register">register</a></li>
    				</c:otherwise>
				</c:choose>
			</ul>
		</div>
		
		<div class="top-nav">
	          <nav class="nav">	        	
	    	    <a href="#" id="w3-menu-trigger"> </a>
	                  <ul class="nav-list" style="">
	            	        <li class="nav-item"><a class="active" href="/FashionStreet/index">Home</a></li>
							<li class="nav-item"><a href="/FashionStreet/handbags">Handbags</a></li>
							<li class="nav-item"><a href="/FashionStreet/jewelry">jewelry</a></li>
							<li class="nav-item"><a href="/FashionStreet/wallets">wallets</a></li>
							<li class="nav-item"><a href="/FashionStreet/belts">belts</a></li>
							<li class="nav-item"><a href="/FashionStreet/shoes">shoes</a></li>
							<li class="nav-item"><a href="/FashionStreet/sale">sale</a></li>
							<li class="nav-item"><a href="/FashionStreet/login">login</a></li>
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

	<script type="text/javascript">
    	function validateForm(){
    		var a=document.form.lname.value;
    		var b=document.form.password.value;
    		var c=document.form.fname.value;
    		var d=document.form.email.value;
    		var e=document.form.cpassword.value;
    		if (a==null || a=="" || b==null || b=="" || c==null || c=="" || d==null || d=="" || e==null || e==""){
      			//alert("Please Fill All Required Fields");
      			return false;
      		} else if (e != b) {
      			//alert("Passwords do not match.");
      			return false;
      		}
    	}
    </script>
	 	 <div class="contact">				
				  <div class="contact-form">
			 	  	 	<h2>Sign Up Today!</h2>
			 	  	 	  <%= request.getAttribute("errmessage") %> 
			 	 	    <%-- <form method="post" name="form"  onsubmit="return validateForm()" action="register">
					    	<div>
						    	<span><label>First Name</label></span>
						    	<span><input name="fname" type="text" id="fname" value="" class="textbox"></span>
						    </div>
						    <div>
						    	<span><label>Last Name</label></span>
						    	<span><input name="lname" type="text" id="lname" value="" class="textbox"></span>
						    </div>
						    <div>
						    	<span><label>E-mail</label></span>
						    	<span><input name="email" type="email" id="email" value="" class="textbox"></span>
						    </div>
						    <div>
						     	<span><label>Password</label></span>
						    	<span><input name="password" type="password" id="password" value="" class="textbox"></span>
						    </div>
						    <div>
						     	<span><label>Confirm Password</label></span>
						    	<span><input name="cpassword" type="password" id="cpassword" value="" class="textbox"></span>
						    </div>
						   <div>
						   		<span><input type="submit" class="" value="Sign Up"></span>
						  </div>
						  <!-- <div>
						   		<button id="restButton">Check Values</button>
						   		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
								<script src="js/code.js"></script>
						  </div> -->
					    </form> --%>
					    <form:form method="POST" commandName="regUser" action="/FashionStreet/reg" >
					    	<div>
						    	<span><label>First Name</label></span>
						    	<span><form:input path="firstName" /></span>
						    </div>
						    <div>
						    	<span><label>Last Name</label></span>
						    	<span><form:input path="lastName" /></span>
						    </div>
						    <div>
						    	<span><label>E-mail</label></span>
						    	<span><form:input path="email"/></span>
						    </div>
						    <div>
						     	<span><label>Password</label></span>
						    	<span><form:password path="password" /></span>
						    </div>
						    <div>
						     	<span><label>Confirm Password</label></span>
						    	<span><input type="password" name="confirmpassword" /></span>
						    </div>
						   <div>
						   		<span><input type="submit" class="" value="Sign Up"/></span>
						  </div>
					    </form:form>
					    
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