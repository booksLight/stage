<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="template/header.jsp" />

<jsp:useBean id="now" class="java.util.Date" />
        <div class="container">

            <div class="row">

                <form:form commandName="order" class="form-horizontal">

                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
							<br/>
                       <div> <center><h2>Invoice / Bill</h2>
                        	<h3> <strong><u>BT-<fmt:formatDate pattern="yyMMdd" value="${order.getStamped()}" />${order.customerOrderId}</u></strong></h3> 
                    	 </center>
                    	</div> <br/><br/>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-5">
                            <h3>  ${customer.cart.customer.customerName}</h3> 
                                <address>
                                    <strong>Shipping Address</strong><br/>
                                   	
                                    ${customer.cart.customer.shippingAddress.apartmentNumber}   <br/> ${customer.cart.customer.shippingAddress.streetName}
                                <br/>
                                    ${customer.cart.customer.shippingAddress.city}, ${customer.cart.customer.shippingAddress.state}
                                <br/>
                                     ${customer.cart.customer.shippingAddress.country}, ${customer.cart.customer.shippingAddress.zipCode}
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p>Shipping Date: <fmt:formatDate type="date" value="${now}" /></p>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Billing Address</strong><br/>
                                     ${customer.cart.customer.billingAddress.apartmentNumber}   <br/>
                                        ${customer.cart.customer.billingAddress.streetName}
                                    <br/>
                                        ${customer.cart.customer.billingAddress.city}, ${customer.cart.customer.billingAddress.state}
                                    <br/>
                                        ${customer.cart.customer.billingAddress.country}, ${customer.cart.customer.billingAddress.zipCode}
                                </address>
                            </div>
                        </div>

                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <td>Product</td>
                                        <td>#</td>
                                        <td class="text-center">Price</td>
                                        <td class="text-center">Total</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.product.productId}</em></td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
                                        <td class="col-md-1" style="text-align: center">NA</td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.totalPrice}</td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Grand Total:</strong></h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4 class="fa fa-inr" style="font-size:22px;color:red"><strong> ${order.cart.grandTotal}</strong></h4>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </div>


                        <input type="hidden" name="_flowExecutionKey" />

                        <br/><br/>

 <center>	<a class="btn btn-default" href="${pageContext.request.contextPath}/customer/cart">Okay</a> </center>
		
		

                      
                    </div>
                </form:form>
            </div>
        </div>


<script src="<c:url value="${pageContext.request.contextPath}/resources/js/controller.js"/>"></script>
<!-- Footer  -->
<jsp:include page="template/footer.jsp" />