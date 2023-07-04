package com.example.controller;

import com.example.dao.TK_TietKiemDAO;
import com.example.model.SotietkiemModel;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SearchTTTK
 */
@WebServlet("/SearchTTTK")
public class SearchTTTK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTTTK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Server let của SearchTTTK").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		String minMoney = request.getParameter("minMoney");
		String status = request.getParameter("status");
		
		TK_TietKiemDAO tttkD = new TK_TietKiemDAO();

		Double dou_minMoney = Double.parseDouble("0");
		if(fromDate == "") fromDate = "2000-01-01";
		if(toDate == "") toDate = "2100-01-01";
		try {
			if(minMoney == null) minMoney = "0";
			dou_minMoney = Double.parseDouble(minMoney);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		ArrayList<SotietkiemModel> list = tttkD.search(fromDate, toDate, dou_minMoney, status);
		
		request.setAttribute("listTKTK", list);
		request.getRequestDispatcher("views/listTKTK.jsp").forward(request, response);
	}

}
