<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<div class="content">
		<h3>Add Product</h3>
		<spring:url value="/admin/addProductImage" htmlEscape="true" var="addProductImage"/>
		<form:form  method="post" name='f' action="${addProductImage}" modelAttribute="uploadForm" enctype="multipart/form-data">
			<div class="form-group">
				<label for="productImage"><strong>Image</strong></label> 
				<input type="file" name="file" class="form-control" id="productImage" placeholder="Image" />
				<form:errors path="file" class="text-danger"></form:errors>
			</div>
			<br />
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>


			