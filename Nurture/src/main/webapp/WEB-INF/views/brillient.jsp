<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"> <br/>  
 <jsp:include page="template/header.jsp" />
  <div class="container"><br/>
 <center>
	<div class="page-header">
 		<h2>Brilliant Public School - Study Kits</h2>
	</div>

<jsp:include page="products.jsp"></jsp:include>

<div class="pagination">
 <c:if test="${fn:length(pages) > 0}">
	<a href="/vender/brillient/0"  >&laquo; </a>
 <c:forEach var="p" items="${pages}">
  <a href="/vender/brillient/${p}"> <c:out value="${p}" /> </a>
</c:forEach>
  <a href="#">&raquo;</a>
 </c:if>
</div>

</center>
</div>
<!-- Footer  -->
<jsp:include page="template/footer.jsp" />