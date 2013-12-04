<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>
    <spring:url value="/resources/images/bullet-arrow.png" htmlEscape="true" var="image"/>
    <img src="${image}"/>
	<h1>Message : ${message}</h1>
    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>

</html>
