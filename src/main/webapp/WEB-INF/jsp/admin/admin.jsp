<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<h1>Message : ${message}</h1>
		<h1>UserName : ${sessionScope.username}</h1>
		<h1>Role : ${sessionScope.role}</h1>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
