<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!--
PetClinic :: a Spring Framework demonstration
-->

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>TheGameShop :: Web Application for JHU Project</title>


    <spring:url value="/webjars/bootstrap/3.0.3/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/style.css" var="gameshopCss"/>
    <link href="${gameshopCss}" rel="stylesheet"/>

    <spring:url value="/webjars/jquery/2.0.3/jquery.js" var="jQuery"/>
    <script src="${jQuery}"></script>

	<!-- jquery-ui.js file is really big so we only load what we need instead of loading everything -->
    <spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.core.js" var="jQueryUiCore"/>
    <script src="${jQueryUiCore}"></script>

	<spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.datepicker.js" var="jQueryUiDatePicker"/>
    <script src="${jQueryUiDatePicker}"></script>
    
    <!-- jquery-ui.css file is not that big so we can afford to load it -->
    <spring:url value="/webjars/jquery-ui/1.10.3/themes/base/jquery-ui.css" var="jQueryUiCss"/>
    <link href="${jQueryUiCss}" rel="stylesheet"></link>
    
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"/>
    <script src="${bootstrapJs}"></script>
    
    <spring:url value="/resources/js/gameshop.js" var="gameshopJs"/>
    <script src="${gameshopJs}"></script>
    
    
	<link rel="shortcut icon" href="<spring:url value="/resources/images/favicon.ico" htmlEscape="true" />">
    
</head>


