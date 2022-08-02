<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp"/>
<div class="has-sidebar-left has-sidebar-tabs">
	<!--navbar-->
	<div class="sticky">
		<div
			class="navbar navbar-expand d-flex justify-content-between bd-navbar white shadow">
			<div class="relative">
				<div class="d-flex">
					<div class="d-none d-md-block">
						<h1 class="nav-title">Add DetailPackage</h1>
					</div>
				</div>
			</div>
			<!--Top Menu Start -->
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<li><a class="nav-link " data-toggle="collapse"
						data-target="#navbarToggleExternalContent"
						aria-controls="navbarToggleExternalContent" aria-expanded="false"
						aria-label="Toggle navigation"> <i class="icon-search3"></i>
					</a></li>
					<!-- User Account-->
					<li class="dropdown custom-dropdown user user-menu "><a
						href="#" class="nav-link" data-toggle="dropdown"> <img
							src="<css:url value="Resources"/>/assets/img/dummy/u3.png"
							class="user-image" alt="User Image"> <i
							class="icon-more_vert "></i>
					</a>
						<div class="dropdown-menu p-4 dropdown-menu-right">
							<div class="row box justify-content-between my-4">
								<div class="col">
									<a href="#"> <i
										class="icon-apps purple lighten-2 avatar  r-5"></i>
										<div class="pt-1">Apps</div>
									</a>
								</div>
								<div class="col">
									<a href="#"> <i
										class="icon-beach_access pink lighten-1 avatar  r-5"></i>
										<div class="pt-1">Profile</div>
									</a>
								</div>
								<div class="col">
									<a href="#"> <i
										class="icon-perm_data_setting indigo lighten-2 avatar  r-5"></i>
										<div class="pt-1">Settings</div>
									</a>
								</div>
							</div>
							<div class="row box justify-content-between my-4">
								<div class="col">
									<a href="#"> <i
										class="icon-star light-green lighten-1 avatar  r-5"></i>
										<div class="pt-1">Favourites</div>
									</a>
								</div>
								<div class="col">
									<a href="#"> <i
										class="icon-save2 orange accent-1 avatar  r-5"></i>
										<div class="pt-1">Saved</div>
									</a>
								</div>
								<div class="col">
									<a href="#"> <i
										class="icon-perm_data_setting grey darken-3 avatar  r-5"></i>
										<div class="pt-1">Settings</div>
									</a>
								</div>
							</div>
							<hr>
							<div class="row box justify-content-between my-4">
								<div class="col">
									<a href="#"> <i
										class="icon-apps purple lighten-2 avatar  r-5"></i>
										<div class="pt-1">Apps</div>
									</a>
								</div>
								<div class="col">
									<a href="#"> <i
										class="icon-beach_access pink lighten-1 avatar  r-5"></i>
										<div class="pt-1">Profile</div>
									</a>
								</div>
								<div class="col">
									<a href="#"> <i
										class="icon-perm_data_setting indigo lighten-2 avatar  r-5"></i>
										<div class="pt-1">Settings</div>
									</a>
								</div>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
	<!--#navbar-->
	<div class="container-fluid animatedParent animateOnce my-3">
		<div class="animated fadeInUpShort">
			<form:form action="insertDetailPackage" modelAttribute="detailPackage"
				method="post" enctype="multipart/form-data" id="get-quote">
				<div class="row">
					<div class="col-md-9">
						<div class="row">
							<form:input path="idPackage" type="hidden" readonly="readonly" value="${pack.idPackage }"/>
							<div class="col-md-6 mb-3">
								<label for="validationCustom01">Description</label>
								<form:textarea path="descriptionPackage" type="text" class="form-control"
									id="validationCustom01" placeholder="Description Package" />
							</div>
							<div class="col-md-6 mb-3">
								<label for="validationCustom01">Insurance Fees</label>
								<form:input path="insuranceFees" type="number" class="form-control"
									id="validationCustom01" placeholder="Insurance Fees" />
							</div>
							<div class="col-md-6 mb-3">
								<label for="validationCustom01">Compensation</label>
								<form:input path="compensation" type="number" class="form-control"
									id="validationCustom01" placeholder="Compensation" />
							</div>
							<div class="col-md-12 mb-1" style="display: block">
								<label for="validationCustom02">Package Status</label>
								<div class="custom-control custom-radio custom-control-inline"
									style="display: flex;">
									<form:radiobutton path="status"
										class="custom-control-input" id="show" value="1"
										checked="checked" />
									<label class="custom-control-label" for="show">Show</label>
								</div>
								<div class="custom-control custom-radio custom-control-inline"
									style="display: flex;">
									<form:radiobutton path="status"
										class="custom-control-input" id="hide" value="0" />
									<label class="custom-control-label" for="hide">Hide</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div class="card-body">
					<button type="submit" class="btn btn-primary btn-lg">
						<i class="icon-save mr-2"></i>Save Data
					</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"/>
