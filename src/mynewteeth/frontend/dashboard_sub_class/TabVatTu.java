/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend.dashboard_sub_class;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import mynewteeth.backend.interfaces.IOptionDialogAction;
import mynewteeth.backend.interfaces.IUpdateData;
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
        
        handleUpdatingAction();
        handleDeletingAction();
    }
    
    private void handleDeletingAction() {
        xoaVatTuButton.addActionListener((e) -> {
            DialogProvider.showConfirmDialog("Bạn chắc chắn muốn xóa vật tư này ?", "Cảnh báo !", "Ma tóe", new IOptionDialogAction() {
                @Override
                public void onYesOption(Object object) {
                    
                    // Xử lý logic xóa Vật tư
                    
                    DialogProvider.showMessageDialog("Xóa vật tư : " + (String) object + " thành công !", "Thông báo !");
                }

                @Override
                public void onNoOption() {
                    
                }
            });
        });
    }
    
    private void handleUpdatingAction() {
        capNhatVatTuButton.addActionListener((e) -> {
            
            // xử lý logic
            
            callback.onUpdate("Vật tư Drug1");
        });
    }

}
