package com.example.dao;

import com.example.model.Khachhang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class KhachHangDAO extends DBContext {
	Connection connection = getConnection();

	public KhachHangDAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Khachhang> getAll() throws ParseException {
		ArrayList<Khachhang> list = new ArrayList<>();
		String sql = "SELECT * FROM khachhang";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Khachhang c = new Khachhang(rs.getLong("id"), rs.getString("fullName"), rs.getString("diachi"), rs.getString("sdt"),
						rs.getString("cccd"), rs.getString("gioitinh"),new SimpleDateFormat("yyyy-mm-dd").format(rs.getDate("ngaysinh")));
				list.add(c);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}

	public Khachhang getKHById(Long id) throws ParseException {
//		ArrayList<TK_TietKiemDAO> list = new ArrayList<>();
		String sql = "SELECT * FROM khachhang WHERE id="+id;

		Khachhang p = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p = new Khachhang(rs.getLong("id"), rs.getString("fullName"), rs.getString("diachi"), rs.getString("sdt"),
						rs.getString("cccd"), rs.getString("gioitinh"),new SimpleDateFormat("yyyy-mm-dd").format(rs.getDate("ngaysinh")));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return p;
	}

//	public static ArrayList<TK_TietKiem> search(String fromDate, String toDate, Double minValue, int kyHan) {
//		String sql = "SELECT * FROM `tk_tiet_kiem` WHERE 1=1";
//
//		if (kyHan!=0)
//			sql += " AND kyHan = " + kyHan;
//		if (minValue != 0.0)
//			sql += " AND price >= " + minValue;
//		if (!fromDate.equals("2000-01-01")) {
//			Date date = Date.valueOf(fromDate);
//			sql += " AND ngayDenHan >= " + date;
//		}
//		if (!toDate.equals("2100-01-01")) {
//			Date date = Date.valueOf(toDate);
//			sql += " AND ngayDenHan <= " + date;
//		}
//		
//		ArrayList<TK_TietKiem> list = new ArrayList<>();
//
//		try {
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				list.add(new TK_TietKiem(rs.getInt("kyHan"), rs.getString("id"), rs.getString("soTK"), rs.getString("soSo"), new SimpleDateFormat("yyyy-mm-dd").format(rs.getDate(4)),
//						 new SimpleDateFormat("yyyy-mm-dd").format(rs.getDate(5)),  rs.getDouble("soDu"), rs.getDouble("laiSuat"),
//						rs.getString("hinhThucNhanLaiSuat"), rs.getString("maKH")));
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("Danh sach: " + list);
//		return list;
//	}

//	public static void add(TK_TietKiemDAO c) {
//		String sql = "INSERT INTO `category` VALUES (?,?,?)";
//		try {
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ps.setInt(1, c.getId());
//			ps.setString(2, c.getName());
//			ps.setString(3, c.getDescribe());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//	}

//	public static void deleteCategory(int id) {
//		String sql = "DELETE FROM `category` WHERE id=?";
//		try {
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ps.setInt(1, id);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//	}

//	public static void main(String[] args) {
//		CategoryDAO u = new CategoryDAO();
//		ArrayList<Category> arr = u.getAll();
//		System.out.println(arr.get(0).getId());
//	}
}
