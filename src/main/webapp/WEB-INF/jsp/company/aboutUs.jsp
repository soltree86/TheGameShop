<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
	    <div class="content">
			<section class="headline grid-whole" role="heading">
				<h1>
					Welcome to TheGameShop
				</h1>
				<img src="<spring:url value="/resources/images/spyro.png"></spring:url>" width="217" height="232" alt="Spyro">
				<img src="<spring:url value="/resources/images/mario_sm.png"></spring:url>" width="195" height="251" alt="Mario">
				<img src="<spring:url value="/resources/images/boxshots.png"></spring:url>" width="320" height="267" >
				<br />
				<img src="<spring:url value="/resources/images/gameshop-store-inside.jpg"></spring:url>" width="420" height="211" > 
				
				<h2>HI!</h2>
				<h4 style="width:700px;">
					TheGameShop is committed to delivering great games to customers,
					regardless of how and where they play. Whether you game on the go
					with a mobile device or spend hours console gaming with your guild,
					TheGameShop is the number one multichannel video game choice.
				</h4>
			</section>

		</div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>

</html>
