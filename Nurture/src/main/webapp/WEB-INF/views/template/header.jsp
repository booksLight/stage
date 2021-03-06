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
	
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Books Light</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">    
    <link href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/demo.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/footer.css"/>" rel="stylesheet">	
   <link href="<c:url value="/resources/media/css/jquery.dataTables.min.css"/>" rel="stylesheet">  
   

  <!-- Common JS -->
   	<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
        <script src="<c:url value="/resources/js/jquery-1.12.2.min.js"/>"></script>
        <script src="<c:url value="/resources/media/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/media/js/jquery.dataTables.min.js"/>"></script>
        <script src="<c:url value="/resources/js/controller.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
		
		

</head>
<!-- NAVBAR ================================================== -->
<body>
<div id="header">
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
                    <a class="navbar-brand" href="/">${model.title}</a> 
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                <!--  Modifiying -->
                
                	<div id="hDiv" class="hgdiv" style="display:block">
                	<div style="page-break-inside: avoid">
                    <ul class="nav navbar-nav">
                        <li <%--class="active"--%>><a href="<c:url value="${pageContext.request.contextPath}/"/>">${model.home}</a></li>
                        <li><a href="<c:url value="${pageContext.request.contextPath}/product/productList/0"/>">${model.product}</a></li>
                        <li><a href="#contact">${model.contact}</a></li>
                    </ul>
                    </div>
                    <div  style="ppage-break-before: always">
                    <ul class="nav navbar-nav pull-right" > 
                    
                       <c:if test="${model.userVo != null}">
                         <c:if test="${model.userVo.name != null}">
                            
                            <li><a>Welcome: ${model.userVo.name}</a></li>
                            <li><a href="<c:url value="${pageContext.request.contextPath}/security_logout"/>">Logout</a></li>
                          </c:if>
                          
                            <c:if test="${model.userVo.type == 'ADMIN'}">
                              <li><a href="<c:url value="${pageContext.request.contextPath}/customer/cart"/>">Cart</a></li>
                               <li><a href="<c:url value="${pageContext.request.contextPath}/customer/profile"/>">Profile</a></li>
                                <li><a href="<c:url value="${pageContext.request.contextPath}/admin"/>">Admin</a></li>
                                
                               </c:if>
                            
                             <c:if test="${model.userVo.type == 'CUSTOMER'}">
                               <li><a href="<c:url value="${pageContext.request.contextPath}/customer/cart"/>">Cart</a></li>
                                <li><a href="<c:url value="${pageContext.request.contextPath}/customer/profile"/>">Profile</a></li>
                            </c:if>
                        </c:if> 
                        <c:if test="${model.userVo == null}">
                            <li><a href="<c:url value="${pageContext.request.contextPath}/login"/>">Login</a></li>
                        </c:if>
                    </ul>
                  
                    </div>
                    </div>
                </div>
            </div>
        </nav>
</div>
</div>
 </div>
