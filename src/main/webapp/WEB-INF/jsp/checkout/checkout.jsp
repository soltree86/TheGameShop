<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<script>
function validateCreditCard() {
	var cardNo = document.getElementById("cardNumber").value;
	var cardexp = /[0-9]{16}/;
	
	if(cardNo.length != 16) {
		alert("Card Number should be 16 digit number");
		return false;
	}
	
	if (!cardexp.exec(cardNo))  {
		alert("Card Number should be 16 digit number");
		return false;
	}
}
</script>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <div class="content">
    <h3>Check Out</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Name</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${cart.itemList}">
			<tr>
				<td style="width:70%"><c:out value="${item.name}" /></td>
				<td>
					<c:out value="${item.numItems}"/>
				</td>
				<td><c:out value="$ ${item.price * item.numItems}" /></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="2">Total Cost : </td>
				<td>$ ${cart.totalCost}</td>
			</tr>
		</tbody>
	</table>
	<spring:url value="/checkout/confirm" var="confirm"></spring:url>
	<form:form name='checkoutForm' action="${confirm}" commandName="checkOutDTO" role="form" >
		<div class="form-group" style="height:400px;">
		<div>
			<h4>Credit Card Information</h4>
			<div>
				<table>
					<tr>
						<td colspan="2">Payment Details</td>
					</tr>
					<tr>
						<td style="width:45%">Credit Card Type</td>
						<td>
							<form:radiobutton path="cardType" value="VISA" checked="checked" />VISA
							<form:radiobutton path="cardType" value="Master Card" />Master Card
							<form:radiobutton path="cardType" value="Discover" />Discover
						</td>
						<td><form:errors path="shippingMethodId" class="text-danger"></form:errors></td>
					</tr>
					<tr>
						<td>Credit Card Number</td>
						<td><input type="text" name="cardNumber" id="cardNumber" /></td>
						<td><form:errors path="shippingMethodId" class="text-danger"></form:errors></td>
					</tr>
					<tr>
						<td>Expiration</td>
						<td>
							Month: <form:select path="month">
									  <option value="1">1</option>
									  <option value="2">2</option>
									  <option value="3">3</option>
									  <option value="4">4</option>
									  <option value="5">5</option>
									  <option value="6">6</option>
									  <option value="7">7</option>
									  <option value="8">8</option>
									  <option value="9">9</option>
									  <option value="10">10</option>
									  <option value="11">11</option>
									  <option value="12">12</option>
									</form:select>
									
							Year :  <form:select path="year">
									  <option value="2001">2001</option>
									  <option value="2002">2002</option>
									  <option value="2003">2003</option>
									  <option value="2004">2004</option>
									  <option value="2005">2005</option>
									  <option value="2006">2006</option>
									  <option value="2007">2007</option>
									  <option value="2008">2008</option>
									  <option value="2009">2009</option>
									  <option value="2010">2010</option>
									  <option value="2011">2011</option>
									  <option value="2012">2012</option>
									  <option value="2013">2013</option>
									  <option value="2014">2014</option>
									  <option value="2015">2015</option>
									  <option value="2016">2016</option>
									  <option value="2017">2017</option>
									  <option value="2018">2018</option>
									  <option value="2019">2019</option>
									  <option value="2020">2020</option>
									</form:select>
						</td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
		<br />
		<div>
			<h4>Shipping Method</h4><form:errors path="shippingMethodId" class="text-danger"></form:errors>
			<form:radiobutton path="shippingMethodId" value="1" />Fedex 
			<form:radiobutton path="shippingMethodId" value="2" />UPS
			<form:radiobutton path="shippingMethodId" value="3" />USPS
		</div>
		<br />
		
		<div class="col-md-6">
			<h4>Shipping Address</h4>
			
			<table>
				<tr>
					<td style="width:50%">Street 1:</td>
					<td><form:input type="text" path="ship.street1" /> </td>
				</tr>
				<tr>
					<td>Street 2 :</td>
					<td><form:input type="text" path="ship.street2" /> </td>
				</tr>
				<tr>
					<td>City :</td>
					<td><form:input type="text" path="ship.city" /> </td>
				</tr>
				<tr>
					<td>State</td>
					<td><form:input type="text" path="ship.state" /> </td>
				</tr>
				<tr>
					<td>zip</td>
					<td><form:input type="text" path="ship.zip" /> </td>
				</tr>
				<tr>
					<td>Country</td>
					<td><form:input type="text" path="ship.country" /> </td>
				</tr>
			</table>
		</div>
		<div class="col-md-6">
				<h4>Billing Address</h4>
				
				<table>
					<tr>
						<td style="width:50%">Street 1:</td>
						<td><form:input type="text" path="bill.street1" /> </td>
					</tr>
					<tr>
						<td>Street 2:</td>
						<td><form:input type="text" path="bill.street2" /> </td>
					</tr>
					<tr>
						<td>City :</td>
						<td><form:input type="text" path="bill.city" /> </td>
					</tr>
					<tr>
						<td>State</td>
						<td><form:input type="text" path="bill.state" /> </td>
					</tr>
					<tr>
						<td>zip</td>
						<td><form:input type="text" path="bill.zip" /> </td>
					</tr>
					<tr>
						<td>Country</td>
						<td><form:input type="text" path="bill.country" /> </td>
					</tr>
				</table>
			</div>
		
		</div>
			
		<button type="submit" onclick="return validateCreditCard();" class="btn btn-default">Submit</button>
	</form:form>
	</div>
    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>
