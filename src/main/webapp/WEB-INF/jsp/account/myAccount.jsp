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
  			<h4>User Information</h4>
  			<table>
  				<tr>
  					<td>UserName :</td>
  					<td>${user.username}</td>
  				</tr>
  				<tr>
  					<td>FirstName :</td>
  					<td>${user.firstName}</td>
  				</tr>
  				<tr>
  					<td>LastName :</td>
  					<td>${user.lastName}</td>
  				</tr>
  			</table>
  		</div>
  		<div>
  			<h4>Order History</h4>
  			<table>
  				<thead>
  					<tr>
  						<th style="width:55%">Description</th>
  						<th>Cost</th>
  						<th style="width:20%">Date</th>
  						<th>Action</th>
  					</tr>
  				</thead>
  				<tbody>
  					<c:forEach var="order" items="${orderList}">
					<tr>
						<td><c:out value="${order.description}" /></td>
						<td><c:out value="$ ${order.cost}" /></td>
						<td><c:out value="${order.orderDt}" /></td>
						<td><a href='<spring:url value="/history/${order.orderId}"></spring:url>'><button type="submit" class="btn btn-default" >View</button></a></td>
					</tr>
					</c:forEach>
  				</tbody>
  			</table>
  		</div>
  		
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
