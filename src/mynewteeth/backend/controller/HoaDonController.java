/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.backend.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import mynewteeth.backend.model.HoaDon;

/**
 *
 * @author Acer
 */
public class HoaDonController {

    private List<HoaDon> danhSachHoaDon;

    public List<HoaDon> getDanhSachHoaDon() {
        return danhSachHoaDon;
    }

    public HoaDonController() {
        this.danhSachHoaDon = new ArrayList<>();
    }

    //Thêm mới một hóa đơn
    public boolean addHoaDon(HoaDon hoaDon) {
        try {
            hoaDon.SoHoaDonNull();
            hoaDon.TongTienAm();
            danhSachHoaDon.add(hoaDon);
            appendToFile(hoaDon);
            return true;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    //Ghi hóa đơn vào file HoaDon.txt
    private void appendToFile(HoaDon hoaDon) {
        String fileName = "src/mynewteeth/backend/data_repository/local_data/raw_data/HoaDon.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngayKham = sdf.format(hoaDon.getNgayKham());
            String line = hoaDon.getSoHoaDon() + "#" + ngayKham + "#" + hoaDon.getBenhNhan() + "#"
                    + hoaDon.getDichVu() + "#" + hoaDon.getVatTu() + "#" + hoaDon.getTongTien();
            writer.write(line);
            writer.newLine(); // Xuống dòng để ghi hóa đơn tiếp theo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Lấy dữ liệu từ file
    public void loadFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("#");
                if (parts.length == 6) {
                    String soHoaDon = parts[0];
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date ngayKham = sdf.parse(parts[1]);
                    String tenBenhNhan = parts[2];
                    String dichVu = parts[3];
                    String vatTu = parts[4];
                    double tongTien = Double.valueOf(parts[5]);
                    HoaDon hoaDon = new HoaDon(soHoaDon, ngayKham, tongTien);
                    danhSachHoaDon.add(hoaDon);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Lỗi phân tích cú pháp: " + e.getMessage());
        }
    }

    //Cập nhật file
    private void updateFile() {
        String fileName = "src/mynewteeth/backend/data_repository/local_data/raw_data/HoaDon.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (HoaDon hoaDon : danhSachHoaDon) {
                String ngayKham = sdf.format(hoaDon.getNgayKham());
                String line = hoaDon.getSoHoaDon() + "#" + ngayKham + "#" + hoaDon.getBenhNhan() + "#"
                        + hoaDon.getDichVu() + "#" + hoaDon.getVatTu() + "#" + hoaDon.getTongTien();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Xóa hóa đơn bằng số hóa đơn
    public boolean removeHoaDonBySo(String soHoaDon) {
        boolean found = false;
        for (HoaDon hoaDon : danhSachHoaDon) {
            if (hoaDon.getSoHoaDon().equals(soHoaDon)) {
                danhSachHoaDon.remove(hoaDon);
                found = true;
                break;
            }
        }

        if (found) {
            updateFile();
            return true;
        } else {
            return false;
        }
    }

    //Cập nhật hóa đơn
    public boolean updateHoaDon(HoaDon updatedHoaDon) {
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            if (danhSachHoaDon.get(i).getSoHoaDon().equals(updatedHoaDon.getSoHoaDon())) {
                danhSachHoaDon.set(i, updatedHoaDon);
                updateFile();
                return true;
            }
        }
        return false;
    }
    
    //Tìm hóa đơn bằng số hóa đơn
    public HoaDon findHoaDonBySo(String soHoaDon) {
        HoaDon newHoaDon = new HoaDon();
        for (HoaDon hoaDon : danhSachHoaDon) {
            if (hoaDon.getSoHoaDon().equals(soHoaDon)) {
                newHoaDon = hoaDon;
            }
        }
        return newHoaDon;
    }
}
