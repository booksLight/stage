<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="<c:url value="/resources/css/test.css"/>" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<input type="checkbox" id="sidemenucheckbox" />

<label id="sidemenutoggler" for="sidemenucheckbox" onClick="legacybrowsertoggle()">Toggle Menu</label>

<nav id="leftsidemenu">

	<ul>
	<li><a href="http://www.dynamicdrive.com">Home</a></li>
	<li><a href="http://www.dynamicdrive.com/new.htm">DHTML</a></li>
	<li><a href="http://www.dynamicdrive.com/style/">CSS Library</a></li>
	<li><a href="http://www.cssdrive.com">CSS Gallery</a></li>
	<li><a href="http://www.javascriptkit.com">JavaScript</a></li>
	</ul>
<label id="closex" for="sidemenucheckbox" onClick="legacybrowsertoggle()">Close</label>
</nav>
	
<div class="overlay"><label for="sidemenucheckbox"></label></div>

</body>
</html>