<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />


<script type="text/javascript">
$(document).ready(function(){
	
	$("#productListButton").click(function() {
			var genres = [];
			var productList = '<div id="productInfoList">';
			genres.push($("input:checked").val());
			genres.push($("select option:selected").text());
			
			$.ajax({  
		        url: "/TheGameShop/shop/getProductList",  
		        data: JSON.stringify(genres), 
		        type: "POST",
		        beforeSend: function(xhr) {  
		            xhr.setRequestHeader("Accept", "application/json");  
		            xhr.setRequestHeader("Content-Type", "application/json");  
		        },
		        success: function(data) {
		        	//alert(data.length);
		        	$.each(data, function(i, val){
		        		productList += '<div class="productInfo"><div class="col-md-3"><a href="<spring:url value="/shop/itemDetail/' + val.productId + '" />" >';
		        		productList += '<img src="/TheGameShop<spring:url value="' + val.image + '" />" width="160px"></a>';
		        		productList += '</div><div class="col-md-6"><a href="<spring:url value="/shop/itemDetail/' + val.productId + '" />" >';
		        		productList += '<h4>' + val.name + '</h4></a><h5>Description</h5><h6>' + val.description + '</h6>';
		        		productList += '</div><div class="col-md-2"><h4>Price : $ ' + val.price + '</h4><br />';
		        		productList += '<a href="<spring:url value="/shop/addToCart/' + val.productId + '" />" style="padding-bottom: 5px;">';
		        		productList += '<button type="submit" onClick="return confirm(\'Do you want to add ' + val.name + ' to the Shopping Cart?\')" class="btn btn-warning btn-sm">Add To Cart</button></a> <br />';
		        		productList += '</div></div><hr class="bs-docs-separator"/>';
		        	});
		        	
		        	productList += '</div>';
		        	$("#productInfoList").replaceWith(productList);      
		        }  
		    });
			
			
	});
});

</script>
<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<h3>Product Search</h3>
		<div class="row">
			<div class="col-md-3" style="border-right:1px solid #000;height:500px">
				<div class="form-group">
					<h4>Categories</h4>
					<div class="row">
						<div class="col-md-7">
							<label> <input type="radio" name="category"
								placeholder="Console" checked="checked" value="Console" />Console
							</label>
						</div>
						<div class="col-md-5">
							<label> <input type="radio" name="category"
								placeholder="PC" value="PC" />PC
							</label>
						</div>
					</div>
					<br />
					<h4>Genre</h4>
					
					<select id="genre" class="form-control" name="genre">
					    <option selected="selected" value="Action Game">Action Game</option>
						<option value="Sports Games">Sports Games</option>
						<option value="Adventure Games">Adventure Games</option>
						<option value="First Person Shooters">First Person Shooters</option>
						<option value="Fighting Games">Fighting Games</option>
						<option value="Strategy Games">Strategy Games</option>
						<option value="Role-Playing Games">Role-Playing Games</option>
						<option value="Survival Horror Games">Survival Horror Games</option>
						<option value="Massive Multiplayer Online Games">Massive Multiplayer Online Games</option>
						<option value="Puzzle Games">Puzzle Games</option>
						<option value="Racing Games">Racing Games</option>
						<option value="Rhythm Games">Rhythm Games</option>
						<option value="Simulations">Simulations</option>
						<option value="Virtual Worlds">Virtual Worlds</option>
					</select>
				</div>
				<button type="submit" id="productListButton" class="btn btn-default" >Submit</button>
			</div>
			<div class="col-md-8">
				<h4>Product List</h4>
				<div id="productInfoList">
					<h3 class="text-danger">No Result</h3>
				</div>
			</div>
		</div>
		<br />
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>