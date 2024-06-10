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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        controller.loadFromFile();
        bindData();
        // handle action
        handAddingAction();
        handleTableBehavior();
        handleUpdatingAction();
        handSearchingAction();
        handRemovingAction();
    }

    // Lấy liệu đã được load từ Controller lên rồi đổ vào UI
    private void bindData() {
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

    //hiển thị thông tin vào các text khi chon 1 dòng trong table
    private void handleTableBehavior() {
        benhAnTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedIndex = benhAnTable.getSelectedRow();
            if (selectedIndex != -1) {
                for (HoSoBenhNhan f : controller.getDanhSachHoSoBenhNhan()) {
                    if (f.getMaHoSoBenhNhan().equals(benhAnTable.getValueAt(selectedIndex, 0).toString())) {
                        maBATextField.setText(f.getMaHoSoBenhNhan());
                        trieuChungTextField.setText(f.getTrieuChung());
                        chanDoanTextField.setText(f.getChuanDoanBanDau());
                        //tenBacSiTextField.setText(f.getBacSi().getHoTen());
                        maBacSiTextField.setText(f.getBacSi().getMaBacSi());
                        ghiChuTextField.setText(f.getGhiChuBacSi());
                        maBenhNhanTextField.setText(f.getBenhNhan().getMaBenhNhan());
                        //tenBNLabel.setText(f.getBenhNhan().getTenBenhNhan());
                        gioiTinhBNLabel.setText(f.getBenhNhan().getGioiTinh());
                        dienThoaiBNLabel.setText(f.getBenhNhan().getSoDienThoai());
                        tenBacSiTextField.setText(controller.findTenBacSiByMa(f.getBacSi().getMaBacSi()));
                        tenBNLabel.setText(controller.findTenBenhNhanByMaBenhNhan(f.getBenhNhan().getMaBenhNhan()));

                        // Format the date of birth
                        Date ngaySinh = f.getBenhNhan().getNgaySinh();
                        Date ngayTaiKham = f.getNgayTaiKham();
                        Date ngayKham = f.getNgayKham();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String fomattedNgayTaiKham = dateFormat.format(ngayTaiKham);
                        String formattedNgaySinh = dateFormat.format(ngaySinh);
                        String formattedNgayKham = dateFormat.format(ngayKham);
                        ngaySinhBNLabel.setText(formattedNgaySinh);
                        ngayTaiKhamTextField.setText(fomattedNgayTaiKham);
                        ngayKhamTextField.setText(formattedNgayKham);
                    }
                }
            }
        });
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

    //Tìm kiếm hồ sơ bệnh nhân theo mã hồ sơ bệnh nhân
    private void handSearchingAction() {
        timKiemBAButton.addActionListener(e -> {
            String maHoSoBenhNhan = maBATextField.getText().trim();
            HoSoBenhNhan hoSoBenhNhan = controller.findHoSoBenhNhanByMa(maHoSoBenhNhan);

            if (hoSoBenhNhan != null) {
                // Đổ thông tin hồ sơ bệnh nhân vào UI
                maBATextField.setText(hoSoBenhNhan.getMaHoSoBenhNhan());
                trieuChungTextField.setText(hoSoBenhNhan.getTrieuChung());
                chanDoanTextField.setText(hoSoBenhNhan.getChuanDoanBanDau());
                tenBacSiTextField.setText(hoSoBenhNhan.getBacSi().getHoTen());
                maBacSiTextField.setText(hoSoBenhNhan.getBacSi().getMaBacSi());
                ghiChuTextField.setText(hoSoBenhNhan.getGhiChuBacSi());
                maBenhNhanTextField.setText(hoSoBenhNhan.getBenhNhan().getMaBenhNhan());
                tenBNLabel.setText(hoSoBenhNhan.getBenhNhan().getTenBenhNhan());
                gioiTinhBNLabel.setText(hoSoBenhNhan.getBenhNhan().getGioiTinh());
                dienThoaiBNLabel.setText(hoSoBenhNhan.getBenhNhan().getSoDienThoai());

                // Chọn dòng có mã hồ sơ bệnh nhân trong bảng
                DefaultTableModel model = (DefaultTableModel) benhAnTable.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(maHoSoBenhNhan)) {
                        benhAnTable.setRowSelectionInterval(i, i);
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy hồ sơ bệnh nhân với mã: " + maHoSoBenhNhan);
            }
        });
    }

    private void resetTextField() {
        maBATextField.setText("");
        trieuChungTextField.setText("");
        chanDoanTextField.setText("");
        maBacSiTextField.setText("");
        ghiChuTextField.setText("");
        maBenhNhanTextField.setText("");
        gioiTinhBNLabel.setText("");
        dienThoaiBNLabel.setText("");
        tenBacSiTextField.setText("");
        tenBNLabel.setText("");
        ngaySinhBNLabel.setText("");
        ngayTaiKhamTextField.setText("");
        ngayKhamTextField.setText("");
    }

    //thêm hồ sơ bệnh nhân 
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
                BacSi newBS = controller.getBacSiController().findBacSiByMa(maBacSi);
                BenhNhan newBN = controller.getBenhNhanController().findBenhNhanByMa(maBenhNhan);
                List<VatTu> newVT = controller.getVaTuConTroller().getDanhSachVatTu();
                if (maHoSoBenhNhan.isEmpty() || ngayKham.isEmpty() || trieuChung.isEmpty() || chanDoan.isEmpty() || maBacSi.isEmpty() || ngayTaiKham.isEmpty() || maBenhNhan.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
                    return; // Dừng lại nếu có thông tin bị thiếu
                }
                // Tìm tên Bệnh Nhân dựa vào mã Bệnh Nhân
                String tenBenhNhan = controller.findTenBenhNhanByMaBenhNhan(maBenhNhan);

                controller.themBenhNhan(maHoSoBenhNhan, ngayKham, trieuChung, chanDoan, maBacSi, maBacSi, ghiChu, ngayTaiKham, maBenhNhan);

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

    private void updateBenhAnTable(String maHoSoBenhNhan, String tenBenhNhan, String ngayKham, String tenBacSi) {
        DefaultTableModel model = (DefaultTableModel) benhAnTable.getModel();
        // Tìm dòng cần cập nhật
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(maHoSoBenhNhan)) {
                // Cập nhật thông tin cho dòng tương ứng trong bảng
                model.setValueAt(tenBenhNhan, i, 1); // Tên bệnh nhân
                model.setValueAt(ngayKham, i, 2); // Ngày khám
                model.setValueAt(tenBacSi, i, 3); // Tên bác sĩ
                break;
            }
        }
    }
    
    //sửa hồ sơ bệnh nhân theo mã hồ sơ 
    private void handleUpdatingAction() {
        capNhatBAButton.addActionListener(e -> {
            String maHoSoBenhNhan = maBATextField.getText();
            String ngayKham = ngayKhamTextField.getText();
            String trieuChung = trieuChungTextField.getText();
            String chanDoan = chanDoanTextField.getText();
            String maBacSi = maBacSiTextField.getText();
            String ghiChu = ghiChuTextField.getText();
            String ngayTaiKham = ngayTaiKhamTextField.getText();
            String maBenhNhan = maBenhNhanTextField.getText();

            if (maHoSoBenhNhan.isEmpty() || ngayKham.isEmpty() || trieuChung.isEmpty() || chanDoan.isEmpty() || maBacSi.isEmpty() || ngayTaiKham.isEmpty() || maBenhNhan.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
                return;
            }
            controller.suaHoSoBenhNhan(maHoSoBenhNhan, ngayKham, trieuChung, chanDoan, maBacSi, ghiChu, ngayTaiKham, maBenhNhan);
            bindData();
            tenBacSiTextField.setText(controller.findTenBacSiByMa(maBacSi));
            tenBNLabel.setText(controller.findTenBenhNhanByMaBenhNhan(maBenhNhan));
            updateBenhAnTable(maHoSoBenhNhan, controller.findTenBenhNhanByMaBenhNhan(maBenhNhan), ngayKham, controller.findTenBacSiByMa(maBacSi));
        });
    }

    //Xóa hồ sơ bệnh nhân đã chọn trong bảng
    private void handRemovingAction() {
        xoaBAButton.addActionListener(e -> {
            int selectedIndex = benhAnTable.getSelectedRow();
            if (selectedIndex != -1) {
                String maHoSoBenhNhan = benhAnTable.getValueAt(selectedIndex, 0).toString(); // Lấy mã hồ sơ bệnh nhân từ dòng được chọn

                // Xác nhận việc xóa
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa hồ sơ bệnh nhân với mã: " + maHoSoBenhNhan + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Xóa hồ sơ bệnh nhân trong danh sách trong controller
                    boolean found = controller.removeHoSoBenhNhanByMa(maHoSoBenhNhan);
                    if (found) {
                        // Cập nhật file lưu trữ
                        controller.SaveToFile();

                        // Cập nhật bảng
                        DefaultTableModel model = (DefaultTableModel) benhAnTable.getModel();
                        model.removeRow(selectedIndex);

                        JOptionPane.showMessageDialog(null, "Xóa bệnh án thành công!");
                        
                        //cập nhật textfield
                        resetTextField();
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy hồ sơ bệnh nhân với mã: " + maHoSoBenhNhan);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một hồ sơ bệnh nhân để xóa.");
            }
        });
    }
}
