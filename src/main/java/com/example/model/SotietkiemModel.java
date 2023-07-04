package com.example.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SotietkiemModel {
    private Long id;
    private String soStk;
    private Double sotiengui;
    private Double laisuatgui;
    private int kihangui;
    private Date ngaygui;
    private Date ngaydenhan;
    private Boolean isActive = true;
    private Khachhang kh;

    public SotietkiemModel() {
    }

    public SotietkiemModel(Long id, String soStk, Double sotiengui, Double laisuatgui, int kihangui, String ngaygui, Khachhang kh) throws ParseException {
        this.id = id;
        this.soStk = soStk;
        this.sotiengui = sotiengui;
        this.laisuatgui = laisuatgui;
        this.kihangui = kihangui;
        this.ngaygui = new SimpleDateFormat("yyyy-MM-dd").parse(ngaygui);
//        Tự động tính ngày tới hạn dựa trên kỳ hạn
        Calendar calendar = (Calendar) Calendar.getInstance();
        calendar.setTime(this.ngaygui);
        calendar.add(Calendar.MONTH, this.kihangui);
        this.ngaydenhan = calendar.getTime();
        this.isActive = (this.ngaydenhan.compareTo(Calendar.getInstance().getTime()) >= 0);
        this.kh = kh;
    }

    public String getNgaydenhan() {
        return new SimpleDateFormat("dd-MM-yyyy").format(this.ngaydenhan);
    }

    public void setNgaygui(Date ngaygui) {
        this.ngaygui = ngaygui;
    }

    public void setNgaydenhan(Date ngaydenhan) {
        this.ngaydenhan = ngaydenhan;
    }

    public int getActive() {
        return isActive ? 1:0;
    }

    public void setActive(Boolean active) {
        this.isActive = active;
    }

    public String getSoStk() {
        return soStk;
    }

    public void setSoStk(String soStk) {
        this.soStk = soStk;
    }

    public String getNgaygui() {
        return new SimpleDateFormat("dd-MM-yyyy").format(this.ngaygui);
    }

    public String getSotiengui() {
        return NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(this.sotiengui);
    }

    public Double getLaisuatgui() {
        return laisuatgui;
    }

    public void setSotiengui(Double sotiengui) {
        this.sotiengui = sotiengui;
    }

    public void setLaisuatgui(Double laisuatgui) {
        this.laisuatgui = laisuatgui;
    }

    public Khachhang getKh() {
        return kh;
    }

    public void setKh(Khachhang kh) {
        this.kh = kh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKihangui() {
        return kihangui;
    }

    public void setKihangui(int kihangui) {
        this.kihangui = kihangui;
    }
}
