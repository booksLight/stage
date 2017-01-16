<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
  <div class="container">
    <section>
      <div class="jumbotron">
        <div class="container">
          <h1 class="alert alert-danger">Checkout canceled</h1>

          <p>Your checkout process is cancelled. You may continue shopping</p>
        </div>
      </div>
    </section>

    <section class="container">
      <p>
        <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Products</a>
      </p>
    </section>

  </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>