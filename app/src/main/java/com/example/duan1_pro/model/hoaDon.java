package com.example.duan1_pro.model;

import java.util.Date;

public class hoaDon {
    private int maHoaDon;
    private String tenHoaDon;
    private int maKhachHang;
    private int maMatHang;
    private Date ngayMua;
    private float thanhTien;

    public hoaDon() {
    }

    public hoaDon(int maHoaDon, String tenHoaDon, int maKhachHang, int maMatHang, Date ngayMua, float thanhTien) {
        this.maHoaDon = maHoaDon;
        this.tenHoaDon = tenHoaDon;
        this.maKhachHang = maKhachHang;
        this.maMatHang = maMatHang;
        this.ngayMua = ngayMua;
        this.thanhTien = thanhTien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(int maMatHang) {
        this.maMatHang = maMatHang;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "hoaDon{" +
                "maHoaDon=" + maHoaDon +
                ", tenHoaDon='" + tenHoaDon + '\'' +
                ", maKhachHang=" + maKhachHang +
                ", maMatHang=" + maMatHang +
                ", ngayMua=" + ngayMua +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
