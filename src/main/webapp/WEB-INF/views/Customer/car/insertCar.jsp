<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="clear"></div>

<div id="page-content">
	<section class="flexslider">
		<ul class="slides">
			<li><img style="height: 800px"
				src="<css:url value="Resources"/>/images/bus.jpg" />
				<div class="slide-info">
					<div class="slide-con">
						<b>Bus/Truck Insurance</b>
						<h3>Bus/Truck Insurance</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Mauris hendrerit fringilla ligula, nec congue leo pharetra in.</p>
						<a href="#" class="ti-arrow-right"></a>
					</div>
				</div></li>
			<li><img style="height: 800px"
				src="<css:url value="Resources"/>/images/bien_vang.jpg" />
				<div class="slide-info">
					<div class="slide-con">
						<b>Business Car Insurance</b>
						<h3>Business Car Insurance</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Mauris hendrerit fringilla ligula, nec congue leo pharetra in.</p>
						<a href="#" class="ti-arrow-right"></a>
					</div>
				</div></li>
			<li><img style="height: 800px"
				src="<css:url value="Resources"/>/images/slider-img2.jpg" />
				<div class="slide-info">
					<div class="slide-con">
						<b>Personal Car Insurance</b>
						<h3>Personal Car Insurance</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Mauris hendrerit fringilla ligula, nec congue leo pharetra in.</p>
						<a href="#" class="ti-arrow-right"></a>
					</div>
				</div></li>
		</ul>
	</section>
	<div class="container">
		<div class="row">
			<section class="col-sm-5 col-md-6 col-lg-6"
				style="padding-top: 100px">
				<div class="get-quote-form">
					<h2>Information Car</h2>
					<form:form action="insertCar" method="POST" modelAttribute="car"
						id="get-quote">
						<div>
							<form:input type="text" path="idInformationCar"
								placeholder="Your Name" />
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
							<form:input type="text" path="" placeholder="Apartment Number" />
						</div>
						<div>
							<form:input type="text" path="" placeholder="Zip Code" />
						</div>
						<css:if test="${!empty user}">
							<form:input path="idAccount" type="hidden" readonly="readonly" value="${user.idAccount }" />
						</css:if>
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
<jsp:include page="../footer.jsp"></jsp:include>