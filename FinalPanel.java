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
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


public class FinalPanel extends JPanel {
   static boolean gameStarted = false;
   static JFrame frame = new JFrame("Battleship");
   
   /**
   * Where all elements will be instantiated and added, located in the constructor for default behavior
   */
   public FinalPanel()
   {
      this.setLayout(null);
      gameStart();
   
   }
   public void gameStart() {
      if(gameStarted == false) {
         JButton help = new JButton("Instructions Menu");
         JButton set = new JButton("Set Ships");
         JButton reset = new JButton("Reset Board");
         help.addActionListener(new helpMenu());
         set.addActionListener(new setShips());
         reset.addActionListener(new resetShips());
         set.setBounds(700, 50, 150, 25);
         help.setBounds(700, 0, 150, 25);
         reset.setBounds(700, 100, 150, 25);
         
         add(help);
         add(set);
         add(reset);

         ImageIcon board = new ImageIcon("board.JPG");
         JLabel boardLabel = new JLabel(board);
         boardLabel.setBounds(-20, -20, 640,640);
         //add(boardLabel);

         ImageIcon sub = new ImageIcon("Submarine.PNG");
         JLabel subLabel = new JLabel(rotateIcon(sub,270));
         subLabel.setBounds(20, 20, 640,640);
         add(subLabel);
         


         

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
      super.paintComponent(g);
      //gameStart(g);
     // playGame(g);
    
}
   public static void main(String[] args)  throws MalformedURLException {
     
      frame.setSize(1500, 600);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      frame.setContentPane(new FinalPanel());
      frame.setVisible(true);
   }
  

 private  class helpMenu implements ActionListener {
      /**
      * What the help menu button will actually do 
      */
       public void actionPerformed(ActionEvent e) {
         
         JOptionPane.showMessageDialog(frame,"How to play Battleship: \n" +"First you must place your ships on the grid, and once you have set them, press the set ships button. Next, your oppponent, a AI, will place their ships in location. \n"+ "Soon after you get to fire at the opponents grid in alternating turns, each shot hitting one tile and letting you know if you hit or miss.", "Help Menu"
         , JOptionPane.QUESTION_MESSAGE,null);
         //whenever we add the frame in
       }
   }
   private class setShips implements ActionListener {
      /**
      * What the setShips button will actually do 
      */
      public void actionPerformed(ActionEvent e) {
        
        
      }  
   }
   private class resetShips implements ActionListener {
      /**
      * What the setShips button will actually do 
      */
      public void actionPerformed(ActionEvent e) {
        
      }
   }

private ImageIcon rotateIcon(ImageIcon icon, int angle) {
   Image image = icon.getImage();
   int width = image.getWidth(null);
   int height = image.getHeight(null);

   BufferedImage rotatedImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
   Graphics2D g2d = rotatedImage.createGraphics();

   g2d.translate(height / 2, width / 2);
   g2d.rotate(Math.toRadians(angle));
   g2d.translate(-width / 2, -height / 2);

   g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
   g2d.drawImage(image, 0, 0, null);
   g2d.dispose();

   return new ImageIcon(rotatedImage);

   }
}
