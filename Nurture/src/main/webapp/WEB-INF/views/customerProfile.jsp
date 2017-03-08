<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />
  <div class="container">
	 <main>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Snapshoots</p>
    
  <input id="tab1" type="radio" name="tabs" class="NoDisplay" checked>
  <label for="tab1">Profile</label>
  
   <input id="tab2" type="radio" name="tabs" class="NoDisplay">
  <label for="tab2">Your Orders</label>
	 
   <input id="tab3" type="radio" name="tabs" class="NoDisplay">
  <label for="tab3">Your Coupons</label> 
  	
 <!--  CUSTOMER DETAILS  TAB -->
  <section id="content1">
  
    <table class="table table-striped table-hover">
     
      <form:form class="go-right" action="${pageContext.request.contextPath}/" method="post" commandName="customer">
        
         <tr>
        	<td align="right" width="25%">ID </td>
        	<td><form:input path="userId" id="uid" type="text" placeholder="User ID"  readonly="true"/></td>
        </tr>
        
        <tr>
        	<td align="right" width="25%">Name </td>
        	<td><form:input path="customerName" id="name" type="text" placeholder="Customer Name" readonly="true" /></td>
        </tr>
        
         <tr>
         	<td align="right" width="25%">Email </td>
         	<td> <form:input path="customerEmail" id="email" placeholder="Vlaid Email Address" readonly="true"/> </td>
       </tr>
        
         <%--  <tr>
          	<td >Customer Mobile</td>
          	<td></td>
         	<td>  <form:input path="customerPhone" id="mobile" placeholder="Active Mobile Number" readonly="true" />  </td>
         </tr> --%>
         
        <tr>
          	<td align="right" width="25%">Mobile</td>
          	<td> <form:input path="customerPhone" id="phone" placeholder="Active Phone Number" readonly="true"/></td>
         </tr>
         
          </form:form>
          </table>
    </section>
    
    <!--  Orders History -->
   <section id="content2">
   	  <table class="table table-striped table-hover">
   	  	<tr> <th align="center" width="25%">Order ID </th><th>Order Date</th><th align="center" width="25%">Order Status</th></tr>
        	  <c:if test="${orders != null}">
        	  
        	  	<c:forEach items="${orders}" var="order">
        	  	<c:set var="stamp" value="${order.getStamped()}" />
        	  	<tr> <td align="center" width="25%">
        	  		<a href="/cart/order/book/${order.customerOrderId}">
        	  			BT-<fmt:formatDate pattern="yyMMdd" value="${stamp}" />${order.customerOrderId}
        	  		</a>
        	  		</td>
        	  			<td>${order.getStamped()}</td>
        	  		 <td align="center" width="25%">${order.status}</td>
        	  		  
        	  	</tr>
        	  	
        	  	</c:forEach>
        	  
        	  </c:if>
       
   	  </table>
    </section>
    
     <!-- Rewards & Offers -->
   <section id="content3">
   <p><b>Currently you don't have any offer!</b> <br/> <i>Please keep visiting here periodically...</i></p>
    </section>
  </main>
 </div>         
<jsp:include page="/WEB-INF/views/template/footer.jsp" />