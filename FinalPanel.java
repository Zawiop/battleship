	/*****************************************************************
	* Panel, contains everything as well as all visual commands
	 
	* @Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.net.*;
import java.awt.event.*;


public class FinalPanel extends JPanel {
   static boolean gameStarted = false;
   
   /**
   * Where all elements will be instantiated and added, located in the constructor for default behavior
   */
   public FinalPanel()
   {
   
   
   }
   public void gameStart(Graphics g) {
      if(gameStarted == false) {
         JButton help = new JButton("Instructions Menu");
         JButton set = new JButton("Set Ships");
         JButton reset = new JButton("Reset Board");
         help.addActionListener(new helpMenu());
         
         add(help);

         ImageIcon icon = new ImageIcon("board.JPG");
         JLabel label = new JLabel(icon);
         label.setBounds(-20,-20, 640,640);
         add(label);
         


         

         //gameStarted = true;
      }
      }
   public void playGame(Graphics g) {
      if(gameStarted == true) {
         g.setColor(new Color(103,179,201));
         g.drawRect(50,50,90,70);
      }
      
   
   }
   public void paintComponent(Graphics g) {
      gameStart(g);
      playGame(g);
    
}
   public static void main(String[] args)  throws MalformedURLException {
   
   }
  

 private  class helpMenu implements ActionListener {
      /**
      * What the help menu button will actually do 
      */
       public void actionPerformed(ActionEvent e) {
         HelpPanelContainer def = new HelpPanelContainer();
         JPanel panel = def.newJpanel();
         //frame.add(panel); 
         //whenever we add the frame in
       }
   }  
}

