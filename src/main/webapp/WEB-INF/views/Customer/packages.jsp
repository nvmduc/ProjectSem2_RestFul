<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="layout/header.jsp"></jsp:include>
<div class="clear"></div>
<div id="page-content">
	<div class="container">
		<div class="row">
			<div class="center1" style="padding: 50px 0px 20px 0px">
				<h2 style="padding-bottom: 20px">
					<strong>Are you looking for car insurance?</strong>
				</h2>
				<div>
					<p class="center1">Please select a product below to learn more.</p>
				</div>
			</div>
			<css:forEach items="${listPackages }" var="p">
				<css:if test="${p.statusPackage == 1 }">
					<div class="column">
						<div class="card">
							<img width="263" height="180" ; class="img-product"
								src="<css:url value="Resources"/>/image_Package/${p.imagePackage }"
								class="card-img-top" alt="...">
							<div class="center1"
								style="width: 80% !important; height: 100px;">
								<h4 class="card-title">${p.namePackage }</h4>
							</div>
							<div>
							</div>
							<div style="padding-left: 60px">
								<css:if test="${empty user }">
									<a class="btn-default" href="login">SIGN IN</a>
								</css:if>
								<css:if test="${!empty user }">
									<a class="btn-default" href="initInsertCar">BUY NOW</a>
								</css:if>

							</div>
						</div>
					</div>
				</css:if>
			</css:forEach>
		</div>
	</div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="layout/footer.jsp"></jsp:include>