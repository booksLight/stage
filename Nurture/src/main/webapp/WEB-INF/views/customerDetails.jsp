<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />
	
<main>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Fill the below information to add a product</p>
  <input id="tab1" type="radio" name="tabs" class="NoDisplay" checked>
  <label for="tab1">Customer Info</label>
    
  <input id="tab2" type="radio" name="tabs" class="NoDisplay" >
  <label for="tab2">Billing Address:</label>
  
   <input id="tab3" type="radio" name="tabs" class="NoDisplay">
  <label for="tab3">Shipping Address:</label>
 
 <!--  CUSTOMER DETAILS  TAB -->
  <section id="content1">
   
    
      <table>
      <form:form class="go-right" action="${pageContext.request.contextPath}/customer/info" method="post" commandName="customer">
       
      
                               
        
        
        <tr>
        	<td> Customer Name </td>
        	<td> <form:hidden path="userId" id="uid" placeholder="User ID" size="3" /> </td>
        	<td>
        		<form:input path="customerName" id="name" type="text" placeholder="Customer Name" />
        	</td>
        </tr>
        
         <tr>
         	<td>Customer Email </td>
         	<td></td>
         	<td>  
         		<form:input path="customerEmail" id="email" placeholder="Vlaid Email Address" readonly="true"/>
          </td>
       </tr>
        
         <%--  <tr>
          	<td >Customer Mobile</td>
          	<td></td>
         	<td>  <form:input path="customerPhone" id="mobile" placeholder="Active Mobile Number" />  </td>
         </tr> --%>
         
        <tr>
          	<td >Customer Phone No. </td>
          		<td></td>
          	<td>
          		<form:input path="customerPhone" id="phone" placeholder="Active Phone Number" readonly="true" />
          	</td>
         </tr>
          <tr  align="right">
         	
         	<td colspan="3"><a class="btn btn-default" href="${pageContext.request.contextPath}/product/productList"> Cancel </a>   
         	<input type="submit" class="btn btn-default" value="Update">
         	</td>
         </tr>
         
          </form:form>
          </table>
 
 	
  </section>
    
    
 <!--  BILLING ADDREES TAB -->
   <section id="content2">

  
    <table>
        <form:form class="go-right" action="${pageContext.request.contextPath}/customer/billing/address" method="post" commandName="customer">
        
        <tr>
        	<td>Building Name/Number</td>
        	<td></td>
        	<td><form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" placeholder="House Name/Number" />
			</td>
        </tr>
        
         <tr>
         	<td>Street Name/Number </td>
         	<td></td>
         	<td> <form:input path="billingAddress.streetName" id="billingStreet"  placeholder="Street"/> </td>
       </tr>
        
          <tr>
          	<td >Customer City </td>
          	<td></td>
         	<td>   <form:input path="billingAddress.city" id="billingCity" placeholder="City/Town " />  </td>
         </tr>
         
        <tr>
          	<td >Customer State </td>
          		<td></td>
          	<td>   <form:input path="billingAddress.state" id="billingState" placeholder="State/Provision" /></td>
         </tr>
          <tr>
          	<td >PIN-CODE </td>
          		<td></td>
          	<td>   <form:input path="billingAddress.zipCode" id="billingZip"  placeholder="PIN/ZIP" /></td>
         </tr>
         
         <tr>
          	<td >Customer Country </td>
          		<td></td>
          	<td>   
          		<form:select path="billingAddress.country" id="billingCountry">
          			<form:option value="-Select-"></form:option>
          			<form:option value="India"></form:option>
          		</form:select>
          	
          	</td>
         </tr>
          <tr  align="right">
         	
         	<td colspan="2"><a class="btn btn-default" href="${pageContext.request.contextPath}/product/productList"> Cancel </a> </td>
         	<td>  <input type="submit" class="btn btn-default" value="Update"></td>
         </tr>
         
          </form:form>
          </table>

  </section>
  
  <!--  SHIPPING ADDREES TAB -->
   <section id="content3">
 
  <p>
    <table>
        <form:form class="go-right" action="${pageContext.request.contextPath}/customer/shipping/address" method="post" commandName="customer">
        
        <tr>
        	<td>Building Name/Number</td>
        	<td width="40"></td>
        	<td><form:input path="shippingAddress.apartmentNumber" placeholder="House Name/Number" />
			</td>
        </tr>
        
         <tr>
         	<td>Street Name/Number </td>
         	<td></td>
         	<td>  <form:input path="shippingAddress.streetName" id="shippingStreet"  placeholder="Street"/> </td>
       </tr>
        
          <tr>
          	<td >Shipping City </td>
          	<td></td>
         	<td>   <form:input path="shippingAddress.city" id="shippingCity" placeholder="City/Town " />  </td>
         </tr>
         
        <tr>
          	<td >Shipping State </td>
          		<td></td>
          	<td>   <form:input path="shippingAddress.state" id="shippingState" placeholder="State/Provision" /></td>
         </tr>
          <tr>
          	<td >Shipping PIN-CODE </td>
          		<td></td>
          	<td>  <form:input path="shippingAddress.zipCode" id="shippingZip"  placeholder="PIN/ZIP" /></td>
         </tr>
         
         <tr>
          	<td >Shipping Country </td>
          		<td></td>
          	<td>   
          		<form:select path="billingAddress.country" id="shippingCountry">
          			<form:option value="-Select-"></form:option>
          			<form:option value="India"></form:option>
          		</form:select>
          	
          	</td>
         </tr>
          <tr  align="right">
         	
         	<td colspan="2"><a class="btn btn-default" href="${pageContext.request.contextPath}/product/productList"> Cancel </a> </td>
         	<td>  <input type="submit" class="btn btn-default" value="Update"></td>
         </tr>
         
          </form:form>
          </table>
 	</p>
  </section>
 
</main>


<jsp:include page="/WEB-INF/views/template/footer.jsp" />