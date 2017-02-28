<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="footer, address, phone, icons" />
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/demo.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/footer.css"/>" rel="stylesheet">
	
    
    
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Books Light</title>

    <!-- Angular JS -->
    <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
   
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Carousel CSS -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">

  <!-- Common JS -->
       <script src="<c:url value="/resources/js/controller.js"/>"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="<c:url value="/resources/js/jquery-1.12.2.min.js"/>"><\/script>')</script>
		<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>


</head>
<!-- NAVBAR ================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">${model.title}</a> 
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                <!--  Modifiying -->
                
                	<div id="hDiv" class="hgdiv" style="display:block">
                	<div style="page-break-inside: avoid">
                    <ul class="nav navbar-nav">
                        <li <%--class="active"--%>><a href="<c:url value="/"/>">${model.home}</a></li>
                        <li><a href="<c:url value="/product/productList"/>">${model.product}</a></li>
                        <li><a href="#contact">${model.contact}</a></li>
                    </ul>
                    </div>
                    <div  style="ppage-break-before: always">
                    <ul class="nav navbar-nav pull-right" >
                        <c:if test="${model.userVo != null}">
                         <c:if test="${model.userVo.name != null}">
                            
                            <li><a>Welcome: ${model.userVo.name}</a></li>
                            <li><a href="<c:url value="/security_logout"/>">Logout</a></li>
                          </c:if>
                          
                           <c:if test="${model.isCartEnable() == true}}">
                                <li><a href="<c:url value="/customer/cart"/>">Cart</a></li>
                            </c:if>
                            
                            <c:if test="${model.userVo.type == 'ADMIN'}">
                                <li><a href="<c:url value="/admin"/>">Admin</a></li>
                            </c:if>
                            
                             <c:if test="${model.userVo.type == 'CUSTOMER'}">
                                <li><a href="<c:url value="/customer/profile"/>">Profile</a></li>
                            </c:if>
                        </c:if>
                        <c:if test="${model.userVo == null}">
                            <li><a href="<c:url value="/login"/>">Login</a></li>
                        </c:if>
                    </ul>
                    </div>
                    </div>
                </div>
            </div>
        </nav>
</div>
</div>