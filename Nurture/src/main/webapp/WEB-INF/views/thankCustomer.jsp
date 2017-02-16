<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />


        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thank you for your business!</h1>

                    <p>Your order will be shipped in two business days!</p>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<spring:url value="/" />" class="btn btn-default">OK</a></p>
        </section>



<!-- Footer  -->
<jsp:include page="/WEB-INF/views/template/footer.jsp" />

