/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.backend.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mynewteeth.backend.interfaces.InvalidMaHoSoBenhNhanException;
import mynewteeth.backend.model.BacSi;
import mynewteeth.backend.model.BenhNhan;
import mynewteeth.backend.model.HoSoBenhNhan;

/**
 *
 * @author PC
 */
public class HoSoBenhNhanController {

    private List<HoSoBenhNhan> danhSachHoSoBenhNhan;
    private BenhNhanController benhNhanController;
    private BacSiController bacSiController;
    private VatTuController vaTuConTroller;
    public HoSoBenhNhanController() {
        danhSachHoSoBenhNhan = new ArrayList<>();
        benhNhanController = new BenhNhanController();
        bacSiController = new BacSiController();
        vaTuConTroller = new VatTuController();
        benhNhanController.loadFromFile("src/mynewteeth/backend/data_repository/local_data/raw_data/BenhNhan.txt");
        bacSiController.addFromFile("src/mynewteeth/backend/data_repository/local_data/raw_data/BacSi.txt");
        vaTuConTroller.loadFromFile("src/mynewteeth/backend/data_repository/local_data/raw_data/VatTu.txt");
    }

    public VatTuController getVaTuConTroller() {
        return vaTuConTroller;
    }
    
    public String findTenBenhNhanByMaBenhNhan(String maBenhNhan) {
        String filePath = "src/mynewteeth/backend/data_repository/local_data/raw_data/BenhNhan.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length >= 2 && parts[0].equals(maBenhNhan)) {
                    return parts[1]; // Trả về tên Bệnh Nhân nếu mã trùng khớp
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy mã Bệnh Nhân
    }

    public String findTenBacSiByMa(String maBacSi) {
        String filePath = "src/mynewteeth/backend/data_repository/local_data/raw_data/BacSi.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length >= 2 && parts[0].equals(maBacSi)) {
                    return parts[1]; // Trả về tên Bác sĩ nếu mã trùng khớp
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy mã Bác sĩ
    }

    // Hàm lưu thông tin vào file HoSoBenhNhan.txt
    public boolean saveToHoSoBenhNhanFile(String maHoSoBenhNhan, String ngayKham, String trieuChung, String chanDoan, String tenBacSi, String maBacSi, String ghiChu, String ngayTaiKham, String maBenhNhan) {
        try {
            MaBenhAnExists(maHoSoBenhNhan);
            String fileName = "src/mynewteeth/backend/data_repository/local_data/raw_data/HoSoBenhNhan.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                // Ghi thông tin vào file
                writer.write(maHoSoBenhNhan + "#" + ngayKham + "#" + trieuChung + "#" + chanDoan + "#" + tenBacSi + "#" + maBacSi + "#" + ghiChu + "#" + ngayTaiKham + "#" + maBenhNhan);
                writer.newLine();
                return true;
            } catch (IOException e) {
                // Xử lý nếu có lỗi khi ghi vào file
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi ghi vào file HoSoBenhNhan.txt: " + e.getMessage()); 
                return false;
            }
        } catch (InvalidMaHoSoBenhNhanException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  // Định dạng ngày tháng
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 9) { // Số lượng thuộc tính trong một dòng
                    String maHoSoBenhNhan = parts[0];
                    Date ngayKham = parts[1].isEmpty() ? null : sdf.parse(parts[1]);
                    String trieuChung = parts[2];
                    String chuanDoanBanDau = parts[3];
                    String tienSuBenh = parts[4];
                    Date ngayTaiKham = parts[7].isEmpty() ? null : sdf.parse(parts[7]);
                    String ghiChuBacSi = parts[6];

                    BenhNhan benhNhan = benhNhanController.findBenhNhanByMa(parts[8]);
                    BacSi bacSi = bacSiController.findBacSiByMa(parts[5]);
//                    if(bacSi==null){
//                        bacSi = new BacSi("BS001","pppp",ngayKha,"Nam","pppppppp","0964203976","66666666d","dfdfsa",1500000.5);
//                    }
                    // Tạo đối tượng HoSoBenhNhan và thêm vào danh sách
                    HoSoBenhNhan hoSoBenhNhan = new HoSoBenhNhan(maHoSoBenhNhan, benhNhan, bacSi, ngayKham,
                            trieuChung, chuanDoanBanDau, tienSuBenh, ngayTaiKham, ghiChuBacSi, 0, vaTuConTroller.getDanhSachVatTu());
                    danhSachHoSoBenhNhan.add(hoSoBenhNhan);
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

    public void MaBenhAnExists(String maBenhAn) throws InvalidMaHoSoBenhNhanException {
        for (HoSoBenhNhan bn : danhSachHoSoBenhNhan) {
            if (bn.getMaHoSoBenhNhan().equals(maBenhAn)) {
                throw new InvalidMaHoSoBenhNhanException("Mã hồ sơ bênh nhân đã tồn tại vui lòng nhập lại");
            }
        }
    }

    public List<HoSoBenhNhan> getDanhSachHoSoBenhNhan() {
        return danhSachHoSoBenhNhan;
    }
}
