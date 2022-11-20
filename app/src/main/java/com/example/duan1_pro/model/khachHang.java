package com.example.duan1_pro.model;

public class khachHang {
    private int maKhachHang;
    private String tenKhachHang;
    private int soDienThoai;
    private String diaChi;
    private String gioiTinh;
    private int tuoi;

    public khachHang() {
    }

    public khachHang(int maKhachHang, String tenKhachHang, int soDienThoai, String diaChi,int tuoi, String gioiTinh) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }



    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    @Override
    public String toString() {
        return "khachHang{" +
                "maKhachHang=" + maKhachHang +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", soDienThoai=" + soDienThoai +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", tuoi=" + tuoi +
                '}';
    }
}
