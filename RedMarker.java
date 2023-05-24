import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.net.*;
import java.awt.event.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;

/*****************************************************************
	* An extention of an abstract class, simply extends the Battleship classes
   * Does not have any unique methods of its own
   * Is not a ship itself, but extends the ship class due to commonality of methods
	 
	* @Authors Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/




public class RedMarker extends JPanel{
   /**
   * Marker's x coordinate
   */
      private int myX;
      
   /**
   * Marker's y coordinate
   */
      private int myY;
      public RedMarker(int x, int y)
      {
         ImageIcon bruh = new ImageIcon("fire.gif");
         JLabel bruh2 = new JLabel(bruh);
         add(bruh2);
      }
      
   /**
   * Shows the marker at the specified coordinates on the panel
   */
      
      public Object[] show(int x, boolean left)
      {
         return null;
      }
      
   /**
   * Will actually stay as a blank definition, because this is not necessary for a circular marker
   */
      public ImageIcon rotate(ImageIcon icon, int angle)
      {
         return null;
      }

      public static void main(String[] args)
      {
         ImageIcon bruh = new ImageIcon("fire.gif");
         // frame.setSize(1500, 600);
         // frame.setLocation(0, 0);
         // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         // frame.setBackground(Color.RED);

   
         // frame.setContentPane(new FinalPanel());
         // frame.setVisible(true);
      }
}   