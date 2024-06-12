package mynewteeth.backend.model;

import java.util.Date;

public class VatTu {
    private String maVatTu;
    private String tenVatTu;
    private String loai;
    private String tinhTrang;
    private double giaNhap; // Đổi sang double
    private Date ngayNhap;
    private int soLuong;

    // Constructor
    public VatTu(String maVatTu, String tenVatTu, String loai, String tinhTrang, double giaNhap, Date ngayNhap, int soLuong) {
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.loai = loai;
        this.tinhTrang = tinhTrang;
        this.giaNhap = giaNhap;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
    }

    // Getters and setters
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

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
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

    @Override
    public String toString() {
        return "VatTu{" +
                "maVatTu='" + maVatTu + '\'' +
                ", tenVatTu='" + tenVatTu + '\'' +
                ", loai='" + loai + '\'' +
                ", tinhTrang='" + tinhTrang + '\'' +
                ", giaNhap=" + giaNhap +
                ", ngayNhap=" + ngayNhap +
                ", soLuong=" + soLuong +
                '}';
    }
}
