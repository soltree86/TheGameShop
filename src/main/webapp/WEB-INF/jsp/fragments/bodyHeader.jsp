<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="topbar">
	<div class="imagebar">
		<img src="<spring:url value="/resources/images/logo.jpg" htmlEscape="true" />" width="200px">
	</div>
	<div class="loginbar">
		<c:choose>
	        <c:when test="${empty sessionScope.username}">
				<a href="<spring:url value="/login" htmlEscape="true" />"><button type="button" class="btn btn-link">login</button></a>
			</c:when>
	        <c:otherwise>
				Logged In As : ${sessionScope.username} <a href="<spring:url value="/j_spring_security_logout" htmlEscape="true" />"><button type="button" class="btn btn-link">logout</button></a>
			</c:otherwise>
    	</c:choose>
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
					<li><a href="<spring:url value="/company" htmlEscape="true" />">About Us</a></li>
					<li><a href="<spring:url value="/company/vision" htmlEscape="true" />">Our Vision</a></li>
					<li><a href="<spring:url value="/company/news" htmlEscape="true" />">What's New</a></li>
				</ul></li>			
			<li class="dropdown">
				<a href="<spring:url value="/register" htmlEscape="true" />" class="dropdown-toggle" data-toggle="dropdown">Membership<b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a
						href="<spring:url value="/register" htmlEscape="true" />"
						title="Registration">Registration</a></li>
					<li><a
						href="<spring:url value="/myAccount" htmlEscape="true" />"
						title="My Account">My Account</a></li>
					<li><a
						href="<spring:url value="/cancelMemberShip" htmlEscape="true" />"
						title="Cancellation">Cancel Membership</a></li>
				</ul></li>
			<li class="dropdown"><a
				href="<spring:url value="/contactus" htmlEscape="true" />"
				class="dropdown-toggle" data-toggle="dropdown">Contact Us<b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="<spring:url value="/company/location" htmlEscape="true" />">Store Location</a></li>
					<li><a href="<spring:url value="/company/contactUs" htmlEscape="true" />">Contact Us</a></li>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
	      	<li><a href="<spring:url value="/shop/shoppingCart" htmlEscape="true" />">Shopping Cart</a></li>
	    </ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>

