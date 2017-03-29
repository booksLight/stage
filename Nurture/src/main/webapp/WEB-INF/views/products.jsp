<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

       
	<ul class="products">
		<c:forEach items="${products}" var="product">
		
   		 <li>
        	
           <img src="<c:url value='/images/${product.productId}.png'/>" style="width:105%; height:20%">
         
            <p>${product.productName}</p>
            <p class="fa fa-inr" style="font-size:18px;color:red">${product.productPrice}</p>
       		 <p><a href="<spring:url value='${pageContext.request.contextPath}/product/viewProduct/${product.productId}'/>"><img src="<c:url value='/images/more.png'/>" style="width:30%; height:5%"><span class="glyphicon glyphicon-info-sign"></span></a></p>
    </li><!-- more list items -->
     </c:forEach>
</ul>

