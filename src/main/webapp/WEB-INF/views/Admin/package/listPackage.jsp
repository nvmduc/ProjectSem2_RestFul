<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp" flush="true" />
<div class="has-sidebar-left has-sidebar-tabs">
	<!--navbar-->
	<div class="sticky">
		<div
			class="navbar navbar-expand d-flex justify-content-between bd-navbar white shadow">
			<div class="relative">
				<div class="d-flex">
					<div class="d-none d-md-block">
						<h1 class="nav-title">Package Insurance</h1>
					</div>
				</div>
			</div>
			<!--Top Menu Start -->
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<!-- Messages-->

					<!-- Notifications -->

					<li><a class="nav-link " data-toggle="collapse"
						data-target="#navbarToggleExternalContent"
						aria-controls="navbarToggleExternalContent" aria-expanded="false"
						aria-label="Toggle navigation"> <i class="icon-search3"></i>
					</a></li>
					<!-- Right Sidebar Toggle Button -->

					<!-- User Account-->
					<li class="dropdown custom-dropdown user user-menu "><a
						href="#" class="nav-link" data-toggle="dropdown"> <img
							src="${pageContext.request.contextPath}/<css:url value="Resources"/>/assets/img/dummy/u8.png"
							alt=""> <i class="icon-more_vert "></i>
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
			<div class="row">
				<div class="col-md-12">
					<div class="card no-b">
						<div class="card-body p-0">
							<div class="table-responsive">
								<table class="table table-hover">
									<thead style="border-bottom: 1px solid #DFDFDF">
										<tr>
											<td>ID</td>
											<td>Package Name</td>
											<td>Image Package</td>
											<td>Status</td>
											<td>Created At</td>
											<td>Action</td>
										</tr>
									</thead>
									<tbody>
										<css:forEach items="${listPackages }" var="p">
											<tr class="no-b">
												<td>${p.idPackage }</td>
												<td>
													<h6>${p.namePackage }</h6>
												</td>
												<td>
												<img alt="" src="${pageContext.request.contextPath}/<css:url
														value="Resources" />/image_Package/${p.imagePackage }">
												</td>
												<td>
													<div class="d-none d-lg-block">
														<span class="badge badge-success">${p.statusPackage == 1 ? "Hide":"Show" }</span>
													</div>
												</td>
												<td><span class="badge badge-success">${p.created_at_Package}</span></td>
												<%-- 												<td><a href="initUpdateDegree?dgId=${dg.dgId }" --%>
												<!-- 													class="btn-fab btn-fab-sm btn-primary shadow text-white"><i -->
												<!-- 														class="icon-pencil"></i></a> <a -->
												<%-- 													href="deleteDegree?dgId=${dg.dgId }" --%>
												<!-- 													class="btn-fab btn-fab-sm btn-danger shadow text-white" -->
												<!-- 													onclick="alertdelete()"><i class="icon-trash"></i></a></td> -->
												<td><div class="d-none d-lg-block"></div></td>
											</tr>
										</css:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<nav class="pt-3" aria-label="Page navigation">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#">Previous</a>
					</li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<!--Add New Message Fab Button-->
	<a href="insertPackage"
		class="btn-fab btn-fab-md fab-right fab-right-bottom-fixed shadow btn-primary"><i
		class="icon-add"></i></a>
</div>
<!-- Right Sidebar -->
<jsp:include page="../footer.jsp" />