<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />
<%--  <%@include file="/WEB-INF/views/template/header.jsp" %>  --%>

<div class="container-wrapper">
  <div class="container">
    <div class="page-header">
      <h1>Admin page</h1>

      <p class="lead">Check all the awesome products available now!</p>
    </div>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
      <h2>Welcome ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/j_spring_security_logout"/>">Logout</a></h2>
    </c:if>

    <h3>
      <a href="<c:url value="/admin/productInventory" />">Product Inventory</a>
    </h3>
  <p>Here you can modify everything</p>

   <br>
   <br>

    <h3>
      <a href="<c:url value="/admin/customers" />">Customer management</a>
    </h3>

    <p>Here you can view the customer information</p>

<%@include file="/WEB-INF/views/template/footer.jsp"%>