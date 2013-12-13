<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
  		<jsp:include page="../fragments/bodyHeader.jsp" />
  		<h3>My Account</h3>
  		<div>
  			<h4>Order Detail</h4>
  			<table>
  				<tr>
  					<td>Date :</td>
  					<td>${order.orderDt}</td>
  				</tr>
  				<tr>
  					<td>Shipping Method :</td>
  					<td>
  						<c:choose>
  							<c:when test="${order.shippingmethod.shippingMethodId == 1}">
  								Fedex
  							</c:when>
  							<c:when test="${order.shippingmethod.shippingMethodId == 2}">
  								UPS
  							</c:when>
  							<c:otherwise>
  								USPS
  							</c:otherwise>
  						</c:choose> 
  					
  					</td>
  				</tr>
  				<tr>
  					<td>Total Cost :</td>
  					<td>$ ${order.cost}</td>
  				</tr>
  			</table>
  		</div>
  		<div>
  			<h4>Order Items</h4>
  			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Quantity</th>
						<th>Cost</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${productList}">
					<tr>
						<td style="width:70%"><c:out value="${item.name}" /></td>
						<td><c:out value="${item.numItems}" /></td>
						<td><c:out value="$ ${item.price * item.numItems}" /></td>
						<td><a href='<spring:url value="/shop/itemDetail/${item.id}"/>'><button type="submit" class="btn btn-default" >Detail</button></a></td>
					</tr>
					</c:forEach>
					<tr>
						<td colspan="3">Total Cost : </td>
						<td>$ ${order.cost}</td>
					</tr>
				</tbody>
			</table>
  		</div>
  		
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
