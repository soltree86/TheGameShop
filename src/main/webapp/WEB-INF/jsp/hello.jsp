<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>
	    <div class="content">
			<img alt="main image" src='<spring:url value="/resources/images/main.jpg"></spring:url>'  width="100%">
			<h1>Welcome To The Game Shop</h1>
			
			<h3>The Game Shop is...</h3>
			<h4>E-Commerce Web Application for JHU Graduate Course Project. Please Enjoy!!!</h4>
			
		</div>
    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>

</html>
