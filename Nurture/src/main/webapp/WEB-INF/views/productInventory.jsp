<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                    <td><img src="<c:url value='${pageContext.request.contextPath}/images/${product.productId}.png'/>"
                             alt="image" style="width: 100%"></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}</td>
                    <td><a href="<spring:url value='${pageContext.request.contextPath}/product/viewProduct/${product.productId}' />">
                        <span class='glyphicon glyphicon-info-sign'></span></a>
                        <a href="<spring:url value='${pageContext.request.contextPath}/admin/product/deleteProduct/${product.productId}' />">
                            <span class='glyphicon glyphicon-remove'></span></a>
                        <a href="<spring:url value='${pageContext.request.contextPath}/admin/product/editProduct/${product.productId}'/>">
                            <span class="glyphicon glyphicon-pencil"></span></a>

                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="${pageContext.request.contextPath}/admin/product/addProduct"/>" class="btn btn-primary">Add product</a>

   

