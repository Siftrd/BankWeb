<%--<jsp:useBean id="detail" scope="request" type="com.example.model.Khachhang"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: Luong Nguyen
  Date: 3/4/2023
  Time: 11:23 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
    <div class="text-center">
        <h1>Chi tiết khách hàng</h1>
    </div>
    <div class="container">
        <form class="row g-3" action="detail" method="get">
            <div class="col-md-6">
                <label for="name" class="form-label">Họ và tên</label>
                <input type="text" class="form-control" id="name" value="${detail.fullname}" disabled>
            </div>
<%--            <div class="col-md-6">--%>
<%--                <label for="inputSostk" class="form-label">Số</label>--%>
<%--                <input type="text" class="form-control" id="inputSostk" disabled>--%>
<%--            </div>--%>
            <div class="col-12">
                <label for="inputAddress" class="form-label">Address</label>
                <input type="text" class="form-control" id="inputAddress" value="${detail.address}" disabled>
            </div>
            <div class="col-md-6">
                <label for="inputPhone" class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" id="inputPhone" value="${detail.phone}" disabled>
            </div>
        </form>
        <button onclick="goBack()">Back</button>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
            crossorigin="anonymous"></script>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
