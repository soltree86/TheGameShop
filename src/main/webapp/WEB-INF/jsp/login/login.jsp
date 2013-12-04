<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<h1>${message}</h1>
		<form name='f' action="<c:url value='j_spring_security_check' />" method='POST' role="form">
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> 
				<input name='j_username' type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> 
				<input name='j_password' type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>

		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
