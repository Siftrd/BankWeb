/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rioxv
 */
public class LoginDao extends DBContext{
    Connection conn = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public Account login(String user, String pass){
        String stm = "select * from user where username = ? and password = ?";
        try{
            
            ps = conn.prepareStatement(stm);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            
        }catch(SQLException e){
        }
        
        return null;
    }
}