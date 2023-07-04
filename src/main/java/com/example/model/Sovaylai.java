package com.example.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sovaylai {
    private Long id;
    private String soTKVay;
    private Double sotienvay;
    private Double laisuatvay;
    private int kihanvay;
    private Date ngayvay;
    private Date ngaydenhan;
    private Khachhang kh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoTKVay() {
        return soTKVay;
    }

    public void setSoTKVay(String soTKVay) {
        this.soTKVay = soTKVay;
    }

    public Double getSotienvay() {
        return sotienvay;
    }

    public void setSotienvay(Double sotienvay) {
        this.sotienvay = sotienvay;
    }

    public Double getLaisuatvay() {
        return laisuatvay;
    }

    public void setLaisuatvay(Double laisuatvay) {
        this.laisuatvay = laisuatvay;
    }

    public int getKihanvay() {
        return kihanvay;
    }

    public void setKihanvay(int kihanvay) {
        this.kihanvay = kihanvay;
    }

    public String getNgayvay() {
        return new SimpleDateFormat("dd-MM-yyyy").format(this.ngayvay);
    }

    public void setNgayvay(Date ngayvay) {
        this.ngayvay = ngayvay;
    }

    public String getNgaydenhan() {
        return new SimpleDateFormat("dd-MM-yyyy").format(this.ngaydenhan);
    }

    public void setNgaydenhan(Date ngaydenhan) {
        this.ngaydenhan = ngaydenhan;
    }

    public Khachhang getKh() {
        return kh;
    }

    public void setKh(Khachhang kh) {
        this.kh = kh;
    }
}
