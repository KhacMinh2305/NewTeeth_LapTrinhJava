package mynewteeth.backend.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import mynewteeth.backend.model.VatTu;

public class VatTuController {

    private List<VatTu> danhSachVatTu;

    public List<VatTu> getDanhSachVatTu() {
        return danhSachVatTu;
    }

    public VatTuController() {
        this.danhSachVatTu = new ArrayList<>();
    }

    public List<VatTu> getDanhSachVatTuSafe() {
        try {
            return getDanhSachVatTu();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void setDanhSachVatTu(List<VatTu> danhSachVatTu) {
        this.danhSachVatTu = danhSachVatTu;
    }

    public VatTuController(List<VatTu> danhSachVatTu) {
        this.danhSachVatTu = danhSachVatTu;
    }

    public void MaVatTuExists(String maVatTu) throws Exception {
        if (!maVatTu.matches("^VT\\d+$")) {
            throw new Exception("Mã vật tư không hợp lệ. Phải có định dạng 'VT' + số thứ tự mã.");
        }

        for (VatTu vt : danhSachVatTu) {
            if (vt.getMaVatTu().equals(maVatTu)) {
                throw new Exception("Mã vật tư đã tồn tại, vui lòng nhập lại.");
            }
        }
    }

    public boolean addVatTu(VatTu vatTu) {
        try {
            MaVatTuExists(vatTu.getMaVatTu());
            danhSachVatTu.add(vatTu);
            appendToFile(vatTu);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi thêm vật tư: " + e.getMessage());
            return false;
        }
    }

    public void appendToFile(VatTu vatTu) {
        String fileName = "src/mynewteeth/backend/data_repository/local_data/raw_data/VatTu.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngayNhapStr = sdf.format(vatTu.getNgayNhap());
            String line = vatTu.getMaVatTu() + "#"
                    + vatTu.getTenVatTu() + "#"
                    + vatTu.getLoai() + "#"
                    + vatTu.getTinhTrang() + "#"
                    + vatTu.getGiaNhap() + "#"
                    + ngayNhapStr + "#"
                    + vatTu.getSoLuong();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
    try {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("#");
            if (parts.length == 7) {
                String maVatTu = parts[0];
                String tenVatTu = parts[1];
                String loai = parts[2];
                String tinhTrang = parts[3];
                double giaNhap = Double.parseDouble(parts[4]); // Chuyển đổi từ String sang double
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date ngayNhap = sdf.parse(parts[5]);
                int soLuong = Integer.parseInt(parts[6]);
                VatTu vatTu = new VatTu(maVatTu, tenVatTu, loai, tinhTrang, giaNhap, ngayNhap, soLuong);
                danhSachVatTu.add(vatTu);
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
    } catch (ParseException e) {
        System.out.println("Parse exception: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Number format exception: " + e.getMessage());
    }
}



    private void updateFile() {
        String fileName = "src/mynewteeth/backend/data_repository/local_data/raw_data/VatTu.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (VatTu vatTu : danhSachVatTu) {
                String ngayNhapStr = sdf.format(vatTu.getNgayNhap());
                String line = vatTu.getMaVatTu() + "#"
                        + vatTu.getTenVatTu() + "#"
                        + vatTu.getLoai() + "#"
                        + vatTu.getTinhTrang() + "#"
                        + vatTu.getGiaNhap() + "#"
                        + ngayNhapStr + "#"
                        + vatTu.getSoLuong();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean removeVatTuByMa(String maVatTu) {
        boolean found = false;
        for (VatTu vt : danhSachVatTu) {
            if (vt.getMaVatTu().equals(maVatTu)) {
                danhSachVatTu.remove(vt);
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

    public boolean updateVatTu(VatTu updatedVatTu) {
        for (int i = 0; i < danhSachVatTu.size(); i++) {
            if (danhSachVatTu.get(i).getMaVatTu().equals(updatedVatTu.getMaVatTu())) {
                danhSachVatTu.set(i, updatedVatTu);
                updateFile();
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        VatTuController  hh = new VatTuController();
        hh.loadFromFile("src/mynewteeth/backend/data_repository/local_data/raw_data/VatTu.txt");
        
        for(VatTu vt : hh.getDanhSachVatTuSafe()){
            System.out.println(vt.toString());
        }
    }
}
