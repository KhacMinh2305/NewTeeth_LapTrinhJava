/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import mynewteeth.backend.interfaces.IOptionDialogAction;
import mynewteeth.backend.interfaces.IUpdateData;
import mynewteeth.frontend.DialogProvider;

/**
 *
 * @author Us
 */
public class TabBacSi {

    private final JTable bacSiTable;
    private final JTextField maBSTextField;
    private final JTextField tenBSTextField;
    private final JTextField ngaySinhBSTextField;
    private final JTextField gioiTinhBSTextField;
    private final JTextField queQuanBSTextField;
    private final JTextField soDTTextField;
    private final JTextField chuyenMonTextField;
    private final JTextField chucVuTextField;
    private final JTextField luongThangTextField;
    private final JButton timKiemBtn;
    private final JButton sapXepTenBtn;
    private final JButton sapXepLuong;
    private final JButton themBacSiButton;
    private final JButton capNhatBSButton;
    private final JButton xoaBacSiButton;
    private final JLabel anhBacSiLabel;
    private IUpdateData callback;

    public TabBacSi(JTable bacSiTable, JTextField maBSTextField, JTextField tenBSTextField,
            JTextField ngaySinhBSTextField, JTextField gioiTinhBSTextField, JTextField queQuanBSTextField,
            JTextField soDTTextField, JTextField chuyenMonTextField, JTextField chucVuTextField,
            JTextField luongThangTextField, JButton timKiemBtn, JButton sapXepTenBtn, JButton sapXepLuong,
            JButton themBacSiButton, JButton capNhatBSButton, JButton xoaBacSiButton, JLabel anhBacSiLabel, IUpdateData updateDataCallback) {
        
        this.bacSiTable = bacSiTable;
        this.maBSTextField = maBSTextField;
        this.tenBSTextField = tenBSTextField;
        this.ngaySinhBSTextField = ngaySinhBSTextField;
        this.gioiTinhBSTextField = gioiTinhBSTextField;
        this.queQuanBSTextField = queQuanBSTextField;
        this.soDTTextField = soDTTextField;
        this.chuyenMonTextField = chuyenMonTextField;
        this.chucVuTextField = chucVuTextField;
        this.luongThangTextField = luongThangTextField;
        this.timKiemBtn = timKiemBtn;
        this.sapXepTenBtn = sapXepTenBtn;
        this.sapXepLuong = sapXepLuong;
        this.themBacSiButton = themBacSiButton;
        this.capNhatBSButton = capNhatBSButton;
        this.xoaBacSiButton = xoaBacSiButton;
        this.anhBacSiLabel = anhBacSiLabel;
        callback = updateDataCallback;
        
        handleDeletingAction();
        handleUpdatingAction();
    }

    // xử lý logic , load dữ liệu tương tự
    // Ai làm để ý cả cái label ảnh bác sĩ kia, k có bị sót 
    
    
    private void handleDeletingAction() {
        xoaBacSiButton.addActionListener((e) -> {
            DialogProvider.showConfirmDialog("Bạn chắc chắn muốn xóa bác sĩ này ?", "Cảnh báo !", "Hải", new IOptionDialogAction() {
                @Override
                public void onYesOption(Object object) {
                    
                    // Xử lý logic xóa bác sĩ
                    
                    DialogProvider.showMessageDialog("Xóa bác sĩ : " + (String) object + " thành công !", "Thông báo !");
                }

                @Override
                public void onNoOption() {
                    
                }
            });
        });
    }
    
    private void handleUpdatingAction() {
        capNhatBSButton.addActionListener((e) -> {
            
            // Xử lý logic cập nhật bác sĩ
            
            // Cập nhật thông tin bác sĩ mới cho các tab khác nếu thỏa mãn -  KHÔNG ĐƯỢC XÓA !
            callback.onUpdate("Bác sĩ Doctor1"); // Thay "Bác sĩ Doctor1" bằng đối tượng được thay đổi dữ liệu
            
        });
    }

}
