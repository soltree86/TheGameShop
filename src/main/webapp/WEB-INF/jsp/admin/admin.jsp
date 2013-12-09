<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		
		<spring:url value="/admin/addProduct" htmlEscape="true" var="addProduct"/>
		<spring:url value="/admin/editProduct" htmlEscape="true" var="editProduct"/>
		<spring:url value="/admin/deleteProduct" htmlEscape="true" var="deleteProduct"/>
		
		<h2>Admin Page</h2>
		<div class="form-horizontal">
			<a href="${addProduct}" class="btn btn-primary">Add Product</a>
			
			<!-- Indicates a successful or positive action -->
			<a href="${editProduct}" class="btn btn-success">Edit Product</a>
			
			<!-- Contextual button for informational alert messages -->
			<a href="${deleteProduct}" class="btn btn-info">Delete Product</a>
			
		</div>
		
		
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
