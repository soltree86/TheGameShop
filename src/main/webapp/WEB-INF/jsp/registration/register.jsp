<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
  		<jsp:include page="../fragments/bodyHeader.jsp" />
  		<div class="content">
  		<h3>Register Account</h3>
		<c:choose>
  			<c:when test="${isLoggedIn}">
  				<h1>Please LogOut First to Register.</h1>
			</c:when>
  			<c:otherwise>
  				<spring:url value="/createUser" htmlEscape="true" var="createUser"/>
				<form:form name='f' action="${createUser}" commandName="user" role="form">
					<div class="form-group">
						<label for="userEmail">Email address</label> 
						<form:input path="username" type="email" id="userEmail" class="form-control" style="width:20%"  placeholder="Enter email"></form:input>
						<form:errors path="username" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="userPassword">Password</label> 
						<form:input path="password" type="password" class="form-control" style="width:20%" id="userPassword" placeholder="Password"></form:input>
						<form:errors path="password" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="userFirstName">First Name</label> 
						<form:input path="firstName" type="text" class="form-control" style="width:20%" id="userFirstName" placeholder="First Name"></form:input>
						<form:errors path="firstName" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="userLastName">Last Name</label> 
						<form:input path="lastName" type="text" class="form-control" style="width:20%" id="userLastName" placeholder="Last Name"></form:input>
						<form:errors path="lastName" class="text-danger"></form:errors>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form:form>
  			</c:otherwise>
  		</c:choose>
  		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
