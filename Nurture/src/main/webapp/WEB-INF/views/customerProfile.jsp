<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />
	 
	<div class="page-header">
            <h1>Your Profile</h1>
    </div>

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
          
<jsp:include page="/WEB-INF/views/template/footer.jsp" />