<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<div class="content">
		<h3>Product Detail</h3>
		<h4 class="text-danger">${message}</h4>
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
							<td>Category:</td>
							<td>
								<c:choose>
	        						<c:when test="${product.isConsole == 1}">
	        							Console
									</c:when>
									<c:otherwise>
										PC
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td>Price:</td> 
							<td>${product.price}</td>
						</tr>
						<tr>
							<td>Availability:</td> 
							<td>
								<c:choose>
	        						<c:when test="${product.quantity > 0}">
	        							Yes
									</c:when>
									<c:otherwise>
										No
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td>Description:</td>
							<td>${product.description}</td>
						</tr>
						<tr>
							<td>
								<a href="<spring:url value="/shop/addToCart/${product.productId}" />" >
									<button type="submit" onClick="return confirm(\'Do you want to add ' + val.name + ' to the Shopping Cart?\')" class="btn btn-warning" >
										Add To Cart
									</button>
								</a>
							</td>
							<td></td>
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