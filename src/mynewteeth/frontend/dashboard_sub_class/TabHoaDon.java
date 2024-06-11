/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mynewteeth.backend.controller.HoaDonController;
import mynewteeth.backend.model.BenhNhan;
import mynewteeth.backend.model.HoaDon;
import mynewteeth.backend.model.VatTu;

/**
 *
 * @author Us
 */
public class TabHoaDon {

    private final JTable hoaDonTable;
    private final JTextField soHDTextField;
    private final JTextField ngayKhamHDTextField;
    private final JLabel khachHangHoaDonLabel;
    private final JLabel maKHLabel;
    private final JComboBox<String> dichVuComboBox;
    private final JTable dichVuTable;
    private final JComboBox<String> thuocHDComboBox;
    private final JTable thuocHDTable;
    private final JLabel thanhTienLabel;
    private final JButton themHDButton;
    private final JButton capNhatHDButton;
    private final JButton xoaHDButton;
    private final JButton timKiemHDButton;
    private final JButton sapXepTenButton;
    private final JButton sapXepTienButton;
    private HoaDonController controller;

    public TabHoaDon(JTable hoaDonTable, JTextField soHDTextField, JTextField ngayKhamHDTextField,
            JLabel khachHangHoaDonLabel, JLabel maKHLabel, JComboBox<String> dichVuComboBox,
            JTable dichVuTable, JComboBox<String> thuocHDComboBox, JTable thuocHDTable,
            JLabel thanhTienLabel, JButton themHDButton, JButton capNhatHDButton, JButton xoaHDButton,
            JButton timKiemHDButton, JButton sapXepTenButton, JButton sapXepTienButton) {

        this.hoaDonTable = hoaDonTable;
        this.soHDTextField = soHDTextField;
        this.ngayKhamHDTextField = ngayKhamHDTextField;
        this.khachHangHoaDonLabel = khachHangHoaDonLabel;
        this.maKHLabel = maKHLabel;
        this.dichVuComboBox = dichVuComboBox;
        this.dichVuTable = dichVuTable;
        this.thuocHDComboBox = thuocHDComboBox;
        this.thuocHDTable = thuocHDTable;
        this.thanhTienLabel = thanhTienLabel;
        this.themHDButton = themHDButton;
        this.capNhatHDButton = capNhatHDButton;
        this.xoaHDButton = xoaHDButton;
        this.timKiemHDButton = timKiemHDButton;
        this.sapXepTenButton = sapXepTenButton;
        this.sapXepTienButton = sapXepTienButton;
        //add a Controller
        controller = new HoaDonController();
        controller.loadFromFile("src/mynewteeth/backend/data_repository/local_data/raw_data/HoaDon.txt");
//        bindData();
        // handle action
//        handleTableBehavior();
//        handAddingAction();
//        handleDeletingAction();
//        handleUpdatingAction();
//        handleSearchingAction();
    }

//    private void bindData() {
//        // Lấy liệu đã được load từ Controller lên rồi đổ vào UI
//        List<HoaDon> danhSachHoaDon = controller.getDanhSachHoaDon();
//
//        // Ví dụ: Giả sử mô hình của bảng là DefaultTableModel
//        DefaultTableModel model = (DefaultTableModel) hoaDonTable.getModel();
//        DefaultTableModel model1 = (DefaultTableModel) dichVuTable.getModel();
//        DefaultTableModel model2 = (DefaultTableModel) thuocHDTable.getModel();
//
//        // Xóa dữ liệu cũ trong bảng (nếu có)
//        model.setRowCount(0);
//
//        // Thêm từng hóa đơn vào bảng
//        for (HoaDon hoaDon : danhSachHoaDon) {
//            Object[] rowData = {
//                hoaDon.getSoHoaDon(),
//                hoaDon.getNgayKham(),
//                hoaDon.getBenhNhan().getTenBenhNhan(),
//                hoaDon.getTongTien()
//            };
//            model.addRow(rowData);
//        }
////        for (VatTu vt : controller.getVaTuConTroller().getDanhSachVatTu()) {
////            Object[] rowData = {
////                vt.getMaVatTu(),
////                vt.getTenVatTu(),
////                vt.getLoai(),
////                vt.getSoLuong(),
////                vt.getGiaTien()
////            };
////            model1.addRow(rowData);
////        }
//    }
//
    public void updateData(Object updatedObject) {
        // Test - xóa đi khi làm
        if (updatedObject instanceof String) {
            System.out.println("Tab hóa đơn update data : " + updatedObject);
            return;
        }

        if (updatedObject instanceof BenhNhan) {

            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
        } else { // Vat tu

            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
        }
    }
}
