package com.example.controller;

import com.example.dao.KhachHangDAO;
import com.example.dao.TK_TietKiemDAO;
import com.example.model.Khachhang;
import com.example.model.SotietkiemModel;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ChiTietKhachHangServlet
 */
@WebServlet("/ChiTietKhachHangServlet")
public class ChiTietKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietKhachHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		
		try {
			Khachhang kh = new KhachHangDAO().getKHById(id);
			ArrayList<SotietkiemModel> dsTKTK = new TK_TietKiemDAO().getTKTKByMaKH(id);
			
			request.setAttribute("dsTKTK", dsTKTK);
//			request.setAttribute("dsTKV", dsTKTK);
			request.setAttribute("kh", kh);
			request.getRequestDispatcher("views/chiTietKH.jsp").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
