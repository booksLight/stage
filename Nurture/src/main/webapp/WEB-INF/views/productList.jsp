<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="template/header.jsp" />
  <div class="container"><br/><br/>
	<center>
	<div class="page-header">
 		<h2>All Products</h2>
	</div>
       
 <jsp:include page="products.jsp"/> 
 
 <div class="pagination">
 <c:if test="${not empty pages}">
	
		<a href="/product/productList/0"  >&laquo; </a>
 		<c:forEach var="pp" items="${pages}">
  			<a href="/product/productList/${pp}"> <c:out value="${pp}" /> </a>
		</c:forEach>
  <a href="#">&raquo;</a>
  </c:if>
</div>
	
	</center>
	
</div>
<!-- Footer  -->
<jsp:include page="template/footer.jsp" />
