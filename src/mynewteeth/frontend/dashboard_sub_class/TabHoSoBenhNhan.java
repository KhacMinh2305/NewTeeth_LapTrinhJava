/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mynewteeth.backend.controller.HoSoBenhNhanController;
import mynewteeth.backend.model.BacSi;
import mynewteeth.backend.model.BenhNhan;
import mynewteeth.backend.model.HoSoBenhNhan;
import mynewteeth.backend.model.VatTu;

/**
 *
 * @author Us
 */
public class TabHoSoBenhNhan {

    private JTextField maBATextField;
    private JTextField ngayKhamTextField;
    private JTextField trieuChungTextField;
    private JTextField chanDoanTextField;
    private JTextField tenBacSiTextField;
    private JTextField maBacSiTextField;
    private JTextField ghiChuTextField;
    private JTextField ngayTaiKhamTextField;
    private JTextField maBenhNhanTextField;
    private JLabel tenBNLabel;
    private JLabel gioiTinhBNLabel;
    private JLabel ngaySinhBNLabel;
    private JLabel dienThoaiBNLabel;
    private JTable thuocKeDonTable;
    private JTable benhAnTable;
    private JButton timKiemBAButton;
    private JButton capNhatBAButton;
    private JButton xoaBAButton;
    private JButton themBAButton;
    private HoSoBenhNhanController controller;

    public TabHoSoBenhNhan(JTextField maBATextField, JTextField ngayKhamTextField, JTextField trieuChungTextField, JTextField chanDoanTextField, JTextField tenBacSiTextField, JTextField maBacSiTextField, JTextField ghiChuTextField, JTextField ngayTaiKhamTextField, JTextField maBenhNhanTextField, JLabel tenBNLabel, JLabel gioiTinhBNLabel, JLabel ngaySinhBNLabel, JLabel dienThoaiBNLabel, JTable thuocKeDonTable, JTable benhAnTable, JButton timKiemBAButton, JButton capNhatBAButton, JButton xoaBAButton, JButton themBAButton) {
        this.maBATextField = maBATextField;
        this.ngayKhamTextField = ngayKhamTextField;
        this.trieuChungTextField = trieuChungTextField;
        this.chanDoanTextField = chanDoanTextField;
        this.tenBacSiTextField = tenBacSiTextField;
        this.maBacSiTextField = maBacSiTextField;
        this.ghiChuTextField = ghiChuTextField;
        this.ngayTaiKhamTextField = ngayTaiKhamTextField;
        this.maBenhNhanTextField = maBenhNhanTextField;
        this.tenBNLabel = tenBNLabel;
        this.gioiTinhBNLabel = gioiTinhBNLabel;
        this.ngaySinhBNLabel = ngaySinhBNLabel;
        this.dienThoaiBNLabel = dienThoaiBNLabel;
        this.thuocKeDonTable = thuocKeDonTable;
        this.benhAnTable = benhAnTable;
        this.timKiemBAButton = timKiemBAButton;
        this.capNhatBAButton = capNhatBAButton;
        this.xoaBAButton = xoaBAButton;
        this.themBAButton = themBAButton;
        controller = new HoSoBenhNhanController();
        controller.loadFromFile("src/mynewteeth/backend/data_repository/local_data/raw_data/HoSoBenhNhan.txt");
        bindData();
        // handle action
        handAddingAction();

    }

    private void bindData() {
        // Lấy liệu đã được load từ Controller lên rồi đổ vào UI
        List<HoSoBenhNhan> hsbn = controller.getDanhSachHoSoBenhNhan();

        DefaultTableModel model = (DefaultTableModel) benhAnTable.getModel();
        DefaultTableModel model1 = (DefaultTableModel) thuocKeDonTable.getModel();
        
        // Xóa dữ liệu cũ trong bảng (nếu có)
        model.setRowCount(0);
        model1.setRowCount(0);
        // Thêm từng bệnh nhân vào bảng
        for (HoSoBenhNhan hs : hsbn) {
            Object[] rowData = {
                hs.getMaHoSoBenhNhan(),
                hs.getBenhNhan().getTenBenhNhan(),
                hs.getNgayKham(),
                hs.getBacSi().getHoTen()
            };
            model.addRow(rowData);
        }
        for (VatTu xx : controller.getVaTuConTroller().getDanhSachVatTu()) {
            Object[] rowData = {
                xx.getMaVatTu(),
                xx.getTenVatTu(),
                xx.getLoai(),
                xx.getSoLuong(),
                xx.getGiaTien()
            };
            model1.addRow(rowData);
        }
        
    }

    // Viết các hàm xử lý dữ liệu và xử lý sự kiện 
    // Hàm cập nhật dữ liệu từ các Tab khác - KHÔNG ĐƯỢC XÓA 
    public void updateData(Object updatedObject) {
        // Test - xóa đi khi làm
        if (updatedObject instanceof String) {
            System.out.println("Tab hồ sơ bệnh nhân update data : " + updatedObject);
            return;
        }

        if (updatedObject instanceof BenhNhan) {

            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
        } else if (updatedObject instanceof BacSi) {

            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
        } else { // Vat tu

            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
        }
    }

    private void handAddingAction() {
        themBAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maHoSoBenhNhan = maBATextField.getText();
                String ngayKham = ngayKhamTextField.getText();
                String trieuChung = trieuChungTextField.getText();
                String chanDoan = chanDoanTextField.getText();
                //String tenBacSi = tenBacSiTextField.getText();
                String maBacSi = maBacSiTextField.getText();
                String ghiChu = ghiChuTextField.getText();
                String ngayTaiKham = ngayTaiKhamTextField.getText();
                String maBenhNhan = maBenhNhanTextField.getText();

                if (maHoSoBenhNhan.isEmpty() || ngayKham.isEmpty() || trieuChung.isEmpty() || chanDoan.isEmpty() || maBacSi.isEmpty() || ngayTaiKham.isEmpty() || maBenhNhan.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
                    return; // Dừng lại nếu có thông tin bị thiếu
                }
                // Tìm tên Bệnh Nhân dựa vào mã Bệnh Nhân
                String tenBenhNhan = controller.findTenBenhNhanByMaBenhNhan(maBenhNhan);

                // Tìm Tên Bác Sỹ Dựa vào mã Bác Sỹ
                String tenBacSi = controller.findTenBacSiByMa(maBacSi);
                boolean valid = controller.saveToHoSoBenhNhanFile(maHoSoBenhNhan, ngayKham, trieuChung, chanDoan, tenBacSi, maBacSi, ghiChu, ngayTaiKham, maBenhNhan);
                if (valid) {
                    // Thêm thông tin vào bảng benhAnTable
                    DefaultTableModel model = (DefaultTableModel) benhAnTable.getModel();
                    model.addRow(new Object[]{maHoSoBenhNhan, tenBenhNhan, ngayKham, tenBacSi});

                    // Lưu thông tin vào file HoSoBenhNhan.txt
                    // Hiển thị thông báo khi thêm thành công
                    JOptionPane.showMessageDialog(null, "Thêm bệnh án thành công!");
                }
            }
        });
    }

}
