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



public class AircraftCarrier extends Battleships{
   
   /**
   * The bounds of the carrier
   */
   private static int[][] boundsArray;

   /**
   * The location of the carrier
   */
   private static int searched = 0;
   
   /**
   * The file location of the carrier
   */
   private static String filename = "";
   
   /**
   * The Image form of the carrier
   */
   private Image carship;

   /**
   * The ImageIcon form of the carrier
   */
   private ImageIcon carIcon;
   
   /**
   * Constructor
   * @param fileName the location of the image
   * @param bounds the bounds of the Aircraft Carrier
   * @param search the location, based on a search method
   */
   public AircraftCarrier(String fileName, int[][] bounds, int search)
   {
      boundsArray = bounds;
      searched = search;
      filename = fileName;
      carIcon = new ImageIcon(fileName);
      carship = carIcon.getImage();
   }
   
   /**
   * Shows the Carrier
   * @param carShipRotation location
   * @param left left click or not      
   * @return Image + bound, scale, location and other assorted data
   */
      
   public Object[] show(int carShipRotation, boolean left){
      int[][] locationShips = new int[10][10]; //Gives the ship's location on the 10x10 array
      Image c2Scale; //c2Scale is the image that is used to get the Icon
      Image c2Scaled; //the actual scaled image
      String bounds = "0"; //bound values, used to regulate rotation
      String scaled = "0"; //the value scaled to the grid size
      int row = (int)Math.floor(searched/10); //Getting the row as this expression results in the row
      int col = searched % 10; //Getting the column as this expression results in the column
      int or= 0; //Horizontal or Vertical, 0 is Horizontal and 1 is vertical
      if(left == true &&  boundsArray[searched][0]+142 < 470){
         //Scaling the Image
         c2Scale = carIcon.getImage();
         c2Scaled = c2Scale.getScaledInstance(240, 50, java.awt.Image.SCALE_SMOOTH);
         //"Placing" the ships on this array
         locationShips[row][col] = 1;
         locationShips[row][col+1] = 1;
         locationShips[row][col+2] = 1;
         locationShips[row][col+3] = 1;
         locationShips[row][col+4] = 1;
         
         or= 0;
         int[] data = new int[]{row, col, 5, or};

         return new Object[]{c2Scaled, "0", "0", locationShips,data};
      } else {
         if(carShipRotation==1 && boundsArray[searched][1] + 142 < 470){
            //Using the rotate method, rotating it 90 degrees
            c2Scale = rotate(carIcon, 90).getImage();
            c2Scaled = c2Scale.getScaledInstance(50, 240, java.awt.Image.SCALE_SMOOTH);
            bounds = "-94";
            //Since the image is rotated, must use row instead of column to add
            locationShips[row][col] = 1;
            locationShips[row+1][col] = 1;
            locationShips[row+2][col] = 1;
            locationShips[row+3][col] = 1;
            locationShips[row+4][col] = 1;
            or= 1;
         } else if(carShipRotation==2 && boundsArray[searched][0] + 142< 470){
            //Easier to work in intervals of 90, so 90 is applied twice to get 180
            c2Scale = rotate(rotate(carIcon, 90),90).getImage();
            c2Scaled = c2Scale.getScaledInstance(240, 50, java.awt.Image.SCALE_SMOOTH);
            
            scaled = "47";
            bounds = "47";
            locationShips[row][col] = 1;
            locationShips[row][col+1] = 1;
            locationShips[row][col+2] = 1;
            locationShips[row][col+3] = 1;
            locationShips[row][col+4] = 1;
            or= 0;
         } else if(carShipRotation == 3 && boundsArray[searched][1] + 142 < 470) {
            //Same process, 270
            c2Scale = rotate(rotate(rotate(carIcon, 90),90),90).getImage();
            c2Scaled = c2Scale.getScaledInstance(50, 240, java.awt.Image.SCALE_SMOOTH);
            scaled = "47";
            bounds = "-47";
            locationShips[row][col] = 1;
            locationShips[row+1][col] = 1;
            locationShips[row+2][col] = 1;
            locationShips[row+3][col] = 1;
            locationShips[row+4][col] = 1;
            or= 1;
         }else if(carShipRotation == 4 &&  boundsArray[searched][0] + 142 < 470) {
            //Just uses the original instance for 360
            c2Scale = carIcon.getImage();
            c2Scaled = c2Scale.getScaledInstance(240, 50, java.awt.Image.SCALE_SMOOTH);
            bounds = "0";
            locationShips[row][col+1] = 1;
            locationShips[row][col+2] = 1;
            locationShips[row][col+3] = 1;
            locationShips[row][col+4] = 1;
            or= 0;
         } else {
            c2Scaled = null;
         }
      }
      
      //Data is data about the ship such as original row size, original column size, size, and horizontal or Vertical
      int[] data = new int[]{row, col, 5, or};
      
      //returns Image, scale data, bounds data, locations on the fake grid and the data
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
