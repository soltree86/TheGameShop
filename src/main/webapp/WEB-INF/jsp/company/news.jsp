<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
	    <div class="content" style="height:500px;">
	    	<h3>News</h3>
			<div class="col-md-4">
				<img alt="main image" src='<spring:url value="/resources/images/news.png"></spring:url>' >
			</div>
			<div class="col-md-8">
				<h3>TheGameShop is Deployed!!</h3>
				<h4>On December 2013,</h4>
				<h4>E-Commerce Web Application for JHU Graduate Course Project is launched successfully!</h4>
			</div>
		</div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>

</html>
