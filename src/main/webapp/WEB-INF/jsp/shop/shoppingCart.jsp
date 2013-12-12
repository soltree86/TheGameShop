<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<h3>Shopping Cart</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${cart.itemList}">
				<tr>
					<td style="width:75%"><c:out value="${item.name}" /></td>
					<td><c:out value="${item.numItems}" /></td>
					<td><c:out value="${item.price}" /></td>
					<td><button type="submit" class="btn btn-default" >Remove</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>