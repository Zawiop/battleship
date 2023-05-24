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



public class Battleship extends Battleships{
   
      static int[][] boundsArray;
      static int searched = 0;
      static String filename = "";
      Image carship;
      ImageIcon carIcon;
      public Battleship(String fileName, int[][] bounds, int search)
      {
        
         boundsArray = bounds;
         searched = search;
         filename = fileName;
          carIcon = new ImageIcon(fileName);
          carship = carIcon.getImage();

      }
      
   /**
   * Shows the boat at the specified coordinates on the panel
   */
      
      public Object[] show(int carShipRotation, boolean left){
         int[][] locationShips = new int[10][10];

         for(int i =0; i<9; i++){
            for(int j = 0; j< 9; j++){
               locationShips[i][j]=0;
            }
          }
         Image c2Scale;
         Image c2Scaled;
         String bounds = "0";
         String scaled = "0";
         int row = (int)Math.floor(searched/10);
         int col = searched % 10;
         int or = 0;
         if(left == true &&  boundsArray[searched][0]+98 < 470){
            
               c2Scale = carIcon.getImage();
               c2Scaled = c2Scale.getScaledInstance(186, 31, java.awt.Image.SCALE_SMOOTH);
               locationShips[row][col] = 1;
               locationShips[row][col+1] = 1;
               locationShips[row][col+2] = 1;
               locationShips[row][col+3] = 1;
               or = 0;
               int[] data = new int[]{row, col, 4, or};
               return new Object[]{c2Scaled, "0", "0", locationShips, data};
               
   
         }
          else {
            if(carShipRotation==1 && boundsArray[searched][1] + 98 < 470){
               c2Scale = rotate(carIcon, 90).getImage();
               c2Scaled = c2Scale.getScaledInstance(31, 186, java.awt.Image.SCALE_SMOOTH);
               bounds = "-47";
               scaled = "23";
               locationShips[row][col] = 1;
               locationShips[row+1][col] = 1;
               locationShips[row+2][col] = 1;
               locationShips[row+3][col] = 1;
               or = 0;

            } else if(carShipRotation==2 && boundsArray[searched][0] + 98< 470){
               c2Scale = rotate(rotate(carIcon, 90),90).getImage();
               c2Scaled = c2Scale.getScaledInstance(186, 31, java.awt.Image.SCALE_SMOOTH);
               scaled = "47";
               bounds = "47";
               locationShips[row][col] = 1;
               locationShips[row][col+1] = 1;
               locationShips[row][col+2] = 1;
               locationShips[row][col+3] = 1;
               or = 1;

            } else if(carShipRotation == 3 && boundsArray[searched][1] + 98 < 470) {
               c2Scale = rotate(rotate(rotate(carIcon, 90),90),90).getImage();
               c2Scaled = c2Scale.getScaledInstance(31, 186, java.awt.Image.SCALE_SMOOTH);
               scaled = "47";
               bounds = "-23";
               locationShips[row][col] = 1;
               locationShips[row+1][col] = 1;
               locationShips[row+2][col] = 1;
               locationShips[row+3][col] = 1;
               or = 0;

            }else if(carShipRotation == 4 &&  boundsArray[searched][0] + 98 < 470) {
               c2Scale = carIcon.getImage();
               c2Scaled = c2Scale.getScaledInstance(186, 31, java.awt.Image.SCALE_SMOOTH);
               scaled = "47";
               bounds = "47";
               locationShips[row][col+1] = 1;
               locationShips[row][col+2] = 1;
               locationShips[row][col+3] = 1;
               or = 1;

            } else {
               c2Scaled = null;
            }

         }
         int[] data = new int[]{row, col, 4, or};
         Object[] returning = new Object[5];
         returning[0] = c2Scaled;
         returning[1] = scaled;
         returning[2] = bounds;
         returning[3] = locationShips;
         returning[4] = data;
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