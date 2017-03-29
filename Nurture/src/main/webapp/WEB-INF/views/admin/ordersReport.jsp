<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<title>Ordered:Report</title>
	
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	<script src="<c:url value="/resources/media/js/jquery.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<link href="<c:url value="/resources/media/css/jquery.dataTables.min.css"/>" rel="stylesheet">  
	<script src="<c:url value="/resources/media/js/jquery.dataTables.min.js"/>"></script>
	<script src="<c:url value="/resources/js/admin.js"/>"></script>
			
<table id="ordRepo" class="display" role="grid" compact cellspacing="0" width="95%">
        <thead>
            <tr>
            	<th> Order No</th>
                <th>Customer Name</th>
                <th>Product Name</th>
                <th>Ordered Qty</th>               
                <th>Values (Rs.) </th>
                <th>Stamped</th>               	
               	<th> Status</th>
               	<th> Is Confirmed</th>
               	<th> Is Shipped</th>
            </tr>
        </thead>      
    </table>
  