<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
	    <div class="content">
	    	<h3>Vision</h3>
			<img alt="main image" src='<spring:url value="/resources/images/vision.jpg"></spring:url>' >
			
			<h3>Our vision is</h3>
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
			
		</div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>

</html>
