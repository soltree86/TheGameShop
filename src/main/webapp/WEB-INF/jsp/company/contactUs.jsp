<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
	    <div class="content">
			<section class="headline grid-whole" role="heading">
				<h3>
					Contact Us
				</h3>
				<img src="<spring:url value="/resources/images/gameshop-store-inside.jpg"></spring:url>" width="420" height="211" > 
				
				<h2>To contact, Email us admin@thegameshop.com</h2>
				<h4 style="width: 700px;">
					Lorem ipsum dolor sit amet,
					consectetur adipiscing elit. Maecenas tempus libero ut erat
					vestibulum, et sagittis est cursus. Maecenas eget feugiat sem.
					Vivamus ac diam ac massa scelerisque sollicitudin aliquam non dui.
					Vivamus eu pretium diam. Duis tincidunt, felis id accumsan
					ullamcorper, nibh massa vestibulum nunc, in semper libero libero id
					orci. Pellentesque habitant morbi tristique senectus et netus et
					malesuada fames ac turpis egestas. Integer porta quam et pharetra
					pellentesque. Maecenas nec sapien ac enim ornare ultricies et ac
					diam. Sed sit amet gravida leo, vitae sodales justo. Donec in porta
					nisi. Aenean nec fermentum tellus. Mauris vel luctus augue, id
					ultricies est. Fusce at velit est. Nullam bibendum rutrum
					pellentesque. Nunc quis sodales velit.
				</h4>
			</section>

		</div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>

</html>
