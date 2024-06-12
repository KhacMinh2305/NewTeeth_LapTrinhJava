/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import mynewteeth.backend.model.BenhNhan;

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
    }
    
    public void updateData(Object updatedObject) {
        // Test - xóa đi khi làm
        if(updatedObject instanceof String) {
            System.out.println("Tab hóa đơn update data : " + updatedObject);
            return;
        }
        
        if(updatedObject instanceof BenhNhan) {
            
            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
            
        } else { // Vat tu
            
            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
            
        }
    }
}
