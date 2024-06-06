/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth.frontend;

import javax.swing.JOptionPane;
import mynewteeth.backend.interfaces.IOptionDialogAction;

/**
 *
 * @author Us
 */
public class DialogProvider {
    
    public static void showConfirmDialog(String message, String cationFrameTitle, Object deletedObject, IOptionDialogAction callback) { // pass data if need
        new Thread(() -> {
            int result = JOptionPane.showConfirmDialog(null,
                message,
                cationFrameTitle,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {
                callback.onYesOption(deletedObject);
            } else {
                callback.onNoOption();
            }
        }).start();
    }
    
    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
