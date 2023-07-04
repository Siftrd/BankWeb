<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Danh sách Tài khoản tiết kiệm</title>


    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


    <link rel="stylesheet"
          href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>


    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<%@ include file="../component/navbar.jsp" %>
<div class="d-flex">
    <div class="navbar navbar-light d-flex flex-column flex-fill">
        <form class="form-inline d-flex flex-column" action="SearchTTTK"
              method="post" style="font-size: 0.85rem;">
            <div class="d-flex flex-row">
                <span class="fw-bold">Ngày Tới Hạn &nbsp;</span> Sau Ngày: <input
                    type="text" class="form-control h-75 p-2 w-50 ms-auto"
                    id="datepicker" name="fromDate" readonly>
            </div>
            <div class="d-flex flex-row">
                <span class="fw-bold">Ngày Tới Hạn &nbsp;</span> Trước ngày: <input
                    type="text" class="form-control h-75 p-2 w-50 ms-auto"
                    id="datepicker1" name="toDate" readonly>
            </div>
            <div class="d-flex flex-row">
                <span class="fw-bold">Số Tiền Đang Gửi </span> Có Giá Trị Bắt
                Đầu Từ: <input type="text" name="minMoney"
                               class="form-control h-75 p-2 w-50 ms-auto">
            </div>

            <div class="d-flex flex-row">
                <span class="fw-bold">Trạng Thái Sổ</span>: <span class="ms-auto"><input
                    type="radio" name="status" value="true">   <label
                    for="html"><i class="material-icons fw-bold"
                                  style="font-size: 1rem; color: green">check</i></label>   <input
                    type="radio" name="status" value="false">   <label
                    for="css"><i class="material-icons"
                                 style="font-size: 1rem; color: red">cancel</i></label></span>
            </div>
            <button class="btn btn-outline-secondary my-2 my-sm-0 ms-2 ms-auto"
                    type="submit">Lọc
            </button>
        </form>
    </div>
</div>

<div class="text-center">
    <h2 class="mt-3">Danh Sách Tài Khoản Tiết Kiệm</h2>
    <a class="" href="ListTKTKServlet?page=1"><small>Xem toàn
        bộ danh sách</small></a>
</div>
<div class="mx-5 mt-3 text-center">
    <table class="table table-striped border">
        <thead>
        <tr class="table-secondary">
            <th scope="col">ID</th>
            <th scope="col">Số Sổ</th>
            <th scope="col">Ngày Tới Hạn <small>(Dự Kiến)</small></th>
            <th scope="col">Kỳ Hạn</th>
            <th scope="col">Lãi Suất</th>
            <th scope="col">Số Tiền Đang Gửi</th>
            <th scope="col">Active</th>
            <th scope="col">Khách Hàng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${requestScope.listTKTK }">
            <c:set var="id" value="${c.id}"/>
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
                <td class="text-start"><a href="ChiTietTKTK?id=${id}"
                                          target="_blank">${c.kh.fullname}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div
        class="d-flex position-absolute bottom-0 mb-2 start-50 translate-middle-x">


    <a class="btn btn-outline-secondary mx-2 p-2"
       href="ListTKTKServlet?page=1">1</a> <a
        class="btn btn-outline-secondary mx-2 p-2"
        href="ListTKTKServlet?page=2">2</a> <a
        class="btn btn-outline-secondary mx-2 p-2"
        href="ListTKTKServlet?page=3">3</a>
</div>

<script>
    $(function () {
        $("#datepicker").datepicker({
            dateFormat: "yy-mm-dd"
        });
    });

    $(function () {
        $("#datepicker1").datepicker({
            dateFormat: "yy-mm-dd"
        });
    });
</script>
</body>
</html>