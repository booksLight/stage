<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/template/header.jsp" />
<%--  <%@include file="/WEB-INF/views/template/header.jsp" %>  --%>


<div class="container-wrapper">
    <div class="container">
        <div id="login-box">

            <div class="center-page">
                <h2>Login with Username and Password</h2>

                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>

                <form name="loginForm" action="<c:url value="/security_check"/>" method="post">
                    <c:if test="${not empty error}">
                        <div class="error" style="color:#ff0000;">${error}</div>
                    </c:if>
                    <div class="form-group">
                        <label for="username">User: </label>
                        <input type="text" id="username" name="username" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="password">Password: </label>
                        <input type="password" id="password" name="password" class="form-control"/>
                    </div>

                    <input type="submit" value="Submit" class="btn btn-default"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>