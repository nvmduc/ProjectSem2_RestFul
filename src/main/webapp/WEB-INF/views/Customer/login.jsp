<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="layout/header.jsp"></jsp:include>
<div class="clear"></div>

<div id="page-content">
	<div class="container">
		<div class="row">
			<div style="padding-top: 100px">
				<div class="get-quote-form">
						<h2>Login</h2>
						<form:form action="postlogin" modelAttribute="accLogin"
							method="post" id="get-quote">
							<div>
								<input type="text" name="email" placeholder="Email" />
							</div>
							<div>
								<input style="padding-left: 10px" type="password"
									name="password" placeholder="Password" />
							</div>
							<a href="initregister">You don't have an account?</a>
							<div class="text-center">
								<input type="submit" class="btn-default" value="Submit" />
							</div>
						</form:form>
					</div>
			</div>

		</div>
	</div>

</div>
<div class="clear"></div>
<jsp:include page="layout/footer.jsp"></jsp:include>