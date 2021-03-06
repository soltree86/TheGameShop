<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<div class="content">
		<h3>Edit Product</h3>
		<div class="col-md-5">
		<img src="<spring:url value="${image}"/>" width="400px" height="350px" />
		</div>
		<div class="col-md-7">
			<spring:url value="/admin/editProduct" htmlEscape="true" var="editProduct"/>
			<form:form name='form' action="${editProduct}" commandName="productDTO" role="form" enctype="multipart/form-data">
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
								<label class="radio">
									<form:radiobutton path="enabled" id="enabled" placeholder="Enable" value="1"/>Enable
								</label> 
								<label class="radio">
									<form:radiobutton path="enabled" id="enabled" placeholder="Disable" value="0" />Disable
								</label>
							</div>
						</td>
						<td>
							<div class="form-group"><strong>Categories</strong> <form:errors path="category" class="text-danger"></form:errors>
								<label class="radio">
									<form:radiobutton path="category" id="category" placeholder="Console" value="1"/>Console
								</label> 
								<label class="radio">
									<form:radiobutton path="category" id="category" placeholder="PC" value="0" />PC
								</label> 
							</div>
						</td>
						<td>
							<strong>Genre</strong> <form:errors path="genreList" class="text-danger"></form:errors>
								<div class="checkbox">
									<label>
										<form:checkbox path="genreList" id="genre1" value="Action Game" />Action Game
									</label>
								</div>
								<div class="checkbox">
									<label>
										<form:checkbox path="genreList" id="genre2" value="Sports Games" />Sports Games
									</label>
								</div>
								<div class="checkbox">
									<label>
										<form:checkbox path="genreList" id="genre3" value="Adventure Games" />Adventure Games
									</label>
								</div>
								<div class="checkbox">
								<label for="genre4">
									<form:checkbox path="genreList" id="genre4" value="First Person Shooters" />First Person Shooters
								</label>
								</div>
								<div class="checkbox">
								<label  for="genre5">
									<form:checkbox path="genreList" id="genre5" value="Fighting Games" />Fighting Games
								</label>
								</div>
								<div class="checkbox">
								<label for="genre6">
									<form:checkbox path="genreList" id="genre6" value="Strategy Games" />Strategy Games
								</label>
								</div>
								<div class="checkbox">
								<label for="genre7">
									<form:checkbox path="genreList" id="genre7" value="Role-Playing Games" />Role-Playing Games
								</label>
								</div>
								<div class="checkbox">
								<label for="genre8">
									<form:checkbox path="genreList" id="genre8" value="Survival Horror Games" />Survival Horror Games
								</label>
								</div>
								<div class="checkbox">
								<label for="genre9">
									<form:checkbox path="genreList" id="genre9" value="Massive Multiplayer Online Games" />Massive Multiplayer Online Games
								</label>
								</div>
								<div class="checkbox">
								<label for="genre10">
									<form:checkbox path="genreList" id="genre10" value="Puzzle Games" />Puzzle Games
								</label>
								</div>
								<div class="checkbox">
								<label for="genre11">
									<form:checkbox path="genreList" id="genre11" value="Racing Games" />Racing Games
								</label>
								</div>
								<div class="checkbox">
								<label for="genre12">
									<form:checkbox path="genreList" id="genre12" value="Rhythm Games" />Rhythm Games
								</label>
								</div>
								<div class="checkbox">
								<label for="genre13">
									<form:checkbox path="genreList" id="genre13" value="Simulations" />Simulations
								</label>
								</div>
								<div class="checkbox">
								<label for="genre14">
									<form:checkbox path="genreList" id="genre14" value="Virtual Worlds" />Virtual Worlds
								</label>
								</div>
						</td>
					</tr>
				
				</table>
				
				<br />
				<form:input path="id" type="hidden" id="productId"></form:input>
				<br />
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
