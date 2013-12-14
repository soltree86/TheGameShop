<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <div class="content">
    <h3>Confirmation</h3>
	
	<h4>Order was successful!!</h4>
	<h5>Confirmation Email has been Sent. Thank you for shopping at TheGameShop.</h5>
	</div>
    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>
