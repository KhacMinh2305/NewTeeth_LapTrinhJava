/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Us
 */
public class HoaDon {
    private String soHoaDon;
    private Date ngayKham;
    private BenhNhan benhNhan;
    private ArrayList<DichVu> dichVu;
    private ArrayList<VatTu> vatTu;
    private double tongTien;

    // Constructor không đối
    public HoaDon() {
    }
    
    // Constructor đầy đủ
    public HoaDon(String soHoaDon, Date ngayKham, ArrayList<DichVu> dichVu, ArrayList<VatTu> vatTu, double tongTien) {
        this.soHoaDon = soHoaDon;
        this.ngayKham = ngayKham;
        this.dichVu = dichVu;
        this.vatTu = vatTu;
        this.tongTien = tongTien;
    }

    // Getters và setters cho tất cả các thuộc tính
    public HoaDon(String soHoaDon, Date ngayKham, Double tongTien) {
        this.soHoaDon = soHoaDon;
        this.ngayKham = ngayKham;
        this.tongTien = tongTien;
    }

    public String getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(String soHoaDon)  {
        this.soHoaDon = soHoaDon;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public ArrayList<DichVu> getDichVu() {
        return dichVu;
    }

    public void setDichVu(ArrayList<DichVu> dichVu) {
        this.dichVu = dichVu;
    }

    public ArrayList<VatTu> getVatTu() {
        return vatTu;
    }

    public void setVatTu(ArrayList<VatTu> vatTu) {
        this.vatTu = vatTu;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.soHoaDon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoaDon other = (HoaDon) obj;
        return Objects.equals(this.soHoaDon, other.soHoaDon);
    }

    @Override
    public String toString() {
        return "HoaDon{" + "soHoaDon=" + soHoaDon + ", ngayKham=" + ngayKham + ", benhNhan=" + benhNhan + ", dichVu=" + dichVu + ", vatTu=" + vatTu + ", tongTien=" + tongTien + '}';
    }
    
    public void SoHoaDonNull() throws Exception{
        if(soHoaDon.trim().isEmpty()||soHoaDon.isBlank())
            throw new Exception("Số hóa đơn không được để trống!");
    }
    
    public void TongTienAm() throws Exception {
        if(tongTien<0) 
            throw new Exception("Tổng tiền không được âm!");
    }
}
