package com.example.quanlyca;

public class Ca {
    private String id;
    private String tenKH;
    private String tenThuong;
    private String dacTinh;
    private String mausac;

    public Ca() {
    }

    @Override

    public String toString() {
        return "Ca{" +
                "id='" + id + '\'' +
                ", tenKH='" + tenKH + '\'' +
                ", tenThuong='" + tenThuong + '\'' +
                ", dacTinh='" + dacTinh + '\'' +
                ", mausac='" + mausac + '\'' +
                '}';
    }

    public Ca( String tenKH, String tenThuong, String dacTinh, String mausac) {

        this.tenKH = tenKH;
        this.tenThuong = tenThuong;
        this.dacTinh = dacTinh;
        this.mausac = mausac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenThuong() {
        return tenThuong;
    }

    public void setTenThuong(String tenThuong) {
        this.tenThuong = tenThuong;
    }

    public String getDacTinh() {
        return dacTinh;
    }

    public void setDacTinh(String dacTinh) {
        this.dacTinh = dacTinh;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }
}
