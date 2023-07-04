<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chi tiết Tài khoản</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<c:set value="${ requestScope.kh }" var="kh"></c:set>
	<c:set value="${ requestScope.tktk }" var="tktk"></c:set>
	<%@ include file="../component/navbar.jsp"%>

	<a class="btn btn-outline-secondary ms-2 mt-2" href="ListTKTKServlet?page=1">Quay
		lại Danh sách Tài khoản tiết kiệm</a>

	<h1 class="mt-3 text-center">Chi tiết Tài khoản</h1>
	<div class="d-flex mt-5 justify-content-center">
		<div class="d-flex flex-column" style="min-width: 18rem;">
			<h3 class="border-bottom border-dark fs-1 ms-3 pb-1 mb-4">Khách
				Hàng</h3>
			<ul class="list-group list-group-flush">
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Họ tên: </span> ${ kh.fullName }</li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Giới tính: </span> ${ kh.gioitinh }</li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Ngày sinh: </span> ${ kh.ngaysinh }</li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Số điện thoại: </span> ${ kh.phone }</li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Mã CCCD: </span> ${ kh.cccd }</li>
				<li class="d-flex justify-content-between list-group-item"></li>
			</ul>
			<a class="btn btn-outline-success ms-2 mt-2 fw-bold" href="#">Chi tiết khách hàng</a>
		</div>
		<div class="d-flex flex-column ms-5">
			<h3 class="border-bottom border-dark fs-1 ms-3 pb-1 mb-4">Tài
				Khoản Tiết Kiệm</h3>
			<ul class="list-group list-group-flush">
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">ID: </span> ${ tktk.id }</li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Số sổ: </span> ${ tktk.soStk }</li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Ngày mở: </span> ${ tktk.ngaygui }</li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Ngày tới hạn <small>(Dự Kiến):</small></span> ${ tktk.ngaydenhan }</li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Số tiền gửi: </span> ${ tktk.sotiengui }</li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Lãi suất: </span> <span>${ tktk.laisuatgui }<small>
							%/năm</small></span></li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Kỳ hạn: </span> <span>${ tktk.kyhangui }<small>
							tháng</small></span></li>
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Active: </span> <c:choose>
						<c:when test="${c.isActive == 1 }">
							<i class="material-icons fw-bold"
								style="font-size: 1rem; color: green">check</i>
						</c:when>
						<c:otherwise>
							<i class="material-icons" style="font-size: 1rem; color: red">cancel</i>
							</c:otherwise>
					</c:choose></li>

				<li class="d-flex justify-content-between list-group-item"></li>
			</ul>
		</div>
	</div>


</body>
</html>