/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.backend.model;

import java.util.Date;

/**
 *
 * @author Us
 */
public class BacSi {
    
    private String maBacSi;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String queQuan;
    private String soDienThoai;
    private String chuyenMon;
    private String chucVu;
    private double luongThang;

    public BacSi() {
    }

    
    // Constructor đầy đủ
    public BacSi(String maBacSi, String hoTen, Date ngaySinh, String gioiTinh, String queQuan, String soDienThoai, String chuyenMon, String chucVu, double luongThang) {
        this.maBacSi = maBacSi;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.soDienThoai = soDienThoai;
        this.chuyenMon = chuyenMon;
        this.chucVu = chucVu;
        this.luongThang = luongThang;
    }

    // Getters và setters cho tất cả các thuộc tính
    public String getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(String maBacSi) {
        this.maBacSi = maBacSi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double getLuongThang() {
        return luongThang;
    }

    public void setLuongThang(double luongThang) {
        this.luongThang = luongThang;
    }

    @Override
    public String toString() {
        return "BacSi{" + "maBacSi=" + maBacSi + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", queQuan=" + queQuan + ", soDienThoai=" + soDienThoai + ", chuyenMon=" + chuyenMon + ", chucVu=" + chucVu + ", luongThang=" + luongThang + '}';
    }
    
}
