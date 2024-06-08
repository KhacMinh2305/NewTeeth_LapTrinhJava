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
public class VatTu {
    private String maVatTu;
    private String tenVatTu;
    private String loai;
    private String tinhTrang;
    private String giaNhap;
    private Date ngayNhap;
    private int soLuong;

    public String getMaVatTu() {
        return maVatTu;
    }

    public void setMaVatTu(String maVatTu) {
        this.maVatTu = maVatTu;
    }

    public String getTenVatTu() {
        return tenVatTu;
    }

    public void setTenVatTu(String tenVatTu) {
        this.tenVatTu = tenVatTu;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public VatTu(String maVatTu, String tenVatTu, String loai, String tinhTrang, Date ngayNhap, int soLuong) {
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.loai = loai;
        this.tinhTrang = tinhTrang;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
    }     

    public VatTu() {
    }
}
