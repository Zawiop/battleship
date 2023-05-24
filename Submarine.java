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



public class Submarine extends Battleships{
   
      static int[][] boundsArray;
      static int searched = 0;
      static String filename = "";
      Image sub;
      ImageIcon subIcon;
      public Submarine(String fileName, int[][] bounds, int search)
      {
        
         boundsArray = bounds;
         searched = search;
         filename = fileName;
          subIcon = new ImageIcon(fileName);
          sub = subIcon.getImage();

      }
      
   /**
   * Shows the boat at the specified coordinates on the panel
   */
      
      public Object[] show(int carrierRotation, boolean left){
         Image s2Scale;
         Image s2Scaled;
         String bounds = "0";
         String scaled = "0";
         if(left == true &&  boundsArray[searched][0]+47 < 470){
            
            s2Scale = subIcon.getImage();
               s2Scaled = s2Scale.getScaledInstance(133, 46, java.awt.Image.SCALE_SMOOTH);
               return new Object[]{s2Scaled, "0", "0"};
   
         }
          else {
            if(carrierRotation==1 && boundsArray[searched][1] + 47 < 470){
               s2Scale = rotate(subIcon, 90).getImage();
               s2Scaled = s2Scale.getScaledInstance(46, 133, java.awt.Image.SCALE_SMOOTH);
               bounds = "-47";
            } else if(carrierRotation==2 && boundsArray[searched][0] + 47 < 470){
               s2Scale = rotate(rotate(subIcon, 90),90).getImage();
               s2Scaled = s2Scale.getScaledInstance(133, 46, java.awt.Image.SCALE_SMOOTH);
               scaled = "47";
               bounds = "47";
            } else if(carrierRotation == 3 && boundsArray[searched][1] + 47 < 470) {
               s2Scale = rotate(rotate(rotate(subIcon, 90),90),90).getImage();
               s2Scaled = s2Scale.getScaledInstance(46, 133, java.awt.Image.SCALE_SMOOTH);
               scaled = "47";
            }else if(carrierRotation == 4 &&  boundsArray[searched][0] + 47 < 470) {
               s2Scale = subIcon.getImage();
               s2Scaled = s2Scale.getScaledInstance(133, 46, java.awt.Image.SCALE_SMOOTH);
               scaled = "47";
               bounds = "47";
            } else {
               s2Scaled = null;
            }

         }
         Object[] returning = new Object[3];
         returning[0] = s2Scaled;
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