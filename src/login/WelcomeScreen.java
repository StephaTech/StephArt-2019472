/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
//Bellow the imports
import com.sun.glass.events.KeyEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**The following lines belongs has been sourced from javatpoint
 * Availability:https://www.javatpoint.com/java-jmenuitem-and-jmenu
 */

//This class is going to come up only when the login is successful
public class WelcomeScreen extends JFrame implements ActionListener, KeyListener{
    //variables
   JFrame f;
   JMenuBar mb;
   JMenu Menu, UpProf, log;
   JMenuItem gallery, fav;
   JTextArea ta;
   
   public WelcomeScreen(User userLogged){
   
   f = new JFrame();
   gallery = new JMenuItem("Gallery");//given name to the menu for the screen
   fav = new JMenuItem("Favorite");
   
   
   gallery.addActionListener(this);//adding to the lactionistener
   fav.addActionListener(this);
   
   
   mb=new JMenuBar();
   Menu=new JMenu("Menu");
   UpProf=new JMenu("Update Profile");
   log=new JMenu("Log Out");//I want change log out to the right
   //mb.add(log,BorderLayout.NORTH); (NOT WORKING)
   
   //Create the log out action on the menu bar
     log.setMnemonic(KeyEvent.VK_X);
     //log.addMenuListener(new thisMenuListener());
     mb.add(log);
     log.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           f.dispose();
           //view = new LoginWindow(this);I was trying to do the log out menu when click back to the login(NOT WORKING)
           //LoginWindow.setVisible(true);
       }
   });
    
   
   Menu.add(gallery);Menu.add(fav);    
   mb.add(Menu);mb.add(UpProf);mb.add(log);
   JPanel p = new JPanel();
   this.add(p);
   JLabel label = new JLabel("Whats up " + userLogged.getUn());
   p.add(label);
   
    ta=new JTextArea();//allow to write at the board  
    ta.setBounds(5,5,800,800);    
    f.add(mb);f.add(ta);    
    f.setJMenuBar(mb);  
    f.setLayout(null); 
    f.setTitle("Welcome to StephArt Platform");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(800,800);
    //setLocationRelativeTo(null); I was trying with this method display the JFrame to center position of a screen(NOT WORKING)
    f.setVisible(true);  
 
}
   
  

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
    }
       
  
   
      
   }
