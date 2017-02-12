<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by :
  User: Rakesh
  Date: 27.01.2017
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Liberary</title>

    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Carousel CSS -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">

  <!-- Common JS -->
<!--     <script src="/resources/js/main.js"></script> -->

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
                    <ul class="nav navbar-nav">
                        <li <%--class="active"--%>><a href="<c:url value="/"/>">${model.home}</a></li>
                        <li><a href="<c:url value="/product/productList"/>">${model.product}</a></li>
                        <li><a href="#contact">${model.contact}</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <c:if test="${model.userVo != null}">
                         <c:if test="${model.userVo.name != null}">
                            
                            <li><a>Welcome: ${model.userVo.name}</a></li>
                            <li><a href="<c:url value="/security_logout"/>">Logout</a></li>
                          </c:if>
                          
                           <c:if test="${model.isCartEnable() == true}}">
                                <li><a href="<c:url value="/customer/cart"/>">Cart</a></li>
                            </c:if>
                            
                            <c:if test="${model.userVo.type == 'admin'}">
                                <li><a href="<c:url value="/admin"/>">Admin</a></li>
                            </c:if>
                        </c:if>
                        <c:if test="${model.userVo == null}">
                            <li><a href="<c:url value="/login"/>">Login</a></li>
                        
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>