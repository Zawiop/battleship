import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/*****************************************************************
* An extention of an abstract class, simply extends the Battleship classes
* Does not have any unique methods of its own
   
* @Authors Rohan Singh, Fabeun Rahman and Arrush Shah
* @version 4/25/23
****************************************************************/



public class Destroyer extends Battleships{
   /**
   * The bounds of the Destroyer
   */
   static int[][] boundsArray;
   
   /**
   * The location of the Destroyer
   */
   static int searched = 0;
   
   /**
   * The file location of the Destroyer
   */
   static String filename = "";
   
   /**
   * The Image form of the Destroyer
   */
   Image destroy;
   
   /**
   * The ImageIcon form of the Destroyer
   */
   ImageIcon destroyIcon;

   /**
   * Constructor
   * @param fileName the location of the image
   * @param bounds the bounds of the Destroyer
   * @param search the location, based on a search method
   */
   public Destroyer(String fileName, int[][] bounds, int search)
   {
      
      boundsArray = bounds;
      searched = search;
      filename = fileName;
         destroyIcon = new ImageIcon(fileName);
         destroy = destroyIcon.getImage();

   }
   
   /**
   * Shows the Destroyer
   * @param carShipRotation location
   * @param left left click or not      
   * @return Image + bound, scale, location and other assorted data
   */
  
   
   public Object[] show(int DestroyerRotation, boolean left){
      
      int[][] locationShips = new int[10][10]; //Gives the ship's location on the 10x10 array
      Image d2Scale; //c2Scale is the image that is used to get the Icon
      Image d2Scaled; //the actual scaled image
      String bounds = "0"; //bound values, used to regulate rotation
      String scaled = "0"; //the value scaled to the grid size
      int row = (int)Math.floor(searched/10); //Getting the row as this expression results in the row
      int col = searched % 10; //Getting the column as this expression results in the column
      int or = 0; //Horizontal or Vertical, 0 is Horizontal and 1 is vertical
      if(left == true &&  boundsArray[searched][0]+23 < 470){
         //Scaling the Image
         d2Scale = destroyIcon.getImage();
         d2Scaled = d2Scale.getScaledInstance(90, 30, java.awt.Image.SCALE_SMOOTH);
         //"Placing" the ships on this array
         locationShips[row][col] = 1;
         locationShips[row][col+1] = 1;
         or = 0;
         int[] data = new int[]{row, col, 2, or};
         return new Object[]{d2Scaled, "0", "0", locationShips, data};

      }
         else {
         if(DestroyerRotation==1 && boundsArray[searched][1] + 23 < 470){
            
            //Using the rotate method, rotating it 90 degrees
            d2Scale = rotate(destroyIcon, 90).getImage();
            d2Scaled = d2Scale.getScaledInstance(30, 90, java.awt.Image.SCALE_SMOOTH);
            bounds = "-24";
            //Since the image is rotated, must use row instead of column to add
            locationShips[row][col] = 1;
            locationShips[row+1][col] = 1;
            or = 1;

         } else if(DestroyerRotation==2 && boundsArray[searched][0] + 23 < 470){
            //Easier to work in intervals of 90, so 90 is applied twice to get 180
            d2Scale = rotate(rotate(destroyIcon, 90),90).getImage();
            d2Scaled = d2Scale.getScaledInstance(90, 30, java.awt.Image.SCALE_SMOOTH);
            scaled = "47";
            bounds = "47";
            locationShips[row][col] = 1;
            locationShips[row][col+1] = 1;
            or = 0;

         } else if(DestroyerRotation == 3 && boundsArray[searched][1] + 23 < 470) {
            //Same process, 270
            d2Scale = rotate(rotate(rotate(destroyIcon, 90),90),90).getImage();
            d2Scaled = d2Scale.getScaledInstance(30, 90, java.awt.Image.SCALE_SMOOTH);
            scaled = "23";
            locationShips[row][col] = 1;
            locationShips[row+1][col] = 1;
            or = 1;

         }else if(DestroyerRotation == 4 &&  boundsArray[searched][0] + 23 < 470) {
            //Just uses the original instance for 360

            d2Scale = destroyIcon.getImage();
            d2Scaled = d2Scale.getScaledInstance(90, 30, java.awt.Image.SCALE_SMOOTH);
            scaled = "47";
            bounds = "47";
            locationShips[row][col+1] = 1;
            locationShips[row][col+2] = 1;
            or = 0;

         } else {
            d2Scaled = null;
         }

      }

      //Data is data about the ship such as original row size, original column size, size, and horizontal or Vertical
      int[] data = new int[]{row, col, 2, or};
      Object[] returning = new Object[5];
      returning[0] = d2Scaled;
      returning[1] = scaled;
      returning[2] = bounds;
      returning[3] = locationShips;
      returning[4] = data;
      return returning;

   }
      
   /**
   * Takes in the rotating amount, which works in 90 degree intervals, and imports the correct image
   * @param icon Image to be rotated
   * @param angle Amount of rotation, in 90 degrees
   * @return The rotated image
   */
      
      public ImageIcon rotate(ImageIcon icon, int angle) {
         Image image = icon.getImage();
         int width = image.getWidth(null);
         int height = image.getHeight(null);
         
         //Switches the width and the height
         BufferedImage rotatedImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
         Graphics2D g2d = rotatedImage.createGraphics();
         
         //Rotates the Image
         g2d.translate(height / 2, width / 2);
         g2d.rotate(Math.toRadians(angle));
         g2d.translate(-width / 2, -height / 2);
      
         g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         g2d.drawImage(image, 0, 0, null);
         g2d.dispose();
      
         return new ImageIcon(rotatedImage);
      
      }
}   
