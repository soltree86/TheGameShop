<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<h3>Add Product</h3>
		<h4 class="text-danger">${message}</h4>
		<spring:url value="/admin/addProduct" htmlEscape="true" var="addProduct"/>
		<form:form name='form' action="${addProduct}" commandName="productDTO" role="form" enctype="multipart/form-data">
			<div class="form-group">
				<label for="productName"><strong>Product Name</strong></label>
				<form:input path="name" type="text" id="productName" class="form-control" placeholder="Enter Name"></form:input>
				<form:errors path="name" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label for="productDescription"><strong>Description</strong></label>
				<form:textarea path="description" rows="5" cols="50" class="form-control" id="productDescription" placeholder="Description"></form:textarea>
				<form:errors path="description" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label for="productPrice"><strong>Price</strong></label>
				<form:input path="price" type="text" class="form-control" id="productPrice" placeholder="Price"></form:input>
				<form:errors path="price" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label for="productQuantity"><strong>Quantity</strong></label>
				<form:input path="quantity" type="text" class="form-control" id="productQuantity" placeholder="Quantity"></form:input>
				<form:errors path="quantity" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label for="productImage"><strong>Image</strong></label> 
				<input type="file" name="file" class="form-control" id="productImage" placeholder="Image" />
				<form:errors path="file" class="text-danger"></form:errors>
			</div>
			<br />
			<table class="table">
				<tr>
					<td>
						<div class="form-group"><strong>Enabled</strong> <form:errors path="enabled" class="text-danger"></form:errors>
							<label class="radio-inline">
								<form:radiobutton path="enabled" class="form-control" id="enabled" placeholder="Enable" value="1"/>Enable
							</label> 
							<label class="radio-inline">
								<form:radiobutton path="enabled" class="form-control" id="enabled" placeholder="Disable" value="0" />Disable
							</label>
						</div>
					</td>
					<td>
						<div class="form-group"><strong>Categories</strong> <form:errors path="category" class="text-danger"></form:errors>
							<label class="radio-inline">
								<form:radiobutton path="category" class="form-control" id="category" placeholder="Console" value="Console"/>Console
							</label> 
							<label class="radio-inline">
								<form:radiobutton path="category" class="form-control" id="category" placeholder="PC" value="PC" />PC
							</label> 
							
						</div>
					</td>
					<td>
						<div class="form-group"><strong>Genre</strong> <form:errors path="genreList" class="text-danger"></form:errors>
							<label class="checkbox-inline" for="genre1">
								<form:checkbox path="genreList" id="genre1" value="Action Game" class="form-control" />Action Game
							</label>
							<label class="checkbox-inline" for="genre2">
								<form:checkbox path="genreList" id="genre2" value="Sports Games" class="form-control" />Sports Games
							</label>
							<label class="checkbox-inline" for="genre3">
								<form:checkbox path="genreList" id="genre3" value="Adventure Games" class="form-control" />Adventure Games
							</label>
							<label class="checkbox-inline" for="genre4">
								<form:checkbox path="genreList" id="genre4" value="First Person Shooters" class="form-control" />First Person Shooters
							</label>
							<label class="checkbox-inline" for="genre5">
								<form:checkbox path="genreList" id="genre5" value="Fighting Games" class="form-control" />Fighting Games
							</label>
							<label class="checkbox-inline" for="genre6">
								<form:checkbox path="genreList" id="genre6" value="Strategy Games" class="form-control" />Strategy Games
							</label>
							<label class="checkbox-inline" for="genre7">
								<form:checkbox path="genreList" id="genre7" value="Role-Playing Games" class="form-control" />Role-Playing Games
							</label>
							<label class="checkbox-inline" for="genre8">
								<form:checkbox path="genreList" id="genre8" value="Survival Horror Games" class="form-control" />Survival Horror Games
							</label>
							<label class="checkbox-inline" for="genre9">
								<form:checkbox path="genreList" id="genre9" value="Massive Multiplayer Online Games" class="form-control" />Massive Multiplayer Online Games
							</label>
							<label class="checkbox-inline" for="genre10">
								<form:checkbox path="genreList" id="genre10" value="Puzzle Games" class="form-control" />Puzzle Games
							</label>
							<label class="checkbox-inline" for="genre11">
								<form:checkbox path="genreList" id="genre11" value="Racing Games" class="form-control" />Racing Games
							</label>
							<label class="checkbox-inline" for="genre12">
								<form:checkbox path="genreList" id="genre12" value="Rhythm Games" class="form-control" />Rhythm Games
							</label>
							<label class="checkbox-inline" for="genre13">
								<form:checkbox path="genreList" id="genre13" value="Simulations" class="form-control" />Simulations
							</label>
							<label class="checkbox-inline" for="genre14">
								<form:checkbox path="genreList" id="genre14" value="Virtual Worlds" class="form-control" />Virtual Worlds
							</label>
						</div>
					</td>
				</tr>
			
			</table>
			
			<br />
			
			
			<br />
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
		
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
