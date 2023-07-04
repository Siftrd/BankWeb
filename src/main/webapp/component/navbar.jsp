<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-light fw-bold">
		<div class="container-fluid">
			<a class="navbar-brand text-decoratioin-none"
				href="ListTKTKServlet?page=1"> <img
				src="https://cdn.haitrieu.com/wp-content/uploads/2022/02/Icon-Vietcombank.png"
				alt="Logo image" 
				class="ms-4"
				style="height: 45px; width: auto"
				title="Logo image" /> 
				<br /> <small class="fs-6">Vietcombank</small></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-end"
				id="collapsibleNavbar">
				<ul class="navbar-nav text-white">
					<li class="nav-item"><a class="nav-link me-2"
						href="ListTKTKServlet?page=1">Danh sách <span class="fw-bold">Tài
								khoản tiết kiệm</span></a></li>

					<li class="nav-item"><a class="nav-link me-2"
						href="DSKhachHang">Danh sách <span class="fw-bold">Khách
								hàng</span></a></li>


				</ul>
			</div>
		</div>
	</nav>
</body>
</html>