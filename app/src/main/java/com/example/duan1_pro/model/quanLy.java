package com.example.duan1_pro.model;

public class quanLy {
    private String maQuanLy;
    private String tenQuanLy;
    private String matkhau;

    public quanLy() {
    }

    public quanLy(String maQuanLy, String tenQuanLy, String matkhau) {
        this.maQuanLy = maQuanLy;
        this.tenQuanLy = tenQuanLy;
        this.matkhau = matkhau;
    }

    public String getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(String maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public String getTenQuanLy() {
        return tenQuanLy;
    }

    public void setTenQuanLy(String tenQuanLy) {
        this.tenQuanLy = tenQuanLy;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "quanLy{" +
                "maQuanLy='" + maQuanLy + '\'' +
                ", tenQuanLy='" + tenQuanLy + '\'' +
                ", matkhau='" + matkhau + '\'' +
                '}';
    }
}
