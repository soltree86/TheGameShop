<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<div class="content">
		<h3>Login Page</h3>
		<h4 class="text-danger">${message}</h4>
		<form name='f' action="<c:url value='j_spring_security_check' />" method='POST' role="form">
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> 
				<input name='j_username' type="email" class="form-control" style="width:20%" id="exampleInputEmail1" placeholder="Enter email">
			</div> 
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> 
				<input name='j_password' type="password" class="form-control" style="width:20%" id="exampleInputPassword1" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
