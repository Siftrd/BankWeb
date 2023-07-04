<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Danh sách khách hàng</title>
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
	<%@ include file="../component/navbar.jsp"%>
	

	<div class="text-center">
		<h2 class="mt-3">Danh sách khách hàng</h2>
	</div>
	<div class="mx-5 mt-3 text-center">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Họ tên</th>
					<th scope="col">Giới tính</th>
					<th scope="col">Ngày Sinh</th>
					<th scope="col">Mã CCCD</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${requestScope.listKH }">
					<c:set var="id" value="${c.id}" />
					<tr>
						<td>${id}</td>
						<td>${c.fullname}</td>
						<td>${c.gioitinh}</td>
						<td>${c.ngaysinh}</td>
						<td>${c.cccd}</td>
						<td><a href="ChiTietKhachHangServlet?id=${id}"><i class="material-icons" style="font-size:1rem">view_stream</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>