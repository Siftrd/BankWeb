package com.example.controller;

import com.example.dao.TK_TietKiemDAO;
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
 * Servlet implementation class ListTKTKServlet
 */
@WebServlet("/ListTKTKServlet")
public class ListTKTKServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListTKTKServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		TK_TietKiemDAO cd = new TK_TietKiemDAO();
//		ArrayList<SotietkiemModel> list = new ArrayList();
//		try {
//			String spageid=request.getParameter("page");
//			if(spageid==null) spageid="1";
//			int pageid=Integer.parseInt(spageid);
//			int total=5;
//			if(pageid==1){}
//			else{
//			    pageid=pageid-1;
//			    pageid=pageid*total+1;
//			}
//			list = cd.getRecords(pageid,total);
//
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		request.setAttribute("listTKTK", list);
		request.getRequestDispatcher("views/listTKTK.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
