<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<div class="content">
		<h4 class="text-danger">Message:${message}</h4>
		<h3>Product Detail</h3>
		<table>
			<tr>
				<td>
					<img src="<spring:url value="${product.image}"/>" width="400px" height="350px" />
				</td>
				<td width="20px"></td>
				<td>
					<h3>${product.name}</h3>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>
					<table class="table">
						<tr>
							<td>Price:</td> 
							<td>${product.price}</td>
						</tr>
						<tr>
							<td>Quantity:</td> 
							<td>${product.quantity}</td>
						</tr>
						<tr>
							<td>Enabled:</td> 
							<td>${product.enabled}</td>
						</tr>
						<tr>
							<td>Description:</td>
							<td>${product.description}</td>
						</tr>
					</table>
				</td>
			</tr>

		</table>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>