package com.example.dao;

import com.example.model.Khachhang;
import com.example.model.Sovaylai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TKSoVayLaiDAO extends DBContext{
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    public List<Sovaylai> findAll(Double sotienvay, int index, int maxItemPage){
        List<Sovaylai> list = new ArrayList<>();
        String sql = "select * " +
                "from sovaylai s inner join khachhang k on s.khachhangid=k.id " +
                "where sotienvay <= ? order by sotienvay ASC LIMIT ?, ?";
        try{
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setDouble(1, sotienvay);
            statement.setInt(3,(index-1)*maxItemPage);
            statement.setInt(4, maxItemPage);
            rs = statement.executeQuery();
            while (rs.next()){
                Sovaylai so = new Sovaylai();
                so.setId(rs.getLong("id"));
                so.setSotienvay(rs.getDouble("sotienvay"));
                so.setSoTKVay(rs.getString("sotk"));
                so.setLaisuatvay(rs.getDouble("laisuatvay"));
                so.setKihanvay(rs.getInt("kyhanvay"));
                so.setNgayvay(rs.getDate("ngayvay"));
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
    public int getTotalItem(Double sotienvay){
        int count = 0;
        String sql = "SELECT count(*) FROM sovaylai \n" +
                "WHERE sotienvay <= ?";
        try{
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setDouble(1,sotienvay);
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
}
