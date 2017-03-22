<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link href="<c:url value="/resources/css/admin.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/test.css"/>" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">


<div id="maincontainer">

<div id="topsection"><div class="innertube">
<jsp:include page="template/header.jsp" />
</div></div>

<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube" id="mainDiv"><b>Content Column: <em>Fixed</em></b> ... default contents here...</div>
</div>
</div>

<div id="leftcolumn">
<div class="innertube">
<input type="checkbox" id="sidemenucheckbox" />

<label id="sidemenutoggler" for="sidemenucheckbox" onClick="legacybrowsertoggle()">Toggle Menu</label>
<nav id="leftsidemenu">

	<ul>
	<li> <a href ="#" id="invCatalogue"> Catalogue</a></li>
	<li> <a href ="#" id="invPortfolio">Portfolio</a></li>
	<li> <a href ="#" id="invLedger">Ledgers </a></li>
	
	</ul>
<label id="closex" for="sidemenucheckbox" onClick="legacybrowsertoggle()">Close</label>
</nav>
	<div class="overlay"><label for="sidemenucheckbox"></label></div>

</div>
</div>

<div id="footer">
<!-- Footer  -->
<jsp:include page="template/footer.jsp" />
</div>
</div>

