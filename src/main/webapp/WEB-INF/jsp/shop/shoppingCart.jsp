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
		<h3>Shopping Cart</h3>
		<h4 class="text-danger">${message}</h4>
		<spring:url value="/shop/updateCart" var="updateCart"></spring:url>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Quantity</th>
					<th>Action</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${cart.itemList}">
				<tr>
					<td style="width:70%"><c:out value="${item.name}" /></td>
					<td>
						<form method="post" action="${updateCart}">
							<input type="text" size="4" maxlength="4"  name="numItems" value="${item.numItems}"/>
							<input type="hidden" name="id" value="${item.id}" />
							<input type="submit" class="btn btn-default" value="Update" />
						</form>
					</td>
					<td><a href='<spring:url value="/shop/remove/${item.id}"/>'><button type="submit" class="btn btn-default" >Remove</button></a></td>
					<td><c:out value="$ ${item.price * item.numItems}" /></td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="3">Total Cost : </td>
					<td>$ ${cart.totalCost}</td>
				</tr>
			</tbody>
		</table>
		<spring:url value="/shop" var="shop"></spring:url>
		<spring:url value="/checkout" var="checkout"></spring:url>
		<a href="${shop}"><button type="submit" class="btn btn-primary" >Continue Shopping</button></a>	
		<c:choose>
			<c:when test="${cart.totalCost > 0}">
				<a href="${checkout}"><button type="submit" class="btn btn-success" >Check Out</button></a>
			</c:when>
		</c:choose>	
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>