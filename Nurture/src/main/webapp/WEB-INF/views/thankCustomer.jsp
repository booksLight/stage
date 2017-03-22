<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyMMdd" />

<jsp:include page="template/header.jsp" />

        <br/>  <br/>  <br/>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thank you   ${order.cart.customer.customerName} for your business!</h1>

                    <p>Your order (<b><i>${ordReceiptNo}</i></b>)  will be shipped in two business days!</p>
                </div>
            </div>
       

        <div class="container">
            <p><a href="<spring:url value="/" />" class="btn btn-default">OK</a></p>
        </div>

  <br/>  <br/>  <br/>  <br/>

<!-- Footer  -->
<jsp:include page="template/footer.jsp" />

