<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/template/header.jsp" />
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--  <%@include file="/WEB-INF/views/template/header.jsp" %>  --%>
<script>
function popup(){
	document.getElementById('popupLogin').style.display = 'block'; 
	document.getElementById('regDiv').style.display = 'none'; 
	document.getElementById('sing').style.display = 'none'; 
}

function popupClose(){
	document.getElementById('popupLogin').style.display = 'none'; 
	document.getElementById('regDiv').style.display = 'block'; 
	document.getElementById('sing').style.display = 'block'; 
}
</script>

<div class="container-wrapper">
	<div class="container">
		<div id="login-box">

			<div class="center-page">
				<div id="sing" style="display:block">
				<center>
				<h1>Sign Up</h1>
				<h4>
					Already have account ? <a href="javascript:popup()"> Log In</a>
				</h4>
				</center>
				</div>
				
		
		<br /> <br /> <br /> 


	<div id="popupLogin" class="overlay" style="display:none">
			<div class="popup">
				<h2>Sign In</h2>
				<a class="close" href="javascript:popupClose()">X</a>
				<div class="content">
					<form class="go-right" name="loginForm" action="<c:url value="/security_check"/>" method="post">
						
							<div>
								<input id="username" name="username" type="text"
									placeholder="Mobile" > <label for="username">Mobile</label>
							</div>
							<div>
								<input id="password" name="password" type="password" 
									placeholder="Password"> <label for="password">Password</label>
							</div>
							<br/>
							<div align="center">
									<input type="submit" value="Login" class="btn btn-info"/>
							</div>
							</form>
			
			</div>
		</div>
		</div>



			<div id="regDiv" class="gdiv" style="display:block">
			
				<div><h2>Register</h2>
						<h4>
		
					<form:form class="go-right"  action="${pageContext.request.contextPath}/register" method="post" commandName="user">
							
							<div>
								<form:input path="userEmail" id="email" type="text" placeholder="Email"/>
								<label for="email">Email</label>
							</div>

							<div>
								<form:input path="userMobile" id="mobile"  type="text" placeholder="Mobile" /> 
								<label for="mobile">Mobile</label>
							</div>
							<br/>
							<div>
									<input type="submit" id="regBtn" name="regBtn" value="Sign Up" title="Sign Up" class="btn"/>
							</div>
							</form:form>
						</h4>	
							<br/><br/><br/><br/><br/><br/><br/><br/><br/>
				</div>
 				
				
				<div id="socialDiv">
					<h2>Social Login</h2>
					<br /> comming soon... 
				</div>
				<br/><br/><br/><br/><br/><br/><br/>
			</div>
		</div>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>