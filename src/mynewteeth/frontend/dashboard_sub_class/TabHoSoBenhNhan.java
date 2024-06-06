/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import mynewteeth.backend.model.BacSi;
import mynewteeth.backend.model.BenhNhan;

/**
 *
 * @author Us
 */
public class TabHoSoBenhNhan {

    private JTextField maBATextField;
    private JTextField tenBATextField;
    private JTextField trieuChungTextField;
    private JTextField chanDoanTextField;
    private JTextField tenBacSiTextField;
    private JTextField maBacSiTextField;
    private JTextField ghiChuTextField;
    private JTextField ngayTaiKhamTextField;
    private JTable thuocKeDonTable;
    private JTable benhAnTable;
    private JButton timKiemBAButton;
    private JButton capNhatBAButton;
    private JButton xoaBAButton;
    private JButton themBAButton;

    public TabHoSoBenhNhan(JTextField maBATextField, JTextField tenBATextField, JTextField trieuChungTextField,
            JTextField chanDoanTextField, JTextField tenBacSiTextField, JTextField maBacSiTextField, JTextField ghiChuTextField,
            JTextField ngayTaiKhamTextField, JTable thuocKeDonTable, JTable benhAnTable, JButton timKiemBAButton,
            JButton capNhatBAButton, JButton xoaBAButton, JButton themBAButton) {

        this.maBATextField = maBATextField;
        this.tenBATextField = tenBATextField;
        this.trieuChungTextField = trieuChungTextField;
        this.chanDoanTextField = chanDoanTextField;
        this.tenBacSiTextField = tenBacSiTextField;
        this.maBacSiTextField = maBacSiTextField;
        this.ghiChuTextField = ghiChuTextField;
        this.ngayTaiKhamTextField = ngayTaiKhamTextField;
        this.thuocKeDonTable = thuocKeDonTable;
        this.benhAnTable = benhAnTable;
        this.timKiemBAButton = timKiemBAButton;
        this.capNhatBAButton = capNhatBAButton;
        this.xoaBAButton = xoaBAButton;
        this.themBAButton = themBAButton;
    }

    // Viết các hàm xử lý dữ liệu và xử lý sự kiện 
    
    
    // Hàm cập nhật dữ liệu từ các Tab khác - KHÔNG ĐƯỢC XÓA 
    public void updateData(Object updatedObject) {
        // Test - xóa đi khi làm
        if(updatedObject instanceof String) {
            System.out.println("Tab hồ sơ bệnh nhân update data : " + updatedObject);
            return;
        }
        
        if(updatedObject instanceof BenhNhan) {
            
            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
            
        } else if(updatedObject instanceof BacSi) {
            
            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
            
        } else { // Vat tu
            
            // Viết logic cập nhật UI với dữ liệu vừa được thay đổi 
            
        }
    }
}
