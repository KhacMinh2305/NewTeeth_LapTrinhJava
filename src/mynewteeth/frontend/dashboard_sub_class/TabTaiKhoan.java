/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import mynewteeth.backend.interfaces.ILogout;
import mynewteeth.backend.interfaces.IOptionDialogAction;
import mynewteeth.frontend.DialogProvider;

/**
 *
 * @author Us
 */
public class TabTaiKhoan {
    
    private final JTable taiKhoanTable;
    private final JTextField taiKhoanTextField;
    private final JTextField matKhauTextField;
    private final JTextField ngayTaoTextField;
    private final JButton doiMKButton;
    private final JButton chanTKButton;
    private final JButton xoaTKButton;
    private final JButton dangXuatButton;
    private final ILogout callback;

    public TabTaiKhoan(JTable taiKhoanTable, JTextField tiaKhoanTextField, JTextField matKhauTextField, 
            JTextField ngayTaoTextField, JButton doiMKButton, JButton chanTKButton, JButton xoaTKButton, JButton dangXuatButton, ILogout callback) {
        
        this.taiKhoanTable = taiKhoanTable;
        this.taiKhoanTextField = tiaKhoanTextField;
        this.matKhauTextField = matKhauTextField;
        this.ngayTaoTextField = ngayTaoTextField;
        this.doiMKButton = doiMKButton;
        this.chanTKButton = chanTKButton;
        this.xoaTKButton = xoaTKButton;
        this.dangXuatButton = dangXuatButton;
        this.callback = callback;
        
        handleLogoutButton();
    }
    
    private void handleLogoutButton() {
        dangXuatButton.addActionListener((e) -> {
            DialogProvider.showConfirmDialog("Đăng xuất khỏi thiết bị này ?", "Cảnh báo !", null, new IOptionDialogAction() {
                @Override
                public void onYesOption(Object object) {
                    callback.logout();
                }

                @Override
                public void onNoOption() {
                    
                }
            });
        });
    }
}
