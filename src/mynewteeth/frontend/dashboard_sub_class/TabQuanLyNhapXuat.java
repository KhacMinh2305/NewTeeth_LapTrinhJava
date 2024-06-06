/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Us
 */
public class TabQuanLyNhapXuat {

    private final JTable nhapXuatTable;
    private final JTextField maDonTextField;
    private final JTextField ngayGDTextField;
    private final JTextField loaiGDTextField;
    private final JTextField nhaCCTextField;
    private final JTextField tongTienTextField;
    private final JTable vatPhamGDTable;
    private final JButton themNhapXuatButton;
    private final JButton xoaNhapXuatButton;
    private final JButton suaNhapXuatButton;

    public TabQuanLyNhapXuat(JTable nhapXuatTable, JTextField maDonTextField, JTextField ngayGDTextField,
            JTextField loaiGDTextField, JTextField nhaCCTextField, JTextField tongTienTextField,
            JTable vatPhamGDTable, JButton themNhapXuatButton, JButton xoaNhapXuatButton, JButton suaNhapXuatButton) {
        this.nhapXuatTable = nhapXuatTable;
        this.maDonTextField = maDonTextField;
        this.ngayGDTextField = ngayGDTextField;
        this.loaiGDTextField = loaiGDTextField;
        this.nhaCCTextField = nhaCCTextField;
        this.tongTienTextField = tongTienTextField;
        this.vatPhamGDTable = vatPhamGDTable;
        this.themNhapXuatButton = themNhapXuatButton;
        this.xoaNhapXuatButton = xoaNhapXuatButton;
        this.suaNhapXuatButton = suaNhapXuatButton;
    }

    public void updateData(Object updatedObject) {
        // Test - xóa đi khi làm
        if (updatedObject instanceof String) {
            System.out.println("Tab quản lý nhập xuất update data : " + updatedObject);
        }

        // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
    }
    
}
