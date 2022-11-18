package com.example.duan1_pro.model;

public class matHang {
    private int maMatHang;
    private String tenMatHang;
    private float giaban;
    private int maLoaiMatHang;

    public matHang() {
    }

    public matHang(int maMatHang, String tenMatHang, float giaban, int maLoaiMatHang) {
        this.maMatHang = maMatHang;
        this.tenMatHang = tenMatHang;
        this.giaban = giaban;
        this.maLoaiMatHang = maLoaiMatHang;
    }

    public int getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(int maMatHang) {
        this.maMatHang = maMatHang;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public int getMaLoaiMatHang() {
        return maLoaiMatHang;
    }

    public void setMaLoaiMatHang(int maLoaiMatHang) {
        this.maLoaiMatHang = maLoaiMatHang;
    }

    @Override
    public String toString() {
        return "matHang{" +
                "maMatHang=" + maMatHang +
                ", tenMatHang='" + tenMatHang + '\'' +
                ", giaban=" + giaban +
                ", maLoaiMatHang=" + maLoaiMatHang +
                '}';
    }
}
