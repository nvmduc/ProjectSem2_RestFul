<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="clear"></div>
<div id="page-content">
	<div class="container">
		<div class="row">
			<section class="col-sm-5 col-md-6 col-lg-6"
				style="padding-top: 100px">
				<div class="get-quote-form">
					<h2>Information Car</h2>
					<form:form action="insertCar" method="POST" modelAttribute="car" id="get-quote">
						<div>
							<form:input type="text" path="idInformationCar" placeholder="Your Name" />
						</div>
						<div>
							<form:input type="text" path="" placeholder="Email" />
						</div>
						<div>
							<form:input style="padding-left: 10px" type="password" path=""
								placeholder="Password" />
						</div>
						<div>
							<form:input type="text" path="" placeholder="Phone" />
						</div>
						<div>
							<form:input
								style="width: 100%; border: none; padding: 10px; border-bottom: 1px solid #e9e9e9; color: #989898"
								type="date" path="" placeholder="Birth Day" />
						</div>
						<div>
							<form:input type="text" path="" placeholder="City" />
						</div>
						<div>
							<form:input type="text" path="" placeholder="District" />
						</div>
						<div>
							<form:input type="text" path="" placeholder="Wards" />
						</div>
						<div>
							<form:input type="text" path="" placeholder="Street" />
						</div>
						<div>
							<form:input type="text" path=""
								placeholder="Apartment Number" />
						</div>
						<div>
							<form:input type="text" path="" placeholder="Zip Code" />
						</div>
						<div>
							<input name="" type="file" />
						</div>
						<div class="text-center">
							<input type="submit" class="btn-default" value="Submit" />
						</div>
					</form:form>
				</div>
			</section>
		</div>
	</div>

</div>
<div class="clear"></div>
<jsp:include page="footer.jsp"></jsp:include>