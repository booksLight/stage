<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="template/header.jsp" />

 	<div class="container" ng-app="cartApp">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Here is the detail information of the product</p>
        </div>

       
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/images/${product.productId}.png"/>"
                         alt="image" style="width: 100%">
                </div>

                <div class="col-md-5">
                    <h3>${product.productName}</h3>

                    <p>${product.productDescription}</p>

                    <p>
                        <strong>Manufactured</strong>: ${product.productManufacture}
                    </p>

                    <p>
                        <strong>Category</strong> : ${product.productCategory}</p>

                    <p>
                        <strong>Condition</strong> : ${product.productCondition}</p>
                    <h4 class="fa fa-inr" style="font-size:22px;color:red">${product.productPrice}</h4>
                    <br>
                    <c:set var="role" scope="page" value="${param.role}"/>
                    <c:set var="url" scope="page" value="/product/productList/0"/>
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory/0"/>
                    </c:if>
                      <c:set var="ourl" scope="page" value="/cart/rest/cart/add/${product.productId}"/>
                     <c:set var="curl" scope="page" value="/customer/cart"/>
					
					  <p ng-controller="cartCtrl">
                        <a href="<c:url value = "${url}" />" class="btn btn-default">Back</a>
                        <a href="${ourl}" class="btn btn-warning btn-large"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                        <a href="<spring:url value="${curl}" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                    </p>
               
                </div>
            </div>
        </div>


<script src="<c:url value="/resources/js/controller.js"/>"></script>
<!-- Footer  -->
<jsp:include page="template/footer.jsp" />
