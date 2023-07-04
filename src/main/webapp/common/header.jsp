<%-- 
    Document   : header
    Created on : Apr 1, 2023, 10:31:40 AM
    Author     : rioxv
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Ngân hàng</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="ListTKTKServlet"> Theo dõi </a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc.isAdmin == 1}">
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="thong-ke"> Thống kê </a>--%>
<%--                    </li>--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        Thống kê--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu">--%>
<%--                        <li><a class="dropdown-item" href="thong-ke">Sổ tiết kiệm</a></li>--%>
<%--                        <li><a class="dropdown-item" href="tk-sovaylai">Sổ vay lãi</a></li>--%>
<%--                    </ul>--%>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Thống kê
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="thong-ke">Sổ tiết kiệm</a></li>
                            <li><a class="dropdown-item" href="tk-sovaylai">Sổ vay lãi</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="cauhinh"> Cấu hình </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Xin chào, ${sessionScope.acc.userName}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="views/login.jsp">Login</a>
                    </li>
                </c:if>
            </ul>


        </div>
</nav>