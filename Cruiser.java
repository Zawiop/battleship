import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
   /*****************************************************************
	* An extention of an abstract class, simply extends the Battleship classes
   * Does not have any unique methods of its own
	 
	* @Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/



public class Cruiser extends Battleships{
   
      static int[][] boundsArray;
      static int searched = 0;
      static String filename = "";
      Image cruiser;
      ImageIcon cruiserIcon;
      public Cruiser(String fileName, int[][] bounds, int search)
      {
        
         boundsArray = bounds;
         searched = search;
         filename = fileName;
          cruiserIcon = new ImageIcon(fileName);
          cruiser = cruiserIcon.getImage();

      }
      
   /**
   * Shows the boat at the specified coordinates on the panel
   */
      
      public Object[] show(int carrierRotation, boolean left){
         Image c2Scale;
         Image c2Scaled;
         String bounds = "0";
         String scaled = "0";
         if(left == true &&  boundsArray[searched][0]+47 < 470){
            
               c2Scale = cruiserIcon.getImage();
               c2Scaled = c2Scale.getScaledInstance(140, 45, java.awt.Image.SCALE_SMOOTH);
               return new Object[]{c2Scaled, "0", "0"};
   
         }
          else {
            if(carrierRotation==1 && boundsArray[searched][1] + 47 < 470){
               c2Scale = rotate(cruiserIcon, 90).getImage();
               c2Scaled = c2Scale.getScaledInstance(45, 140, java.awt.Image.SCALE_SMOOTH);
               bounds = "-47";
            } else if(carrierRotation==2 && boundsArray[searched][0] + 47 < 470){
               c2Scale = rotate(rotate(cruiserIcon, 90),90).getImage();
               c2Scaled = c2Scale.getScaledInstance(140, 45, java.awt.Image.SCALE_SMOOTH);
               scaled = "47";
               bounds = "47";
            } else if(carrierRotation == 3 && boundsArray[searched][1] + 47 < 470) {
               c2Scale = (rotate(cruiserIcon, 270).getImage());
               c2Scaled = c2Scale.getScaledInstance(45, 140, java.awt.Image.SCALE_SMOOTH);
               scaled = "47";
               System.out.println("here");
            }else if(carrierRotation == 4 &&  boundsArray[searched][0] + 47 < 470) {
               c2Scale = cruiserIcon.getImage();
               c2Scaled = c2Scale.getScaledInstance(140, 45, java.awt.Image.SCALE_SMOOTH);
               scaled = "47";
               bounds = "47";
            } else {
               c2Scaled = null;
            }

         }
         Object[] returning = new Object[3];
         returning[0] = c2Scaled;
         returning[1] = scaled;
         returning[2] = bounds;
         return returning;

      }
      
   /**
   * Takes in the rotating amount, which works in 90 degree intervals, and imports the correct image
   */
      
      public ImageIcon rotate(ImageIcon icon, int angle) {
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
