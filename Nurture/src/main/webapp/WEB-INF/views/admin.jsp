<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="<c:url value="/resources/css/admin.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/test.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/media/css/jquery.dataTables.min.css"/>" rel="stylesheet"> 
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

	<script src="<c:url value="/resources/media/js/jquery.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/media/js/jquery.dataTables.min.js"/>"></script>
	<script src="<c:url value="/resources/js/admin.js"/>"></script>
<script src="<c:url value="/resources/js/admin.js"/>"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<div id="maincontainer">

<div id="topsection"><div class="innertube">
<jsp:include page="template/header.jsp" />
</div></div>

<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube" id="mainDiv">
<div  id="subDiv"></div>
<b><em><div id="txt"></div></em></b>
</div>
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
	<div class="overlay"><label for="sidemenucheckbox"></label> </div>

</div>
<p align="justify">
<b> Dear Admin,</b> <br/><br/>

Being delighted to use our reach interfaces; request to plz provide your valuable suggestion to makes it relable and user friendly more!
<br/><br/>Without your aspiration; the presently states of  this program not possible and would like to assert your credits here while looking forward to continue.
<br/><br/>

Thanks & Regards,
<br/>
 <b> <i>
 Rakesh Sharma<br/>
 Program Authority 
 </i>
</b></p>
</div>

<div id="footer">
<!-- Footer  -->
<jsp:include page="template/footer.jsp" />
</div>
</div>

