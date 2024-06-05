/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynewteeth;

import java.awt.Color;
import mynewteeth.frontend.LoginFrame;


/**
 *
 * @author Us
 */
public class Processor {
    
    public Processor() {
        
    }
    
    public static void main(String[] args) {
        runLoginFrame();
    }
    
    private static void runLoginFrame() {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setTitle("Dashboard");
        loginFrame.getContentPane().setBackground(Color.WHITE);
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }
}
