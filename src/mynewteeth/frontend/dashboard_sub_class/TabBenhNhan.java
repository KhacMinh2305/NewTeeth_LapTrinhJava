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
public class TabBenhNhan {

    private final JTable benhNhanTable;
    private final JTextField maBNTextField;
    private final JTextField tenBNTextField;
    private final JTextField ngaySinhBNTextField;
    private final JTextField dienThoaiBNTextField;
    private final JTextField queQuanBNTextField;
    private final JTextField gioiTinhBnTextField;
    private final JButton themBNButton, xoaBNButton, suaBNButton, timKiemButton;
    private IUpdateData callback;
 
    public TabBenhNhan(JTable benhNhanTable, JTextField maBNTextField, JTextField tenBNTextField,
            JTextField ngaySinhBNTextField, JTextField dienThoaiBNTextField, JTextField queQuanBNTextField, JTextField gioiTinhBnTextField,
            JButton themBNButton, JButton xoaBNButton, JButton suaBNButton, JButton timKiemButton, IUpdateData updateDataCallback) {
        this.benhNhanTable = benhNhanTable;
        this.maBNTextField = maBNTextField;
        this.tenBNTextField = tenBNTextField;
        this.ngaySinhBNTextField = ngaySinhBNTextField;
        this.dienThoaiBNTextField = dienThoaiBNTextField;
        this.queQuanBNTextField = queQuanBNTextField;
        this.gioiTinhBnTextField = gioiTinhBnTextField;
        this.themBNButton = themBNButton;
        this.xoaBNButton = xoaBNButton;
        this.suaBNButton = suaBNButton;
        this.timKiemButton = timKiemButton;
        callback = updateDataCallback;
        // add Controller here
        bindData();
        // handle action
        handleTableBehavior();
        handAddingAction();
        handleDeletingAction();
        handleUpdatingAction();
        handleSearchingAction();
    }

    private void bindData() {
        // Lấy liệu đã được load từ Controller lên rồi đổ vào UI
    }
    
    private void handleTableBehavior() {
        // Xử lý sự kiện liên quan đến bảng : Khi click vào 1 ròng trên bảng => Lấy dữ liệu dòng đó đưa vào các text field
    }

    private void handAddingAction() {
        themBNButton.addActionListener((e) -> {
            System.out.println("Add a new patient !");
        });
    }

    private void handleDeletingAction() {
        xoaBNButton.addActionListener((e) -> {
            DialogProvider.showConfirmDialog("Bạn chắc chắn muốn xóa bệnh nhân này ?", "Cảnh báo !", "Chiến", new IOptionDialogAction() {
                @Override
                public void onYesOption(Object object) {
                    
                    // Xử lý logic xóa bệnh nhân
                    
                    DialogProvider.showMessageDialog("Xóa bệnh nhân : " + (String) object + " thành công !", "Thông báo !");
                }

                @Override
                public void onNoOption() {
                    
                }
            });
        });
    }

    private void handleUpdatingAction() {
        suaBNButton.addActionListener((e) -> {
            
            // xử lý logic cập nhật bệnh nhân 
            
            // Cập nhật thông tin bệnh nhân mới cho các tab khác nếu thỏa mãn -  KHÔNG ĐƯỢC XÓA !
            callback.onUpdate("Bệnh nhân Patient1"); // Thay "" bằng đối tượng được thay đổi dữ liệu
        });
        
        
    }

    private void handleSearchingAction() {
        timKiemButton.addActionListener((e) -> {
            System.out.println("Search patient !"); // Test ! Bỏ khi làm
        });
    }
}
