/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mynewteeth.backend.controller.BenhNhanController;
import mynewteeth.backend.controller.VatTuController;
import mynewteeth.backend.interfaces.IOptionDialogAction;
import mynewteeth.backend.interfaces.IUpdateData;
import mynewteeth.backend.model.VatTu;
import mynewteeth.frontend.DialogProvider;

/**
 *
 * @author Us
 */
public class TabVatTu {

    private final JTable vatTuTable;
    private final JTextField vatTuTextField;
    private final JTextField tenVatTuTextField;
    private final JTextField loaiVatTuTextField;
    private final JTextField tinhTrangVatTuTextField;
    private final JTextField giaNhapVatTuTextField;
    private final JTextField ngayNhapVatTuTextField;
    private final JTextField soLuongVatTuTextField;
    private final JButton themVTButton;
    private final JButton xoaVatTuButton;
    private final JButton capNhatVatTuButton;
    private final JButton timKiemVatTuButton;
    private IUpdateData callback;
    private VatTuController controller;

    public TabVatTu(JTable vatTuTable, JTextField vatTuTextField, JTextField tenVatTuTextField,
            JTextField loaiVatTuTextField, JTextField tinhTrangVatTuTextField, JTextField giaNhapVatTuTextField,
            JTextField ngayNhapVatTuTextField, JTextField soLuongVatTuTextField, JButton themVTButton,
            JButton xoaVatTuButton, JButton capNhatVatTuButton, JButton timKiemVatTuButton, IUpdateData updateCallback) {

        this.vatTuTable = vatTuTable;
        this.vatTuTextField = vatTuTextField;
        this.tenVatTuTextField = tenVatTuTextField;
        this.loaiVatTuTextField = loaiVatTuTextField;
        this.tinhTrangVatTuTextField = tinhTrangVatTuTextField;
        this.giaNhapVatTuTextField = giaNhapVatTuTextField;
        this.ngayNhapVatTuTextField = ngayNhapVatTuTextField;
        this.soLuongVatTuTextField = soLuongVatTuTextField;
        this.themVTButton = themVTButton;
        this.xoaVatTuButton = xoaVatTuButton;
        this.capNhatVatTuButton = capNhatVatTuButton;
        this.timKiemVatTuButton = timKiemVatTuButton;
        this.callback = updateCallback;
        controller = new VatTuController();
        controller.loadFromFile("src/mynewteeth/backend/data_repository/local_data/raw_data/VatTu.txt");
        bindData();
        handleTableBehavior();
        handAddingAction();
        handleDeletingAction();
        handleUpdatingAction();
        handleSearchingAction();
    }

    private void bindData() {
        // Lấy dữ liệu đã được load từ Controller lên rồi đổ vào UI
        List<VatTu> danhSachVatTu = controller.getDanhSachVatTuSafe();

        // Ví dụ: Giả sử mô hình của bảng là DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) vatTuTable.getModel();

        // Xóa dữ liệu cũ trong bảng (nếu có)
        model.setRowCount(0);

        // Thêm từng vật tư vào bảng
        for (VatTu vatTu : danhSachVatTu) {
            Object[] rowData = {
                vatTu.getMaVatTu(),
                vatTu.getTenVatTu(),
                vatTu.getLoai(),
                vatTu.getTinhTrang(),
                vatTu.getGiaNhap(),
                vatTu.getNgayNhap(),
                vatTu.getSoLuong()
            };
            model.addRow(rowData);
        }
    }

    private void handleTableBehavior() {
        // Xử lý sự kiện liên quan đến bảng : Khi click vào 1 ròng trên bảng => Lấy dữ liệu dòng đó đưa vào các text field
        vatTuTable.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = vatTuTable.getSelectedRow();
            if (selectedRow != -1) {
                vatTuTextField.setText((String) vatTuTable.getValueAt(selectedRow, 0));
                tenVatTuTextField.setText((String) vatTuTable.getValueAt(selectedRow, 1));
                loaiVatTuTextField.setText((String) vatTuTable.getValueAt(selectedRow, 2));
                tinhTrangVatTuTextField.setText((String) vatTuTable.getValueAt(selectedRow, 3));
                giaNhapVatTuTextField.setText(String.valueOf(vatTuTable.getValueAt(selectedRow, 4)));

                // Lấy giá trị Date và chuyển đổi thành String
                Date ngayNhapDate = (Date) vatTuTable.getValueAt(selectedRow, 5);
                String ngayNhapStr = new SimpleDateFormat("dd/MM/yyyy").format(ngayNhapDate);
                ngayNhapVatTuTextField.setText(ngayNhapStr);

                soLuongVatTuTextField.setText(String.valueOf(vatTuTable.getValueAt(selectedRow, 6)));
            }
        });
    }

    private void handAddingAction() {
        themVTButton.addActionListener((e) -> {
            System.out.println("Add a new item!");
            String maVT = vatTuTextField.getText();
            String tenVT = tenVatTuTextField.getText();
            String loai = loaiVatTuTextField.getText();
            String tinhTrang = tinhTrangVatTuTextField.getText();
            String giaNhapStr = giaNhapVatTuTextField.getText();
            String ngayNhapStr = ngayNhapVatTuTextField.getText();
            String soLuongStr = soLuongVatTuTextField.getText();

            // Kiểm tra tính hợp lệ của dữ liệu
            if (maVT.isEmpty() || tenVT.isEmpty() || loai.isEmpty() || tinhTrang.isEmpty() || giaNhapStr.isEmpty() || ngayNhapStr.isEmpty() || soLuongStr.isEmpty()) {
                DialogProvider.showMessageDialog("Vui lòng điền đầy đủ thông tin!", "Thông báo");
                return;
            }

            // Chuyển đổi chuỗi ngày nhập thành đối tượng Date
            Date ngayNhap;
            try {
                ngayNhap = new SimpleDateFormat("dd/MM/yyyy").parse(ngayNhapStr);
            } catch (ParseException ex) {
                DialogProvider.showMessageDialog("Ngày nhập không hợp lệ!", "Thông báo");
                return;
            }

            // Chuyển đổi chuỗi giá nhập và số lượng thành số
            double giaNhap;
            int soLuong;
            try {
                giaNhap = Double.parseDouble(giaNhapStr);
                soLuong = Integer.parseInt(soLuongStr);
            } catch (NumberFormatException ex) {
                DialogProvider.showMessageDialog("Giá nhập hoặc số lượng không hợp lệ!", "Thông báo");
                return;
            }

            // Tạo đối tượng Vật Tư mới
            VatTu newVatTu = new VatTu(maVT, tenVT, loai, tinhTrang, giaNhap, ngayNhap, soLuong);

            // Gửi dữ liệu đến lớp xử lý logic để thêm vật tư
            try {
                // Gửi dữ liệu đến lớp xử lý logic để thêm vật tư và ghi vào file
                boolean success = controller.addVatTu(newVatTu);

                if (success) {
                    // Cập nhật giao diện người dùng sau khi thêm vật tư thành công
                    DialogProvider.showMessageDialog("Thêm vật tư thành công!", "Thông báo");
                    // Clear các trường nhập liệu
                    vatTuTextField.setText("");
                    tenVatTuTextField.setText("");
                    loaiVatTuTextField.setText("");
                    tinhTrangVatTuTextField.setText("");
                    giaNhapVatTuTextField.setText("");
                    ngayNhapVatTuTextField.setText("");
                    soLuongVatTuTextField.setText("");
                    // Cập nhật dữ liệu cho bảng
                    bindData();
                    callback.onUpdate(newVatTu);
                } else {
                    DialogProvider.showMessageDialog("Có lỗi xảy ra khi thêm vật tư!", "Thông báo");
                }
            } catch (Exception ex) {
                DialogProvider.showMessageDialog("Có lỗi xảy ra khi thêm vật tư!", "Thông báo");
                ex.printStackTrace(); // In ra stack trace để xem lỗi là gì
            }
        });
    }

    private void handleDeletingAction() {
        xoaVatTuButton.addActionListener((e) -> {
            int selectedRow = vatTuTable.getSelectedRow();
            if (selectedRow == -1) {
                DialogProvider.showMessageDialog("Vui lòng chọn một vật tư để xóa!", "Thông báo");
                return;
            }

            String maVatTu = (String) vatTuTable.getValueAt(selectedRow, 0);

            DialogProvider.showConfirmDialog("Bạn chắc chắn muốn xóa vật tư này?", "Cảnh báo!", "Chiến", new IOptionDialogAction() {
                @Override
                public void onYesOption(Object object) {
                    // Xử lý logic xóa vật tư
                    boolean success = controller.removeVatTuByMa(maVatTu);

                    if (success) {
                        DialogProvider.showMessageDialog("Xóa vật tư thành công!", "Thông báo!");
                        // Cập nhật lại bảng
                        bindData();
                        callback.onUpdate(maVatTu);
                    } else {
                        DialogProvider.showMessageDialog("Có lỗi xảy ra, vui lòng thử lại!", "Thông báo");
                    }
                }

                @Override
                public void onNoOption() {
                    // Không làm gì cả khi người dùng chọn No
                }
            });
        });
    }

    private void handleUpdatingAction() {
        capNhatVatTuButton.addActionListener((e) -> {
            int selectedRow = vatTuTable.getSelectedRow();
            if (selectedRow == -1) {
                DialogProvider.showMessageDialog("Vui lòng chọn một vật tư để sửa!", "Thông báo");
                return;
            }
            String maVT = vatTuTextField.getText();
            String tenVT = tenVatTuTextField.getText();
            String loai = loaiVatTuTextField.getText();
            String tinhTrang = tinhTrangVatTuTextField.getText();
            String giaNhapStr = giaNhapVatTuTextField.getText();
            String ngayNhapStr = ngayNhapVatTuTextField.getText();
            String soLuongStr = soLuongVatTuTextField.getText();

            // Kiểm tra tính hợp lệ của dữ liệu
            if (maVT.isEmpty() || tenVT.isEmpty() || loai.isEmpty() || tinhTrang.isEmpty() || giaNhapStr.isEmpty() || ngayNhapStr.isEmpty() || soLuongStr.isEmpty()) {
                DialogProvider.showMessageDialog("Vui lòng điền đầy đủ thông tin!", "Thông báo");
                return;
            }

            // Chuyển đổi chuỗi ngày nhập thành đối tượng Date
            Date ngayNhap;
            try {
                ngayNhap = new SimpleDateFormat("dd/MM/yyyy").parse(ngayNhapStr);
            } catch (ParseException ex) {
                DialogProvider.showMessageDialog("Ngày nhập không hợp lệ!", "Thông báo");
                return;
            }

            // Chuyển đổi chuỗi giá nhập và số lượng thành số
            int soLuong;
            double giaNhap;
            try {
                giaNhap = Double.parseDouble(giaNhapStr);
                soLuong = Integer.parseInt(soLuongStr);
            } catch (NumberFormatException ex) {
                DialogProvider.showMessageDialog("Giá nhập hoặc số lượng không hợp lệ!", "Thông báo");
                return;
            }

            // Tạo đối tượng Vật Tư mới
            VatTu updatedVatTu = new VatTu(maVT, tenVT, loai, tinhTrang, giaNhap, ngayNhap, soLuong);

            // Gửi dữ liệu đến lớp xử lý logic để cập nhật vật tư
            boolean success = controller.updateVatTu(updatedVatTu);

            // Cập nhật giao diện người dùng sau khi sửa vật tư thành công
            if (success) {
                DialogProvider.showMessageDialog("Cập nhật vật tư thành công!", "Thông báo");
                // Cập nhật dữ liệu cho bảng
                bindData();
                callback.onUpdate(updatedVatTu);
            } else {
                DialogProvider.showMessageDialog("Có lỗi xảy ra, vui lòng thử lại!", "Thông báo");
            }
        });
    }

    private void handleSearchingAction() {
        timKiemVatTuButton.addActionListener((e) -> {
            String maVT = vatTuTextField.getText().trim();
            List<VatTu> danhSachVatTu = controller.getDanhSachVatTu();

            if (maVT.isEmpty()) {
                DialogProvider.showMessageDialog("Vui lòng nhập mã vật tư!", "Thông báo");
                return;
            }

            // Tìm vật tư theo mã
            VatTu foundVatTu = null;
            int rowIndex = -1;
            for (int i = 0; i < danhSachVatTu.size(); i++) {
                VatTu vatTu = danhSachVatTu.get(i);
                if (vatTu.getMaVatTu().equals(maVT)) {
                    foundVatTu = vatTu;
                    rowIndex = i;
                    break;
                }
            }

            if (foundVatTu != null) {
                // Hiển thị thông tin lên các trường văn bản
                tenVatTuTextField.setText(foundVatTu.getTenVatTu());
                loaiVatTuTextField.setText(foundVatTu.getLoai());
                tinhTrangVatTuTextField.setText(foundVatTu.getTinhTrang());
                giaNhapVatTuTextField.setText(String.valueOf(foundVatTu.getGiaNhap()));
                Date ngayNhap = foundVatTu.getNgayNhap();
                if (ngayNhap != null) {
                    ngayNhapVatTuTextField.setText(new SimpleDateFormat("dd/MM/yyyy").format(ngayNhap));
                } else {
                    ngayNhapVatTuTextField.setText("");
                }
                soLuongVatTuTextField.setText(String.valueOf(foundVatTu.getSoLuong()));

                // Chọn dòng tương ứng trong bảng
                vatTuTable.setRowSelectionInterval(rowIndex, rowIndex);
                vatTuTable.scrollRectToVisible(vatTuTable.getCellRect(rowIndex, 0, true));
            } else {
                DialogProvider.showMessageDialog("Không tìm thấy vật tư với mã này!", "Thông báo");
            }
        });
    }
//    private void handleDeletingAction() {
//        xoaVatTuButton.addActionListener((e) -> {
//            DialogProvider.showConfirmDialog("Bạn chắc chắn muốn xóa vật tư này ?", "Cảnh báo !", "Ma tóe", new IOptionDialogAction() {
//                @Override
//                public void onYesOption(Object object) {
//                    
//                    // Xử lý logic xóa Vật tư
//                    
//                    DialogProvider.showMessageDialog("Xóa vật tư : " + (String) object + " thành công !", "Thông báo !");
//                }
//
//                @Override
//                public void onNoOption() {
//                    
//                }
//            });
//        });
//    }
//    
//    private void handleUpdatingAction() {
//        capNhatVatTuButton.addActionListener((e) -> {
//            
//            // xử lý logic
//            
//            callback.onUpdate("Vật tư Drug1");
//        });
//    }

}