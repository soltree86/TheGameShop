<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Spring MVC Multiple File Upload</title>
<style>
	body {font-family: "Trebuchet MS";}
	h1 {font-size: 1.5em;}
</style>
</head>
<body>
<h1>Spring Multiple File Upload example</h1>

<form:form method="post" action="save" 
		modelAttribute="uploadForm" enctype="multipart/form-data">

	<p>Select files to upload. Press Add button to add more file inputs.</p>
	<table id="fileTable">
		<tr>
			<td><input name="file" type="file" /></td>
		</tr>
	</table>
	<br/><input type="submit" value="Upload" />
</form:form>
</body>
</html>
