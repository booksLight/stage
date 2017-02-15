<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />

        <div class="page-header">
            <h1>All Products</h1>
		<p class="lead"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Check all the awesome products available now!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png"/>"
                             alt="image" style="width: 20%"></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td class="fa fa-inr" style="font-size:20px;color:red";align="right">${product.productPrice}</td>
                    <td>
                    	<a href="<spring:url value="/product/viewProduct/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                   </td>
                </tr>
            </c:forEach>
        </table>


<!-- Footer  -->
<jsp:include page="/WEB-INF/views/template/footer.jsp" />
