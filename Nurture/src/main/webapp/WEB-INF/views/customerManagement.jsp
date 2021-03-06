<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      <h2>Customer Management Page</h2>
    <table class="table table-striped table-hover">
      <thead>
      <tr class="bg-success">
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>UserID</th>
        <th>Enabled</th>

      </tr>
      </thead>
      <c:forEach items="${customers}" var="customer">
        <tr>
          <td>${customer.customerName}</td>
          <td>${customer.customerEmail}</td>
          <td>${customer.customerPhone}</td>
          <td>${customer.userId}</td>
          <td>${customer.enabled}</td>

        </tr>
      </c:forEach>
    </table>