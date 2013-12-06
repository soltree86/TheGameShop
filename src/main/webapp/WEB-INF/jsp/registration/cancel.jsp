<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<h1 class="text-danger">${message}</h1>
		<spring:url value="/membershipCancellation" htmlEscape="true" var="cancelMembership"></spring:url>
		<form:form name='f' action="${cancelMembership}" commandName="user" role="form">
			<div class="form-group">
				<label for="userEmail">Email address</label> 
				<form:input path="username" type="email" class="form-control" id="userEmail" placeholder="Enter email"></form:input>
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> 
				<form:input path="password" type="password" class="form-control" id="userPassword" placeholder="Password"></form:input>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>

		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
