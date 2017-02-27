<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />

  <main>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Fill the below information to add a product</p>
  <input id="tab1" type="radio" name="tabs" class="NoDisplay" checked>
  <label for="tab1">Product Detail</label>
    
  <input id="tab2" type="radio" name="tabs" class="NoDisplay">
  <label for="tab2">Image</label>
    
     <section id="content1">
     
    <p>  
      <table width="80%">
      <form:form class="go-right" action="${pageContext.request.contextPath}/admin/product/addProduct" method="post" commandName="product">
        
        <tr>
        	<td width="50%"> Category & Type </td>
        	<td colspan="2" >
        		<form:select path="productCategory" id="category">
         		<form:option value="Books"></form:option>
         		<form:option value="Stationary"></form:option>
         		<form:option value="Sport & Fitness"></form:option>
         		</form:select>
         	
        		<form:select path="productCondition" id="condition">
         		<form:option value="New"></form:option>
         		<form:option value="Used"></form:option>
         		</form:select>
         	</td>
        
        </tr>
        
         <tr>
         	<td width="50%">Product Name </td>
         	<td colspan="2" width="50%"> <form:input path="productName" id="productName" type="text" placeholder="Product Name"  size="60%"/></td>
         	
       </tr>
        
          <tr>
          	<td width="50%">Description </td>
         	<td colspan="2"><form:textarea path="productDescription" id="description"  placeholder="Product Description" rows="3" cols="60%"/>  </td>
         	
         </tr>
         
        <tr>
          	<td width="50%">Unit In Stock  </td>
          	<td colspan="2"><form:input path="unitStock" id="unitStock" placeholder="Product Unit"/></td>
         	
         </tr>
        
          <tr>
         	<td width="50%">Price</td> 
         	<td colspan="2"><form:input path="productPrice" id="price" placeholder="Product Price"/> </td>
         	 
         </tr>
         
          <tr>
         	<td width="50%">Manufacturer</td> 
         	<td colspan="2"><form:input path="productManufacture" id="pmft" placeholder="Product Manufacture" size="60%"/></td> 
         </tr>
         
         <tr>
         	<td width="50%"></td>
         <td colspan="2">Active<form:radiobutton path="productStatus" id="status" value="active"/> &nbsp;&nbsp;&nbsp;&nbsp;
         	Inactive<form:radiobutton path="productStatus" id="status" value="inactive"/> </td>
         <tr>
        
          <tr  align="right">
         	<td colspan="3">	<input type="submit" value="Submit" class="btn btn-default"> 
         	<a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a> </td>
         </tr>
          </form:form>
          </table>
    </p>
 	
  </section>
    
   <section id="content2">
 <p>
  
      <form:form class="go-right" action="${pageContext.request.contextPath}/admin/product/addProductImg" method="post" commandName="productImg" enctype="multipart/form-data">
        
         <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
        </div>

        <div>
        	<input type="submit" value="Submit" class="btn btn-default"> 
         	<a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a>
        </div>
        
      </form:form>
 </p>
 
  </section>
    
</main>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
