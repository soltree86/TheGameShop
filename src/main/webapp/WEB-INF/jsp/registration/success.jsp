<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<span>Optional : </span>
					
					<span>Billing Address </span>
					<div class="form-group">
						<label for="billingStreet1">Street 1</label> 
						<form:input path="address1.street1" type="text" class="form-control" id="billingStreet1" placeholder="Street 1"></form:input>
					</div>
					<div class="form-group">
						<label for="billingStreet2">Street 2</label> 
						<form:input path="address1.street2" type="text" class="form-control" id="billingStreet2" placeholder="Street 2"></form:input>
					</div>
					<div class="form-group">
						<label for="billingCity">City</label> 
						<form:input path="address1.city" type="text" class="form-control" id="billingCity" placeholder="City"></form:input>
					</div>
					<div class="form-group">
						<label for="billingState">State</label> 
						<form:input path="address1.state" type="text" class="form-control" id="billingState" placeholder="State"></form:input>
					</div>
					<div class="form-group">
						<label for="billingZip">Zip Code</label> 
						<form:input path="address1.zip" type="text" class="form-control" id="billingZip" placeholder="Zip Code"></form:input>
					</div>
</body>
</html>