<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="css" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.98.0">
<title>Signin Template · Bootstrap v5.2</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/sign-in/">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Favicons -->
<link rel="apple-touch-icon"
	href="/docs/5.2/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.2/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="/docs/5.2/assets/img/favicons/safari-pinned-tab.svg"
	color="#712cf9">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">


<style>

</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/<css:url value="Resources"/>/admin/assets/css/login.css">


<!-- Custom styles for this template -->
</head>
<body class="text-center">
	<main class="form-signin w-100 m-auto">
		<form:form action="postloginAdmin" modelAttribute="accLogin" method="post"
			id="get-quote">
			<img class="mb-4"
				src="https://getbootstrap.com/docs/5.2/assets/brand/bootstrap-logo.svg"
				alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">Login Admin</h1>
			<h6 style="color: red">${messenge }</h6>
			<div class="form-floating">
				<input type="email" class="form-control" name="email" id="floatingInput"
					placeholder="Email"/> <label for="floatingInput">Email
					address</label>
			</div>
			<div class="form-floating">
				<input type="password" name="password" class="form-control" id="floatingPassword"
					placeholder="Password" /> <label for="floatingPassword">Password</label>
			</div>

			<div class="checkbox mb-3"></div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
		</form:form>
	</main>



</body>
</html>
