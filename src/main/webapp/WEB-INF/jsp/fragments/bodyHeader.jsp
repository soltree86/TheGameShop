<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
<spring:url value="/resources/images/banner-graphic.png" var="banner"/>
<img src="${banner}"/>


<script>
$(document).ready(function(){

	//$("ul.subnav").parent().append("<span></span>"); //Only shows drop down trigger when js is enabled (Adds empty span tag after ul.subnav*)
	
	$("li.dropdown a.dropdown-toggle").hover(function() { //When trigger is clicked...
		//Following events are applied to the subnav itself (moving subnav up and down)
		$(this).find("ul.dropdown-menu").slideDown('fast').show(); //Drop down the subnav on click
		//$(this).addClass("subhover"); //On hover over, add class "subhover"
	}, function(){	
		//$(this).removeClass("subhover"); //On hover out, remove class "subhover"
		$(this).find("ul.dropdown-menu").slideUp('fast'); //When the mouse hovers out of the subnav, move it back up
	});

});
</script>
 --> 

<div class="topbar">
	<div class="loginbar">
		<c:choose>
	        <c:when test="${empty sessionScope.username}">
				<a href="<spring:url value="/login" htmlEscape="true" />">login</a>
			</c:when>
	        <c:otherwise>
				Logged In As : ${sessionScope.username} <a href="<spring:url value="/j_spring_security_logout" htmlEscape="true" />">logout</a>
			</c:otherwise>
    	</c:choose>
	</div>
	<div class="cartbar">
		<a href="<spring:url value="/checkout" htmlEscape="true" />">checkout</a>
	</div>
</div>


<nav class="navbar navbar-inverse" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand"
			href="<spring:url value="/" htmlEscape="true" />">TheGameShop</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<c:choose>
				<c:when
					test="${not empty sessionScope.role && sessionScope.role == 'ROLE_ADMIN'}">
					<li class="dropdown"><a
						href="<spring:url value="/admin" htmlEscape="true" />"
						class="dropdown-toggle" data-toggle="dropdown">Admin<b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a
								href="<spring:url value="/admin/addProductPage" htmlEscape="true" />"
								title="Add Product">Add Product</a></li>
							<li><a
								href="<spring:url value="/admin/productList" htmlEscape="true" />"
								title="Edit/Delete Product">Edit/Delete Product</a></li>
						</ul></li>
				</c:when>
			</c:choose>
			<li><a href="<spring:url value="/shop" htmlEscape="true" />">Shop</a></li>
			<li class="dropdown"><a
				href="<spring:url value="/company" htmlEscape="true" />"
				class="dropdown-toggle" data-toggle="dropdown">Company<b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">About Us</a></li>
					<li><a href="#">Our Vision</a></li>
					<li><a href="#">What's New</a></li>
				</ul></li>			
			<li class="dropdown">
				<a href="<spring:url value="/register" htmlEscape="true" />" class="dropdown-toggle" data-toggle="dropdown">Membership<b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a
						href="<spring:url value="/register" htmlEscape="true" />"
						title="Registration">Registration</a></li>
					<li><a href="#" title="My Account">My Account</a></li>
					<li><a
						href="<spring:url value="/cancelMemberShip" htmlEscape="true" />"
						title="Cancellation">Cancel Membership</a></li>
				</ul></li>
			<li class="dropdown"><a
				href="<spring:url value="/contactus" htmlEscape="true" />"
				class="dropdown-toggle" data-toggle="dropdown">Contact Us<b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#" title="Store Location">Store Location</a></li>
					<li><a href="#" title="Q & A">Q And A</a></li>
				</ul></li>
		</ul>
		<!-- form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form> -->
	</div>
	<!-- /.navbar-collapse -->
</nav>

