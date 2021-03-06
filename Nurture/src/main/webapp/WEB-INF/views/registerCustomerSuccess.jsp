<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="template/header.jsp" />


        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Customer registered successfully!</h1>
                </div>
            </div>
        </section>

        <section class="container">
            <p>
                <a href="<spring:url value="${pageContext.request.contextPath}/product/productList"/>" class="btn btn-default">Products</a>
            </p>
        </section>



<script src="<c:url value="${pageContext.request.contextPath}/resources/js/controller.js"/>"></script>


<!-- Footer  -->
<jsp:include page="template/footer.jsp" />
