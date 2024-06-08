/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.backend.model;

/**
 *
 * @author Us
 */
public class DichVu {
    private String maDichVu;
    private String tenDicVu;
    private double giaTien;

    public DichVu() {
    }

    public DichVu(String maDichVu, String tenDicVu, double giaTien) {
        this.maDichVu = maDichVu;
        this.tenDicVu = tenDicVu;
        this.giaTien = giaTien;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDicVu() {
        return tenDicVu;
    }

    public void setTenDicVu(String tenDicVu) {
        this.tenDicVu = tenDicVu;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "DichVu{" + "maDichVu=" + maDichVu + ", tenDicVu=" + tenDicVu + ", giaTien=" + giaTien + '}';
    }
}
