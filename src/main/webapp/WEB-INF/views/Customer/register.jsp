<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear"></div>
<div id="page-content">
	<div class="container">
		<div class="row">
			<div style="padding-top: 100px">
				<div class="get-quote-form">
					<!-- 					<section class="col-sm-5 col-md-6 col-lg-6" -->
					<!-- 						style="padding-top: 100px"> -->
					<div class="get-quote-form">
						<h2>Register</h2>
						<form:form action="insertAccount" method="post"
							modelAttribute="acc" enctype="multipart/form-data" id="get-quote">
							<div>
								<form:input type="text" path="name" placeholder="Your Name" />
							</div>
							<div>
								<form:input type="text" path="email" placeholder="Email" />
							</div>
							<div>
								<form:input style="padding-left: 10px" type="password"
									path="password" placeholder="Password" />
							</div>
							<div>
								<form:input type="text" path="phone" placeholder="Phone" />
							</div>
							<div>
								<form:input
									style="width: 100%; border: none; padding: 10px; border-bottom: 1px solid #e9e9e9; color: #989898"
									type="date" path="birthDay" placeholder="Birth Day" />
							</div>
							<div>
								<form:input type="text" path="city" placeholder="City" />
							</div>
							<div>
								<form:input type="text" path="district" placeholder="District" />
							</div>
							<div>
								<form:input type="text" path="wards" placeholder="Wards" />
							</div>
							<div>
								<form:input type="text" path="street" placeholder="Street" />
							</div>
							<div>
								<form:input type="text" path="apartmentNumber"
									placeholder="Apartment Number" />
							</div>
							<div>
								<form:input type="text" path="zipcode" placeholder="Zip Code" />
							</div>
							<div>
								<input name="imgavt" type="file" />
							</div>
							<div class="text-center">
								<input type="submit" class="btn-default" value="Submit" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<!-- 			</section> -->

		</div>
	</div>
	<div class="clear"></div>
	<jsp:include page="footer.jsp"></jsp:include>