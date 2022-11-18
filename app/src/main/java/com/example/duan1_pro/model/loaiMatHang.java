package com.example.duan1_pro.model;

public class loaiMatHang {
    private int maLoaiMatHang;
    private String tenLoaiMatHang;

    public loaiMatHang() {
    }

    public loaiMatHang(int maLoaiMatHang, String tenLoaiMatHang) {
        this.maLoaiMatHang = maLoaiMatHang;
        this.tenLoaiMatHang = tenLoaiMatHang;
    }

    public int getMaLoaiMatHang() {
        return maLoaiMatHang;
    }

    public void setMaLoaiMatHang(int maLoaiMatHang) {
        this.maLoaiMatHang = maLoaiMatHang;
    }

    public String getTenLoaiMatHang() {
        return tenLoaiMatHang;
    }

    public void setTenLoaiMatHang(String tenLoaiMatHang) {
        this.tenLoaiMatHang = tenLoaiMatHang;
    }

    @Override
    public String toString() {
        return "loaiMatHang{" +
                "maLoaiMatHang=" + maLoaiMatHang +
                ", tenLoaiMatHang='" + tenLoaiMatHang + '\'' +
                '}';
    }
}
