/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This is the login window
 * The following code has been sourced from Amilcar Aponte 
 * Availability: moodle GUI subject 
 */
public class LoginWindow extends JFrame{
    
    // Text fields must be class members so all methods can access them
    private JTextField tf1;
    private JTextField tf2;
    private JLabel user_label;
    // This window needs to know who the controller is
    private LoginController controllerInternalRef;
    
    public LoginWindow(LoginController controller){
        
        // Putting the reference of the controller in the local reference
        this.controllerInternalRef = controller;
        
        // We encapsulated the building process of the window
        attributesSetter();
        components();
        validation();
    }
    
    // Setting attributes
    private void attributesSetter(){
        this.setVisible(true);
        this.setSize(550,500);
        setLocationRelativeTo(null);// screen is not changing the position (NOT WORKING) 
        this.setTitle("StephArt Platform - Log In");
        
    }
    
    // Organising components
    private void components(){
        JPanel p = new JPanel();
        this.add(p);
        
             //NOT WORKING AT ALL to put username and password on the screen   
        /*user_label = new JLabel();
        user_label.setText("Username :");
        tf1 = new JTextField();
        p.add(user_label);
        //setSize(550,450);
        //setVisible(true);*/
        
        
        tf1 = new JTextField(20);
        tf1.setText("");//optinonal(NOT WORKING)
        tf2 = new JTextField(20);//20 means accept up to 20 charact
        
        JButton button = new JButton("Login");//creating a button
        button.addActionListener((ActionListener) controllerInternalRef);//gives action to the button
        button.setActionCommand("b");
        
                
        JButton button2 = new JButton("Sign up/Register");
        button2.addActionListener((ActionListener) controllerInternalRef);
        button2.setActionCommand("b2");
        
        
        p.add(tf1);
        p.add(tf2);
        p.add(button);//adding the button to the screen
        p.add(button2);
        
    }
    
    // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    // Getters for username and password
    public String getUsername(){
        return tf1.getText();
    }
    public String getPassword(){
        return tf2.getText();
    }

}
