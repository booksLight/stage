<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />
<script src="<c:url value="/resources/js/controller.js"/>"></script>

<div class="container-wrapper">
    <div class="container">
  
                  <h1>Cart</h1>
                    <p>All the selected products in your shopping cart</p>
   
    
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">

                <div>
                    <a class="btn btn-danger pull-left" ng-click = "clearCart()"><span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
                    <a href="<spring:url value="/order/${cartId}" />" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Check out</a>
                </div>

                <br/><br/><br/>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="item" items="${cartItems}">  
                    <tr>
                        <td>${item.productVo.productName}</td>
                        <td>${item.productVo.productPrice}</td>
                        <td>${item.quantity}</td>
                        <td>${item.totalPrice}</td>
                        <td><a href="/cart/rest/cart/remove/${item.cartItemId}" class="label label-danger"><span class="glyphicon glyphicon-remove"></span>remove</a></td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>${calGrandTotal}</th>
                        <th></th>
                    </tr>
                </table>

                <a href="<spring:url value="/product/productList" />" class="btn btn-default">Continue Shopping</a>
            </div>
        
 </div></div>
<br/><br/><br/>
 
<!-- Footer  -->
<jsp:include page="/WEB-INF/views/template/footer.jsp" />

