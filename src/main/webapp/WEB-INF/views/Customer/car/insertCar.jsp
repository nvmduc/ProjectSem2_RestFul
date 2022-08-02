<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="clear"></div>
<div id="page-content">
	<div class="container">
		<div class="row">
			<section class="col-sm-5 col-md-6 col-lg-6"
				style="padding-top: 150px">
				<div class="get-quote-form">
					<h2>Information Car</h2>
					<form:form action="insertCar" method="POST" modelAttribute="car"
						id="get-quote">
						<div>
							<form:input type="text" path="carCompany"
								placeholder="Car Company" />
						</div>
						<div>
							<form:input type="text" path="carLine" placeholder="Car Line" />
						</div>
						<div>
							<form:input type="text" path="carType" placeholder="Car Type" />
						</div>
						<div>
							<form:input
								style="width: 100%; border: none; padding: 10px; border-bottom: 1px solid #e9e9e9; color: #989898"
								type="number" path="yearOfManufacture" placeholder="Year" />
						</div>
						<div>
							<form:input type="text" path="frameNumber"
								placeholder="Frame Number" />
						</div>
						<div>
							<form:input type="text" path="engineNumber"
								placeholder="Engine Number" />
						</div>
						<div>
							<form:input type="text" path="seaOfControl"
								placeholder="Sea Of Control" />
						</div>
						<div>
							<form:input type="text" path="seats" placeholder="Seats" />
						</div>
						<form:input path="idAccount" type="hidden" readonly="readonly"
							value="${user.idAccount }" />
						<div class="text-center">
							<input type="submit" class="btn-default" value="Submit Buy" />
						</div>
					</form:form>
				</div>
			</section>
		</div>
	</div>

</div>
<div class="clear"></div>
<jsp:include page="../layout/footer.jsp"></jsp:include>