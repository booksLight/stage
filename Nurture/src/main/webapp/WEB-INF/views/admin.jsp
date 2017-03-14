<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />
<!-- <script src="<c:url value="/resources/js/adminCtr.js"/>"></script>
 <script src="adminCtr.js"></script> -->
<script src="<c:url value="/resources/js/adminCtr.js"/>"></script>
 
<div ng-app="demo">
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
<hr/>
	<div>
            <p class="greeting-id">The ID is </p>
            <p class="greeting-content">The content is </p>
        </div>

	
</div>		
<!-- Footer  -->
<jsp:include page="/WEB-INF/views/template/footer.jsp" />
