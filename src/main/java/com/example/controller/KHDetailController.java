package com.example.controller;

import com.example.dao.TKSoTietKiemDAO;
import com.example.model.Khachhang;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/detail"})
public class KHDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        TKSoTietKiemDAO TKSoTietKiemDAO = new TKSoTietKiemDAO();
        String khId = request.getParameter("kid");
        Khachhang khachhang = TKSoTietKiemDAO.getKhachhangByid(khId);
        request.setAttribute("detail", khachhang);
        RequestDispatcher rd = request.getRequestDispatcher("views/KhachhangDetail.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
