<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Chi tiết Khách Hàng</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>


<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<c:set value="${ requestScope.kh }" var="kh"></c:set>
	<c:set value="${ requestScope.tktk }" var="tktk"></c:set>
	<%@ include file="../component/navbar.jsp"%>

	<a class="btn btn-outline-secondary ms-2 mt-2" href="DSKhachHang">Quay
		lại Danh sách Khách Hàng</a>

	<h1 class="mt-3 text-center">Chi Tiết Khách Hàng</h1>
	<div class="d-flex mt-5 justify-content-around">
		<div class="d-flex flex-column" style="min-width: 18rem;">
			<h3 class="border-bottom border-dark fs-3 ms-3 pb-1 mb-4">Khách
				Hàng</h3>
			<ul class="list-group list-group-flush">
				<li class="d-flex justify-content-between list-group-item"><span
					class="fw-bold">Họ tên: </span> ${ kh.fullname }</li>
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
		</div>



		<div class="d-flex flex-column ms-5">
			<c:set var="dsTKTK" value="${requestScope.dsTKTK}"></c:set>
			<c:if test="${dsTKTK != null}">
				<div class="d-flex flex-column">
					<h3 class="border-bottom border-dark fs-3 ms-3 pb-1 mb-4">Danh
						Sách Tiết Kiệm</h3>
					<table class="table table-striped border text-center">
						<thead>
							<tr class="table-secondary">
								<th scope="col">ID</th>
								<th scope="col">Số Sổ</th>
								<th scope="col">Ngày Tới Hạn <small>(Dự Kiến)</small></th>
								<th scope="col">Kỳ Hạn</th>
								<th scope="col">Lãi Suất</th>
								<th scope="col">Số Tiền Đang Gửi</th>
								<th scope="col">Active</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${requestScope.dsTKTK }">
								<c:set var="id" value="${c.id}" />
								<tr>
									<td>${id}</td>
									<td>${c.soStk}</td>
									<td>${c.ngaydenhan}</td>
									<td>${c.kihangui}<small> tháng</small></td>
									<td>${c.laisuatgui}<small> %/năm</small></td>
									<td class="text-end">${c.sotiengui}</td>


									<c:choose>
										<c:when test="${c.isActive == 1 }">
											<td><i class="material-icons fw-bold"
												style="font-size: 1rem; color: green">check</i></td>
										</c:when>
										<c:otherwise>
											<td><i class="material-icons"
												style="font-size: 1rem; color: red">cancel</i></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>


		</div>


	</div>


</body>
</html>