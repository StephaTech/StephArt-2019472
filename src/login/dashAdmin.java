package login;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class dashAdmin implements ActionListener {

   JFrame f;
   JMenuBar mb;
   JMenu admin, artist, artPiece, log;
   //JMenuItem gallery, fav;
   JTextArea ta;
   
   dashAdmin(){
   
   f = new JFrame();
   //gallery = new JMenuItem("Gallery");
   //fav = new JMenuItem("Favorite");
   
   
   //gallery.addActionListener(this);
   //fav.addActionListener(this);
   
   
   mb=new JMenuBar();
   admin=new JMenu("Admin");
   artist=new JMenu("Artist");
   artPiece=new JMenu("Art Piece");
   log=new JMenu("Log Out");//I want change log out to the right
   //mb.add(log,BorderLayout.NORTH); 
   
   //Menu.add(gallery);Menu.add(fav);    
   mb.add(admin);mb.add(artist);mb.add(artPiece);mb.add(log);//this line add the menu to the bar

ta=new JTextArea();    
ta.setBounds(5,5,800,800);    
f.add(mb);f.add(ta);    
f.setJMenuBar(mb);  
f.setLayout(null); 
f.setTitle("Administrator of StephArt Platform");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setSize(800,800);    
f.setVisible(true);  
   
}
   
    public static void main(String[] args) {
        new dashAdmin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    }
    
}







   
   
    
    

    


    

