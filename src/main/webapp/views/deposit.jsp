<%--
  Created by IntelliJ IDEA.
  User: Luong Nguyen
  Date: 1/4/2023
  Time: 5:57 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sổ tiết kiệm</title>
<%--    <jsp:useBean id="a" class="com.example.dao.TKDAOAO" scope="request"></jsp:useBean>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
            crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>
    <div class="container">
        <div class="content">
            <form action="thong-ke" method="get">
                <br>
                <div class="row g-3">
                    <h3 class="text-danger">${mess}</h3>
                    <div class="col">
<%--                        <label for="begindate" class="form-label">Ngày bắt đầu</label>--%>
<%--                        <input type="text" id="begindate" name="datebegin" class="form-control" placeholder="YYYY-MM-DD" aria-label="YYYY-MM-DD">--%>
                        <p>Ngày bắt đầu</p>
                        <input type="text" class="form-control" id="datepicker" name="datebegin" readonly>
                    </div>
                    <div class="col">
<%--                        <label for="enddate" class="form-label">Ngày kết thúc</label>--%>
<%--                        <input type="text" id="enddate" name="dateend" class="form-control" placeholder="YYYY-MM-DD" aria-label="YYYY-MM-DD">--%>
                        <p>Ngày kết thúc</p>
                        <input type="text" class="form-control" id="datepicker1" name="dateend" readonly>
                    </div>
                </div>
                <br>
                <button class="btn btn-outline-secondary">Thống kê</button>
                <br>
                <br>
                <div class="table">
                    <table class="table table-bordered table-striped" id="myTable">
                        <thead class="thead-dark">

                        <tr>
                            <th>STT</th>
                            <th>Tên</th>
                            <th>Số sổ tiết kiệm</th>
                            <th>Ngày gửi</th>
                            <th>Tiền gửi(VNĐ)</th>
                            <th>Kỳ hạn(Tháng)</th>
                            <th>Lãi suất(%/tháng)</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${list}" varStatus="stt">
                            <tr>
                                <td>${stt.index + 1}</td>
                                <td><a href="detail?kid=${item.kh.id}" style="text-decoration:none;color: black">${item.kh.fullname}</a></td>
                                <td>${item.soStk}</td>
                                <td>${item.ngaygui}</td>
                                <td>${item.sotiengui}</td>
                                <td>${item.kihangui}</td>
                                <td>${item.laisuatgui}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <nav aria-label="Something">
                        <ul class="pagination pagination-sm">
                            <c:forEach begin="1" end="${totalpage}" var="i">
                                <c:if test="${page == i}">
                                <li class="page-item active">
                                        <a class="page-link" href="thong-ke?datebegin=${begin}&dateend=${end}&page=${i}">${i}</a>
                                </li>
                                </c:if>
                                <c:if test="${page != i}">
                                    <li class="page-item">
                                        <a class="page-link" href="thong-ke?datebegin=${begin}&dateend=${end}&page=${i}">${i}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </nav>
<%--                    <nav aria-label="...">--%>
<%--                        <ul class="pagination">--%>
<%--                            <li class="page-item active">--%>
<%--                                <c:forEach begin="1" end="${totalpage}" var="i">--%>
<%--                                    <a class="page-link" href="thong-ke?datebegin=${begin}&dateend=${end}&page=${i}">${i}<span class="sr-only">(current)</span></a>--%>
<%--                                </c:forEach>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </nav>--%>
                    <button class="btn btn-outline-secondary" disabled>In báo cáo</button>
                </div>
            </form>
            <button onclick="goBack()">Back</button>
            <div class="footer">
    <%--            <jsp:include page="...jsp"></jsp:include>--%>
            </div>
        </div>
    </div>
    <script>
        $(function() {
            $("#datepicker").datepicker({
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
    <script>
        $(function() {
            $("#datepicker1").datepicker({
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
