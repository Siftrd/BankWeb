package com.example.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.KhachHangDAO;
import com.example.dao.TK_TietKiemDAO;
import com.example.model.Khachhang;
import com.example.model.SotietkiemModel;

/**
 * Servlet implementation class ChiTietTKTK
 */
@WebServlet("/ChiTietTKTK")
public class ChiTietTKTK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietTKTK() {
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
			SotietkiemModel tktk = new TK_TietKiemDAO().getTKTKById(id);
			Khachhang kh = new KhachHangDAO().getKHById(tktk.getKh().getId());

			request.setAttribute("tktk", tktk);
			request.setAttribute("kh", kh);
			request.getRequestDispatcher("views/chiTietTKTK.jsp").forward(request, response);
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
