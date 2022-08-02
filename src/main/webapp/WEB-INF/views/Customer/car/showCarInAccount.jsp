<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="clear"></div>
<div id="page-content">
	<div class="container">
		<div class="row">
			<div class="center1" style="padding: 50px 0px 20px 0px">
				<h2 style="padding-bottom: 20px">
					<strong>Thông tin tài khoản của bạn</strong>
				</h2>
			</div>
			<div class="column">
				<div class="card">
					<img width="263" height="263" ; class="img-product"
						src="<css:url value="Resources"/>/images_Account/${user.avatar }"
						class="card-img-top" alt="...">
					<div class="center1" style="width: 80% !important;">
						<h4 class="card-title">${user.name }</h4>
						<p>✸ ${user.email }</p>
						<p>✸ ${user.phone }</p>
						<p>✸ ${user.birthDay }</p>
						<p>✸ ${user.apartmentNumber }, ${user.street }, ${user.wards },
							${user.district }, ${user.city }</p>
					</div>
					<div style="padding-left: 60px; padding-bottom: 10px">
						<a class="btn-default" href="login">Update</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="center1" style="padding: 50px 0px 20px 0px">
				<h2 style="padding-bottom: 20px">
					<strong>Danh sách thông tin xe của bạn</strong>
				</h2>
			</div>
			<css:if test="${empty listCars }">
				<h4>Bạn không có thông tin xe</h4>
			</css:if>
<%-- 			<css:if test="${empty listCar }"> --%>
				<css:forEach items="${listCars }" var="c">
				<css:if test="${c.statusInformationCar != 1 }">
				<table>
					<thead>
						<tr>
							<th>Tên xe</th>
							<th>Năm sản xuất</th>
							<th>Số khung xe</th>
							<th>Số máy xe</th>
							<th>Biển kiểm soát</th>
							<th>Số ghế ngồi</th>
							<th>Xoá</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<div class="center1">
									<h4 class="card-title" style="width: 200px">${c.carCompany } ${c.carLine } ${c.carType }</h4>
								</div>
							</td>
							<td style="width: 200px">${c.yearOfManufacture }</td>
							<td style="width: 200px">${c.frameNumber }</td>
							<td style="width: 200px">${c.engineNumber }</td>
							<td style="width: 200px">${c.seaOfControl }</td>
							<td style="width: 200px">${c.seats }</td>
							<td><a href="deleteCar?idInformationCar=${c.idInformationCar }" style="color:red" ><i class="fa fa-trash" aria-hidden="true"></i></a></td>
						</tr>
					</tbody>
				</table>
					<div style="padding-left: 60px"></div>
				</css:if>
			</css:forEach>
<%-- 			</css:if> --%>
		</div>
	</div>
</div>
<div class="clear"></div>
<jsp:include page="../layout/footer.jsp"></jsp:include>