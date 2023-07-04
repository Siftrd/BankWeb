package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.example.model.Khachhang;
import com.example.model.SotietkiemModel;

public class TK_TietKiemDAO extends DBContext {
	Connection connection = getConnection();

	public TK_TietKiemDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<SotietkiemModel> getRecords(int start, int total) throws ParseException{
		ArrayList<SotietkiemModel> list = new ArrayList<>();
		String sql = "SELECT * FROM sotietkiem limit "+(start-1)+","+total;

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Khachhang kh = new KhachHangDAO().getKHById(rs.getLong("khachhangid"));
				
				SotietkiemModel c = new SotietkiemModel(rs.getLong("id"), rs.getString("soSTK"), rs.getDouble("sotiengui"),
						rs.getDouble("laisuatgui"), rs.getInt("kyhangui"),
						rs.getString("ngaygui"), kh);
				list.add(c);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}
//
//	public static ArrayList<TK_TietKiem> getAll() throws ParseException {
//		ArrayList<TK_TietKiem> list = new ArrayList<>();
//		String sql = "SELECT * FROM `tk_tiet_kiem`";
//
//		try {
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				KhachHang kh = new KhachHangDAO().getKHById(Integer.parseInt(rs.getString("maKH")));
//				
//				TK_TietKiem c = new TK_TietKiem(rs.getInt("kyHan"), rs.getString("id"), rs.getString("soTK"),
//						rs.getString("ngayMo"), rs.getDouble("soTienGui"),
//						rs.getDouble("laiSuat"), kh, rs.getString("hinhThucNhanLaiSuat"));
//				list.add(c);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//		return list;
//	}

	public SotietkiemModel getTKTKById(Long id) throws ParseException {
//		ArrayList<TK_TietKiemDAO> list = new ArrayList<>();
		String sql = "SELECT * FROM sotietkiem WHERE id="+id;

		SotietkiemModel p = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Khachhang kh = new KhachHangDAO().getKHById(rs.getLong("khachhangid"));
				
				p = new SotietkiemModel(rs.getLong("id"), rs.getString("soSTK"), rs.getDouble("sotiengui"),
						rs.getDouble("laisuatgui"), rs.getInt("kyhangui"),
						rs.getString("ngaygui"), kh);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return p;
	}


	public ArrayList<SotietkiemModel> getTKTKByMaKH(Long id) throws ParseException {
		ArrayList<SotietkiemModel> list = new ArrayList<>();
		String sql = "SELECT * FROM sotietkiem WHERE khachhangid="+id;
		Khachhang kh = new KhachHangDAO().getKHById(id);
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SotietkiemModel c = new SotietkiemModel(rs.getLong("id"), rs.getString("soSTK"), rs.getDouble("sotiengui"),
						rs.getDouble("laisuatgui"), rs.getInt("kyhangui"),
						rs.getString("ngaygui"), kh);
				list.add(c);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}

	public ArrayList<SotietkiemModel> search(String fromDate, String toDate, Double minValue, String status) {
		String sql = "SELECT * FROM sotietkiem WHERE 1=1";

		if (minValue != 0.0)
			sql += " AND price >= " + minValue;
		if (!fromDate.equals("2000-01-01")) {
			Date date = Date.valueOf(fromDate);
			sql += " AND ngaydenhan >= " + date;
		}
		if (!toDate.equals("2100-01-01")) {
			Date date = Date.valueOf(toDate);
			sql += " AND ngaydenhan <= " + date;
		}
		if(status != "") {
			sql += " AND isActive = " + status;
		}
		
		ArrayList<SotietkiemModel> list = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Khachhang kh = new KhachHangDAO().getKHById(Long.parseLong(rs.getString("khachhangid")));
				
				SotietkiemModel c = new SotietkiemModel(rs.getLong("id"), rs.getString("soSTK"), rs.getDouble("sotiengui"),
						rs.getDouble("laisuatgui"), rs.getInt("kyhangui"),
						rs.getString("ngaygui"), kh);
				
				list.add(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
