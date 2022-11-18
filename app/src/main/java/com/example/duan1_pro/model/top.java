package com.example.duan1_pro.model;

public class top {
    String tenMatHang;
    int soLuong;

    public top(String tenMatHang, int soLuong) {
        this.tenMatHang = tenMatHang;
        this.soLuong = soLuong;
    }

    public top() {
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
