/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.backend.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mynewteeth.backend.model.VatTu;

/**
 *
 * @author PC
 */
public class VatTuController {

    private List<VatTu> danhSachVatTu;

    public VatTuController() {
        danhSachVatTu = new ArrayList<>();
    }

   
    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  // Định dạng ngày tháng
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 7) { // Số lượng thuộc tính trong một dòng
                    String maVatTu = parts[0];
                    String tenVatTu = parts[1];
                    String loai = parts[2];
                    String tinhTrang = parts[3];
                    String giaNhap = parts[4];
                    Date ngayNhap = sdf.parse(parts[5]);
                    int soLuong = Integer.parseInt(parts[6]);

                    // Tạo đối tượng VatTu và thêm vào danh sách
                    VatTu vatTu = new VatTu(maVatTu, tenVatTu, loai, tinhTrang,giaNhap, ngayNhap, soLuong);
                    danhSachVatTu.add(vatTu);
                } else {
                    System.out.println("Error: Invalid data format in file");
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Parse exception: " + e.getMessage());
        }
    }

    public List<VatTu> getDanhSachVatTu() {
        return danhSachVatTu;
    }

    //Tôi cần danh sách vật tư lên tạo trước, anh em nào làm phần này xin đừng đổi tên biến danh sách nhé.
}
