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




public class WhiteMarker extends Battleships{
   /**
   * Marker's x coordinate
   */
      private int myX;
      
   /**
   * Marker's y coordinate
   */
      private int myY;
      public WhiteMarker(int x, int y)
      {
         myX = x;
         myY = y;
      }
      
   /**
   * Shows the marker at the specified coordinates on the panel
   */
      
   public Object[] show(int x, boolean left)
   {
      ImageIcon marker = new ImageIcon("whiteMarker.png");
      JLabel jmarker = new JLabel(marker);
      Object[] returnVal = new Object[1];
      returnVal[0] = jmarker;
      //-53-188-8+23 setbounds and figure it out!!
      
      return returnVal;
   }
   /**
   * Will actually stay as a blank definition, because this is not necessary for a circular marker
   */
  public ImageIcon rotate(ImageIcon icon, int angle)
  {
     return null;
  }
}   