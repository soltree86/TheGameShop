<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
  		<jsp:include page="../fragments/bodyHeader.jsp" />
  		
		<c:choose>
  			<c:when test="${isLoggedIn}">
  				<h1>Please LogOut First to Register.</h1>
			</c:when>
  			<c:otherwise>
  				<spring:url value="/createUser" htmlEscape="true" var="createUser"/>
				<form:form name='f' action="${createUser}" commandName="user" role="form">
					<div class="form-group">
						<label for="userEmail">Email address</label> 
						<form:input path="username" type="email" id="userEmail" class="form-control" placeholder="Enter email"></form:input>
						<form:errors path="username" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="userPassword">Password</label> 
						<form:input path="password" type="password" class="form-control" id="userPassword" placeholder="Password"></form:input>
						<form:errors path="password" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="userFirstName">First Name</label> 
						<form:input path="firstName" type="text" class="form-control" id="userFirstName" placeholder="First Name"></form:input>
						<form:errors path="firstName" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="userLastName">Last Name</label> 
						<form:input path="lastName" type="text" class="form-control" id="userLastName" placeholder="Last Name"></form:input>
						<form:errors path="lastName" class="text-danger"></form:errors>
					</div>
					<span>Optional : </span>
					
					<span>Billing Address </span>
					<div class="form-group">
						<label for="billingStreet1">Street 1</label> 
						<form:input path="address1.street1" type="text" class="form-control" id="billingStreet1" placeholder="Street 1"></form:input>
					</div>
					<div class="form-group">
						<label for="billingStreet2">Street 2</label> 
						<form:input path="address1.street2" type="text" class="form-control" id="billingStreet2" placeholder="Street 2"></form:input>
					</div>
					<div class="form-group">
						<label for="billingCity">City</label> 
						<form:input path="address1.city" type="text" class="form-control" id="billingCity" placeholder="City"></form:input>
					</div>
					<div class="form-group">
						<label for="billingState">State</label> 
						<form:input path="address1.state" type="text" class="form-control" id="billingState" placeholder="State"></form:input>
					</div>
					<div class="form-group">
						<label for="billingZip">Zip Code</label> 
						<form:input path="address1.zip" type="text" class="form-control" id="billingZip" placeholder="Zip Code"></form:input>
					</div>
					
					<button type="submit" class="btn btn-default">Submit</button>
				</form:form>
  			</c:otherwise>
  		</c:choose>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
