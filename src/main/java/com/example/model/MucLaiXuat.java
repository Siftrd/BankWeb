/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author rioxv
 */
public class MucLaiXuat {
    private int id,kyHan;
    private double laiXuat;

    public MucLaiXuat() {
    }

    public MucLaiXuat(int id, double laiXuat,int kyHan ) {
        this.id = id;
        this.kyHan = kyHan;
        this.laiXuat = laiXuat;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MucLaiXuat other = (MucLaiXuat) obj;
        if (this.kyHan != other.kyHan) {
            return false;
        }
        return Double.doubleToLongBits(this.laiXuat) == Double.doubleToLongBits(other.laiXuat);
    }

    @Override
    public String toString() {
        return "MucLaiXuat{" + "id=" + id + ", kyHan=" + kyHan + ", laiXuat=" + laiXuat + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    public double getLaiXuat() {
        return laiXuat;
    }

    public void setLaiXuat(float laiXuat) {
        this.laiXuat = laiXuat;
    }
    
    
}
