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
        try {
            if (maVatTu == null || maVatTu.trim().isEmpty()) {
                throw new IllegalArgumentException("Mã vật tư không được để trống");
            }
            this.maVatTu = maVatTu;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTenVatTu() {
        return tenVatTu;
    }

    public void setTenVatTu(String tenVatTu) {
        try {
            if (tenVatTu == null || tenVatTu.trim().isEmpty()) {
                throw new IllegalArgumentException("Tên vật tư không được để trống");
            }
            this.tenVatTu = tenVatTu;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        try {
            if (loai == null || loai.trim().isEmpty()) {
                throw new IllegalArgumentException("Loại không được để trống");
            }
            this.loai = loai;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        try {
            if (tinhTrang == null || tinhTrang.trim().isEmpty()) {
                throw new IllegalArgumentException("Tình trạng không được để trống");
            }
            this.tinhTrang = tinhTrang;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        try {
            if (giaNhap == null || !giaNhap.matches("\\d+(\\.\\d+)?")) {
                throw new IllegalArgumentException("Giá nhập phải là số");
            }
            this.giaNhap = giaNhap;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        try {
            if (ngayNhap == null || ngayNhap.after(new Date())) {
                throw new IllegalArgumentException("Ngày nhập phải là ngày trong quá khứ và không được để trống");
            }
            this.ngayNhap = ngayNhap;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        try {
            if (soLuong < 0) {
                throw new IllegalArgumentException("Số lượng không thể âm");
            }
            this.soLuong = soLuong;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getGiaTien() {
        try {
            return Double.parseDouble(this.getGiaNhap()) / this.soLuong;
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format for giaNhap: " + this.giaNhap);
            return 0.0; // Giá trị mặc định nếu không thể chuyển đổi
        }
    }

    public VatTu(String maVatTu, String tenVatTu, String loai, String tinhTrang, String giaNhap, Date ngayNhap, int soLuong) {
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.loai = loai;
        this.tinhTrang = tinhTrang;
        this.giaNhap = giaNhap;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "VatTu{" + "maVatTu=" + maVatTu + ", tenVatTu=" + tenVatTu + ", loai=" + loai + ", tinhTrang=" + tinhTrang + ", giaNhap=" + giaNhap + ", ngayNhap=" + ngayNhap + ", soLuong=" + soLuong + '}';
    }

    public VatTu() {
        try {
            // Default constructor logic if any
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
