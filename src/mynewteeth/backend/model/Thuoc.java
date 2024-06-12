/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.backend.model;

/**
 *
 * @author PC
 */
public class Thuoc {

    private String maBenhNhan;
    private String maVatTu;

    public Thuoc() {
    }

    public Thuoc(String maBenhNhan, String maVatTu) {
        this.maBenhNhan = maBenhNhan;
        this.maVatTu = maVatTu;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getMaVatTu() {
        return maVatTu;
    }

    public void setMaVatTu(String maVatTu) {
        this.maVatTu = maVatTu;
    }
    
}
