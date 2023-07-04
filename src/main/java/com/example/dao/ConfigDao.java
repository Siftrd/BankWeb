/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.MucLaiXuat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rioxv
 */
public class ConfigDao extends DBContext{

    Connection conn = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

   

    public List<MucLaiXuat> getLaiXuat() {
        List<MucLaiXuat> list = new ArrayList<>();
        String stm = "select * from muclaixuat ";
        try {
            
            ps = conn.prepareStatement(stm);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MucLaiXuat(rs.getInt(1),  rs.getDouble(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public MucLaiXuat getLaiXuatByID(String id) {
       
        String stm = "select * from muclaixuat where id = ? ";
        try {
            
            ps = conn.prepareStatement(stm);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new MucLaiXuat(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
            }
        } catch (SQLException e) {
        }
        return null;
    }
    public void deleteLaiXuat(String id) {
        String stm = "delete from muclaixuat where id = ?";
        try {
            
            ps = conn.prepareStatement(stm);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void addLaiXuat(double laiXuat, int kyHan) {
        String stm = "INSERT INTO muclaixuat (kyhan, laixuat) VALUES (?, ?);";
        try {
            
            ps = conn.prepareStatement(stm);
            ps.setDouble(2, laiXuat);
            ps.setInt(1, kyHan);
            ps.executeUpdate();
      
        } catch (SQLException e) {
        }
        
    }

    public void editLaiXuat(String id, double laiXuat, int kyHan) {
        String stm = "update muclaixuat set laiXuat = ?,kyHan = ? where id = ? ";
        try {
            ps = conn.prepareStatement(stm);
            ps.setDouble(1, laiXuat);
            ps.setInt(2, kyHan);
            ps.setString(3, id);
            ps.executeUpdate();
            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }
}
