package com.example.dao;

import com.example.model.Khachhang;
import com.example.model.SotietkiemModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TKSoTietKiemDAO extends DBContext{

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    public List<SotietkiemModel> findAll(String beginDate, String endDate, int index, int maxItemPage){
        List<SotietkiemModel> list = new ArrayList<>();
        String sql = "select s.id, k.id, k.fullname,s.soSTK, s.sotiengui, s.laisuatgui, s.kyhangui, s.ngaygui " +
                "from sotietkiem s inner join khachhang k on s.khachhangid=k.id " +
                "where ngaygui between ? and ? LIMIT ?, ?";
        try{
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, beginDate);
            statement.setString(2, endDate);
            statement.setInt(3,(index-1)*maxItemPage);
            statement.setInt(4, maxItemPage);
            rs = statement.executeQuery();
            while (rs.next()){
                SotietkiemModel so = new SotietkiemModel();
                so.setId(rs.getLong("id"));
                so.setSoStk(rs.getString("soSTK"));
                so.setSotiengui(rs.getDouble("sotiengui"));
                so.setLaisuatgui(rs.getDouble("laisuatgui"));
                so.setKihangui(rs.getInt("kyhangui"));
                so.setNgaygui(rs.getDate("ngaygui"));
                try{
                    Khachhang kh = new Khachhang();
                    kh.setId(rs.getLong("id"));
                    kh.setFullname(rs.getString("fullname"));
                    so.setKh(kh);
                }catch (SQLException e){
                    return null;
                }
                list.add(so);
            }
            return list;
        }catch (SQLException e){
            return null;
        }finally {
            try {
                if(conn != null) {
                    conn.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    public Khachhang getKhachhangByid(String id){
        List<Khachhang> listKh = new ArrayList<>();
        String sql = "SELECT * FROM khachhang WHERE id = ?";
        try{
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1,id);
            rs = statement.executeQuery();
            while(rs.next()){
                Khachhang kh = new Khachhang();
                kh.setId(rs.getLong("id"));
                kh.setFullname(rs.getString("fullname"));
                kh.setAddress(rs.getString("diachi"));
                kh.setPhone(rs.getString("sdt"));
                listKh.add(kh);
            }
            return listKh.isEmpty() ? null : listKh.get(0);
        }catch(SQLException e){
            return null;
        }finally {
            try {
                if(conn != null) {
                    conn.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    public int getTotalItem(String beginDate, String endDate){
        int count = 0;
        String sql = "SELECT count(*) FROM sotietkiem \n" +
                "WHERE ngaygui BETWEEN ? AND ?";
        try{
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1,beginDate);
            statement.setString(2,endDate);
            rs = statement.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
            return count;
        }catch (SQLException e){
            return 0;
        }finally {
            try {
                if(conn != null) {
                    conn.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                return 0;
            }
        }
    }
//    public List<SovaylaiModel> findSovaylaiAll(String beginDate, String endDate, int index, int maxItemPage){
//        List<SovaylaiModel> list = new ArrayList<>();
//        String sql = "select * from sovaylai s inner join khachhang k on s.khachhangid=k.id where ngayvay between ? and ? LIMIT ?, ?";
//        try{
//            conn = getConnection();
//            statement = conn.prepareStatement(sql);
//            statement.setString(1, beginDate);
//            statement.setString(2, endDate);
//            statement.setInt(3,(index-1)*maxItemPage);
//            statement.setInt(4, maxItemPage);
//            rs = statement.executeQuery();
//            while (rs.next()){
//                SovaylaiModel so = new SovaylaiModel();
//                so.setId(rs.getLong("id"));
//                so.setSotienvay(rs.getDouble("sotienvay"));
//                so.setLaisuatvay(rs.getDouble("laisuatvay"));
//                so.setKihanvay(rs.getInt("kyhanvay"));
//                so.setNgayvay(rs.getString("ngayvay"));
//                try{
//                    Khachhang kh = new Khachhang();
//                    kh.setId(rs.getLong("id"));
//                    kh.setFullname(rs.getString("fullname"));
//                    so.setKh(kh);
//                }catch (SQLException e){
//                    return null;
//                }
//                list.add(so);
//            }
//            return list;
//        }catch (SQLException e){
//            return null;
//        }finally {
//            try {
//                if(conn != null) {
//                    conn.close();
//                }
//                if(statement != null) {
//                    statement.close();
//                }
//                if(rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                return null;
//            }
//        }
//    }
//    public int getTotalItemVaylai(String beginDate, String endDate){
//        int count = 0;
//        String sql = "SELECT count(*) FROM sovaylai \n" +
//                "WHERE ngayvay BETWEEN ? AND ?";
//        try{
//            conn = getConnection();
//            statement = conn.prepareStatement(sql);
//            statement.setString(1,beginDate);
//            statement.setString(2,endDate);
//            rs = statement.executeQuery();
//            while (rs.next()){
//                count = rs.getInt(1);
//            }
//            return count;
//        }catch (SQLException e){
//            return 0;
//        }finally {
//            try {
//                if(conn != null) {
//                    conn.close();
//                }
//                if(statement != null) {
//                    statement.close();
//                }
//                if(rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                return 0;
//            }
//        }
//    }
}
