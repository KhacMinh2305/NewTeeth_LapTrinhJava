/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.backend.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import mynewteeth.backend.model.BacSi;
import mynewteeth.backend.model.BenhNhan;

/**
 *
 * @author PC
 */
public class BacSiController {

    private List<BacSi> danhSachBacSy;

    public BacSiController() {
        danhSachBacSy = new ArrayList<>();
    }

    public List<BacSi> getDanhSachBacSy() {
        return danhSachBacSy;
    }

    public BacSi findBacSiByMa(String maBacSi) {
        BacSi newBacSi = new BacSi();
        for (BacSi bs : danhSachBacSy) {
            if (bs.getMaBacSi().equals(maBacSi)) {
                newBacSi = bs;
            }
        }
        return newBacSi;
    }
    
    //hàm lấy thông tin tư file BacSy cho vào danh sách
    public void addFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("#");
                if (parts.length == 9) {
                    String maBacSy = parts[0];
                    String tenBacSy = parts[1];
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date ngaySinh = sdf.parse(parts[2]);
                    String gioiTinh = parts[3];
                    String queQuan = parts[4];
                    String soDienThoai = parts[5];
                    String chuyenMon = parts[6];
                    String chucVu = parts[7];
                    double luongThang = Double.parseDouble(parts[8].replace(",", "")); // Xóa dấu phẩy nếu có trong giá trị lương

                    BacSi bacsi = new BacSi(maBacSy, tenBacSy, ngaySinh, gioiTinh, queQuan, soDienThoai, chuyenMon, chucVu, luongThang);
                    danhSachBacSy.add(bacsi);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Parse exception: " + e.getMessage());
        }
    }

    //Viết tiếp code nhé, tôi cần danh sách trước lên tạo trước danh sach, anh em làm phần này đừng sửa tên biến danh sách nhé, thank you <3
}
