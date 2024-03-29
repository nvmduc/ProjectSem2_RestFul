<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<div class="has-sidebar-left has-sidebar-tabs">

	<!--navbar-->
	<div class="sticky">
		<div
			class="navbar navbar-expand d-flex justify-content-between bd-navbar white shadow">
			<div class="relative">
				<div class="d-flex">
					<div class="d-none d-md-block">
						<h1 class="nav-title">Dashboard</h1>
					</div>
				</div>
			</div>
			<!--Top Menu Start -->
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<!-- Messages-->

					<!-- Notifications -->
<%-- 					<li><a>${user.email }</a></li> --%>
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
							<div class="row box justify-content-between">
								<img style="width: 30%" alt=""
									src="${pageContext.request.contextPath}/<css:url value="Resources"/>/images_Account/${user.avatar }">
								<span>${user.email }</span> 
								
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
									<a href="profileAccount?idAccount=${user.idAccount }"> <i
										class="icon-beach_access pink lighten-1 avatar  r-5"></i>
										<div class="pt-1">Profile</div>
									</a>
								</div>
								<div class="col">
									<a href="logoutAdmin"> 
									<i class="fa fa-sign-out indigo lighten-2 avatar r-5" aria-hidden="true"></i>
										<div class="pt-1">Logout</div>
									</a>
								</div>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
	<!--#navbar-->
	<div class="container-fluid relative animatedParent animateOnce my-3">
		<div class="row row-eq-height my-3 mt-3">
			<div class="col-md-6">
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<div class="card no-b mb-3 bg-danger text-white">
							<div class="card-body">
								<div class="d-flex justify-content-between align-items-center">
									<div>
										<i class="icon-package s-18"></i>
									</div>
									<div>
										<span class="text-success">40+35</span>
									</div>
								</div>
								<div class="text-center">
									<div class="s-48 my-3 font-weight-lighter">
										<i class="icon-chrome"></i>
									</div>
									Chrome
								</div>

							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6">
						<div class="card no-b mb-3">
							<div class="card-body">
								<div class="d-flex justify-content-between align-items-center">
									<div>
										<i class="icon-timer s-18"></i>
									</div>
									<div>
										<span class="badge badge-pill badge-primary">4:30</span>
									</div>
								</div>
								<div class="text-center">
									<div class="s-48 my-3 font-weight-lighter">68</div>
									New Orders
								</div>

							</div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<div class="card no-b mb-3">
							<div class="card-body">
								<div class="d-flex justify-content-between align-items-center">
									<div>
										<i class="icon-user-circle-o s-18"></i>
									</div>
									<div>
										<span class="badge badge-pill badge-danger">4:30</span>
									</div>
								</div>
								<div class="text-center">
									<div class="s-48 my-3 font-weight-lighter">170</div>
									New Users
								</div>

							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6">
						<div class="card no-b mb-3">
							<div class="card-body">
								<div class="d-flex justify-content-between align-items-center">
									<div>
										<i class="icon-user-times s-18"></i>
									</div>
									<div>
										<span class="text-danger">50</span>
									</div>
								</div>
								<div class="text-center">
									<div class="s-48 my-3 font-weight-lighter">95</div>
									Returning Users
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card no-b p-2">
					<div class="card-body">
						<div class="card-body">
							<div class="height-300">
								<canvas data-chart="chartJs" data-chart-type="doughnut"
									data-dataset="[
                                                        [75, 25,25],

                                                    ]"
									data-labels="[['Disk'],['Database'],['Disk2'],['Database2']]"
									data-dataset-options="[
                                                    {
                                                        label: 'Disk',
                                                        backgroundColor: [
                                                            '#03a9f4',
                                                            '#8f5caf',
                                                            '#3f51b5'
                                                        ],

                                                    },


                                                    ]"
									data-options="{legend: {display: !0,position: 'bottom',labels: {fontColor: '#7F8FA4',usePointStyle: !0}},
                                }">
                                </canvas>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card no-b my-3">
			<div class="card-body">
				<div class="my-2 height-300">
					<canvas data-chart="bar"
						data-dataset="[
                                        [21, 90, 55, 0, 59, 77, 12,21, 90, 55, 0, 59, 77, 12,21, 90, 55, 0, 59, 77, 12],
                                        [12, 40, 16, 17, 89, 0, 12,12, 0, 55, 60, 79, 99, 12,12, 0, 55, 60, 79, 99, 12],
                                        [12, 40, 16, 17, 89, 0,12, 40, 16, 17, 89, 0, 12,12, 40, 16, 17, 89, 0, 12],
                                        ]"
						data-labels="['Blue','Yellow','Green','Purple','Orange','Red','Indigo','Blue','Yellow','Green','Purple','Orange','Red','Indigo','Blue','Yellow','Green','Purple','Orange','Red','Indigo']"
						data-dataset-options="[
                                    {
                                        label: 'HTML',
                                        backgroundColor: '#7986cb',
                                        borderWidth: 0,

                                    },
                                    {
                                         label: 'Wordpress',
                                         backgroundColor: '#88e2ff',
                                         borderWidth: 0,

                                     },
                                    {
                                          label: 'Laravel',
                                          backgroundColor: '#e2e8f0',
                                          borderWidth: 0,

                                      }
                                    ]"
						data-options="{
                                      legend: { display: true,},
                                      scales: {
                                        xAxes: [{
                                            stacked: true,
                                             barThickness:5,
                                             gridLines: {
                                                zeroLineColor: 'rgba(255,255,255,0.1)',
                                                 color: 'rgba(255,255,255,0.1)',
                                                 display: false,},
                                             }],
                                        yAxes: [{
                                                stacked: true,
                                                     gridLines: {
                                                        zeroLineColor: 'rgba(255,255,255,0.1)',
                                                        color: 'rgba(255,255,255,0.1)',
                                                    }
                                       }]

                                      }
                                }">
                    </canvas>
				</div>
			</div>
			<div class="card-body">
				<div class="row my-3 no-gutters">
					<div class="col-md-3">
						<h1>Tasks</h1>
						Currently assigned tasks to team.
					</div>
					<div class="col-md-9">
						<div class="row">
							<div class="col-md-3">
								<div class="d-flex justify-content-between align-items-center">
									<div class="mb-3">
										<h6>New Layout</h6>
										<small>75% Completed</small>
									</div>
									<figure class="avatar">
										<img src="assets/img/dummy/u12.png" alt="">
									</figure>
								</div>
								<div class="progress progress-xs mb-3">
									<div class="progress-bar" role="progressbar"
										style="width: 75%;" aria-valuenow="75" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="d-flex justify-content-between align-items-center">
									<div class="mb-3">
										<h6>New Layout</h6>
										<small>75% Completed</small>
									</div>
									<figure class="avatar">
										<img src="assets/img/dummy/u2.png" alt="">
									</figure>
								</div>
								<div class="progress progress-xs mb-3">
									<div class="progress-bar bg-indigo" role="progressbar"
										style="width: 75%;" aria-valuenow="75" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="d-flex justify-content-between align-items-center">
									<div class="mb-3">
										<h6>New Layout</h6>
										<small>75% Completed</small>
									</div>
									<div class="avatar-group">
										<figure class="avatar">
											<img src="assets/img/dummy/u4.png" alt="">
										</figure>
										<figure class="avatar">
											<img src="assets/img/dummy/u11.png" alt="">
										</figure>
										<figure class="avatar">
											<img src="assets/img/dummy/u1.png" alt="">
										</figure>
									</div>
								</div>
								<div class="progress progress-xs mb-3">
									<div class="progress-bar yellow" role="progressbar"
										style="width: 75%;" aria-valuenow="75" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="d-flex justify-content-between align-items-center">
									<div class="mb-3">
										<h6>New Layout</h6>
										<small>75% Completed</small>
									</div>
									<figure class="avatar">
										<img src="assets/img/dummy/u5.png" alt="">
									</figure>
								</div>
								<div class="progress progress-xs mb-3">
									<div class="progress-bar bg-success" role="progressbar"
										style="width: 75%;" aria-valuenow="75" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class=" row my-3">
			<div class="col-md-6">
				<div class=" card b-0">
					<div class="card-body p-5">
						<canvas id="gradientChart" width="600" height="340"></canvas>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class=" card no-b">
					<div class="card-body">
						<table class="table table-hover earning-box">
							<tbody>
								<tr class="no-b">
									<td class="w-10"><a href="panel-page-profile.html"
										class="avatar avatar-lg"> <img
											src="assets/img/dummy/u6.png" alt="">
									</a></td>
									<td>
										<h6>Sara Kamzoon</h6> <small class="text-muted">Marketing
											Manager</small>
									</td>
									<td>25</td>
									<td>$250</td>
								</tr>
								<tr>
									<td class="w-10"><a href="panel-page-profile.html"
										class="avatar avatar-lg"> <img
											src="assets/img/dummy/u9.png" alt="">
									</a></td>
									<td>
										<h6>Sara Kamzoon</h6> <small class="text-muted">Marketing
											Manager</small>
									</td>
									<td>25</td>
									<td>$250</td>
								</tr>
								<tr>
									<td class="w-10"><a href="panel-page-profile.html"
										class="avatar avatar-lg"> <img
											src="assets/img/dummy/u11.png" alt="">
									</a></td>
									<td>
										<h6>Sara Kamzoon</h6> <small class="text-muted">Marketing
											Manager</small>
									</td>
									<td>25</td>
									<td>$250</td>
								</tr>
								<tr>
									<td class="w-10"><a href="panel-page-profile.html"
										class="avatar avatar-lg"> <img
											src="assets/img/dummy/u12.png" alt="">
									</a></td>
									<td>
										<h6>Sara Kamzoon</h6> <small class="text-muted">Marketing
											Manager</small>
									</td>
									<td>25</td>
									<td>$250</td>
								</tr>
								<tr>
									<td class="w-10"><a href="panel-page-profile.html"
										class="avatar avatar-lg"> <img
											src="assets/img/dummy/u5.png" alt="">
									</a></td>
									<td>
										<h6>Sara Kamzoon</h6> <small class="text-muted">Marketing
											Manager</small>
									</td>
									<td>25</td>
									<td>$250</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<!-- Right Sidebar -->
<jsp:include page="footer.jsp" />