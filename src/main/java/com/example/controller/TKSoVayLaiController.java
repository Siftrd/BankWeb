package com.example.controller;

import com.example.dao.TKSoVayLaiDAO;
import com.example.model.Sovaylai;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/tk-sovaylai")
public class TKSoVayLaiController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        TKSoVayLaiDAO dao = new TKSoVayLaiDAO();
//        String sotienvay = request.getParameter("sotienvay");
////        if(beginDate=="" || endDate==""){
////            request.setAttribute("mess", "Vui lòng chọn ngày");
////        }
//        double tienvay = Double.parseDouble(sotienvay);
//        request.setAttribute("sotienvay", tienvay);
//        int maxItemPage = 2;
//        int currentPage = 1;
//        String page = request.getParameter("page");
//        if(request.getParameter("page") != null && request.getParameter("page") != ""){
//            currentPage = Integer.parseInt(page);
//        }
//        request.setAttribute("page", currentPage);
//        int count = dao.getTotalItem(tienvay);
//        int totalPage = (int) Math.ceil((double) count / maxItemPage);
//        List<Sovaylai> list = dao.findAll(tienvay, currentPage,maxItemPage);
//        request.setAttribute("list", list);
//        request.setAttribute("totalpage",totalPage);
        RequestDispatcher rd = request.getRequestDispatcher("views/vaylai.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
