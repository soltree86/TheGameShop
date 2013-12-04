<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
<spring:url value="/resources/images/banner-graphic.png" var="banner"/>
<img src="${banner}"/>
 --> 

<script>
$(document).ready(function(){

	//$("ul.subnav").parent().append("<span></span>"); //Only shows drop down trigger when js is enabled (Adds empty span tag after ul.subnav*)
	
	$("ul.topnav li").hover(function() { //When trigger is clicked...
		//Following events are applied to the subnav itself (moving subnav up and down)
		$(this).find("ul.subnav").slideDown('fast').show(); //Drop down the subnav on click
		//$(this).addClass("subhover"); //On hover over, add class "subhover"
	}, function(){	
		//$(this).removeClass("subhover"); //On hover out, remove class "subhover"
		$(this).find("ul.subnav").slideUp('fast'); //When the mouse hovers out of the subnav, move it back up
	});

});
</script>
<div class="topbar">
	<div class="loginbar">
		<c:choose>
	        <c:when test="${empty sessionScope.username}">
				<a href="<spring:url value="/login" htmlEscape="true" />">login</a>
			</c:when>
	        <c:otherwise>
				${sessionScope.username} <a href="<spring:url value="/j_spring_security_logout" htmlEscape="true" />">logout</a>
			</c:otherwise>
    	</c:choose>
	</div>
	<div class="adminbar">
		<a href="<spring:url value="/admin" htmlEscape="true" />">admin</a>
	</div>
	<div class="cartbar">
		<a href="<spring:url value="/checkout" htmlEscape="true" />">checkout</a>
	</div>
</div>

<div class="navbar" style="width: 601px;">
    <div class="navbar-inner">
        <ul class="topnav">
            <li><a href="<spring:url value="/" htmlEscape="true" />"><i class="icon-home icon-white"></i>Home</a></li>
            <li><a href="<spring:url value="/company" htmlEscape="true" />">TheGameShop</a>
            	<ul class="subnav">
            		<li><a href="#" title="Sub Nav Link">About Us</a></li>
            		<li><a href="#" title="Sub Nav Link">Our Vision</a></li>
            		<li><a href="#" title="Sub Nav Link">What's New</a></li>
            	</ul>
            </li>
            <c:choose>
		        <c:when test="${not empty sessionScope.role && sessionScope.role == 'ROLE_ADMIN'}">
					<li><a href="<spring:url value="/admin" htmlEscape="true" />">Admin</a></li>
				</c:when>
	    	</c:choose>
            <li><a href="<spring:url value="/games" htmlEscape="true" />">Shop Games</a>
            	<ul class="subnav">
            		<li><a href="#" title="Console Game">Console Game</a></li>
            		<li><a href="#" title="PC Game">PC Game</a></li>
            	</ul>
            </li>
            <li><a href="<spring:url value="/membership" htmlEscape="true" />">Membership</a>
            	<ul class="subnav">
            		<li><a href="<spring:url value="/register" htmlEscape="true" />" title="Registration">Registration</a></li>
            		<li><a href="#" title="My Account">My Account</a></li>
            		<li><a href="#" title="Cancel Membership">Cancel Membership</a></li>
            	</ul>
            </li>
            <li><a href="<spring:url value="/contactus" htmlEscape="true" />">Contact Us</a>
            	<ul class="subnav">
            		<li><a href="#" title="Store Location">Store Location</a></li>
            		<li><a href="#" title="Q & A">Q And A</a></li>
            	</ul>
            </li>
        </ul>
    </div>
</div>
	
