package com.example.controller;

import com.example.dao.TKSoTietKiemDAO;
import com.example.model.SotietkiemModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/thong-ke"})
public class ThongKeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        TKSoTietKiemDAO dao = new TKSoTietKiemDAO();
        String beginDate = request.getParameter("datebegin");
        request.setAttribute("begin", beginDate);
        String endDate = request.getParameter("dateend");
        request.setAttribute("end", endDate);
        if(beginDate=="" || endDate==""){
            request.setAttribute("mess", "Vui lòng chọn ngày");
        }
        int maxItemPage = 2;
        int currentPage = 1;
        String page = request.getParameter("page");
        if(request.getParameter("page") != null && request.getParameter("page") != ""){
            currentPage = Integer.parseInt(page);
        }
        request.setAttribute("page", currentPage);
        int count = dao.getTotalItem(beginDate, endDate);
        int totalPage = (int) Math.ceil((double) count / maxItemPage);
        List<SotietkiemModel> list = dao.findAll(beginDate, endDate, currentPage,maxItemPage);
        request.setAttribute("list", list);
        request.setAttribute("totalpage",totalPage);
        RequestDispatcher rd = request.getRequestDispatcher("views/deposit.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
