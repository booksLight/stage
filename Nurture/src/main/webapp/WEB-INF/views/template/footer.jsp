<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- NAVBAR ================================================== -->
		<!-- The content of your page would go here. -->
<div id="footer">
		<footer class="footer-distributed">

			<div class="footer-left">
				<h3><img class="img-circle"  src="<c:url value="/images/bottomLogo.png"/>"
                             alt="image" style="width:15%" height="10%" > Books <span>Light</span></h3>

				<p class="footer-links">
					<a href="/">Home</a>
					&nbsp;|&nbsp;
					<a href="${pageContext.request.contextPath}/product/productList/0"> Products</a>
					&nbsp;|&nbsp;	
					<a href="#">Services</a>
					&nbsp;|&nbsp;
					<a href="#">Contact</a>
				</p>

				<p class="footer-company-name">2017, &copy; BooksLight</p>
			</div>

			<div class="footer-center">

				<div>
					<i class="fa fa-map-marker"></i>
					<p><span>Jehanabad</span> Bihar, India</p>
				</div>

				<div>
					<i class="fa fa-phone"></i>
					<p>+91 9304 608 227</p>
				</div>

				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:bookslight@outlook.com">Write Us</a></p>
				</div>

			</div>

			<div class="footer-right">

				<p class="footer-company-about">
					<span>About <a href="${pageContext.request.contextPath}/about">...</a></span>
					We are passionate about helping our customers to get the best experience here.
				</p>

				<div class="footer-icons">

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>

			</div>

		</footer>
<!-- /.container -->

</div>
</body>
</html>
