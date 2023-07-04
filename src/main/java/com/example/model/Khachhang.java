package com.example.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Khachhang {
    private Long id;
    private String fullname;
    private String address;
    private String phone;
    private String cccd;
    private String gioitinh;
    private Date ngaysinh;

    public Khachhang() {
    }

    public Khachhang(Long id, String fullname, String address, String phone, String cccd, String gioitinh, String ngaysinh)throws ParseException {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.cccd = cccd;
        this.gioitinh = gioitinh;
        this.ngaysinh = new SimpleDateFormat("yy-mm-dd").parse(ngaysinh);
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return new SimpleDateFormat("dd-MM-yyyy").format(this.ngaysinh);
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
