/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mynewteeth.backend.model.BacSi;
import mynewteeth.backend.model.BenhNhan;

/**
 *
 * @author Us
 */
public class TabLichHen {

    private final JTable lichHenTable;
    private final JTextField maLichHenTextField;
    private final JTextField maBNHenTextField;
    private final JTextField tenBNHenTextField;
    private final JTextField sdtHenTextField;
    private final JTextField ngayHenTextField;
    private final JTextField tenBSHenTextField;
    private final JTextField maBSHenTetxField;
    private final JComboBox<String> dichVuHenComboBox;
    private final JTable dichVuHenTable;
    private final JTextArea ghiChuHenTextField;
    private final JButton themLichHenButton;
    private final JButton xoaLichHenButton;
    private final JButton capNhatLichHenButton;
    private final JButton timKiemLichHenButton;

    public TabLichHen(JTable lichHenTable, JTextField maLichHenTextField, JTextField maBNHenTextField,
            JTextField tenBNHenTextField, JTextField sdtHenTextField, JTextField ngayHenTextField,
            JTextField tenBSHenTextField, JTextField maBSHenTetxField, JComboBox<String> dichVuHenComboBox,
            JTable dichVuHenTable, JTextArea ghiChuHenTextField, JButton themLichHenButton, JButton xoaLichHenButton,
            JButton capNhatLichHenButton, JButton timKiemLichHenButton) {

        this.lichHenTable = lichHenTable;
        this.maLichHenTextField = maLichHenTextField;
        this.maBNHenTextField = maBNHenTextField;
        this.tenBNHenTextField = tenBNHenTextField;
        this.sdtHenTextField = sdtHenTextField;
        this.ngayHenTextField = ngayHenTextField;
        this.tenBSHenTextField = tenBSHenTextField;
        this.maBSHenTetxField = maBSHenTetxField;
        this.dichVuHenComboBox = dichVuHenComboBox;
        this.dichVuHenTable = dichVuHenTable;
        this.ghiChuHenTextField = ghiChuHenTextField;
        this.themLichHenButton = themLichHenButton;
        this.xoaLichHenButton = xoaLichHenButton;
        this.capNhatLichHenButton = capNhatLichHenButton;
        this.timKiemLichHenButton = timKiemLichHenButton;
    }
    
    public void updateData(Object updatedObject) {
        if(updatedObject instanceof String) {
            System.out.println("Tab lịch hẹn update data : " + updatedObject);
            return;
        }
        
        if(updatedObject instanceof BenhNhan) {
            // dữ liệu thay đôi là bệnh nhân 
        } else {
            // dữ liệu thay đôi là Bác sĩ
        }
    }
    
}
