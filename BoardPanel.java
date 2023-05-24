	/*****************************************************************
	* An array version of the scoreboard, used for comparisons and simple operations
   * Can access all values in this with methods, and set specific values
	 
	* @Author Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/

   import javax.swing.*;
   import java.awt.*;

public class BoardPanel {
    
   /**
   * The 2-d array that represents the scoreboard itself
   */
    private int shipLoc;
    private int[][] shipDetails;
    int row =0;
    int column =0;
    
   /**
   * Takes a move that has happened, and is applied to the array itself
   */
   public BoardPanel(int[][]shipLocs, int location) {
      shipDetails = shipLocs;
      shipLoc = location;
      int rows = (int)Math.floor(shipLoc/10);
      int col = shipLoc % 10;
      row = rows;
      column = col;


   }
    
    public JLabel getImage()
    {
      ImageIcon whiteMarker = (new ImageIcon("whiteMarker.PNG"));
      ImageIcon redMarker = (new ImageIcon("redMarker.PNG"));
      if(shipDetails[row][column] == 1){
         return new JLabel(redMarker);
      } else if(shipDetails[row][column] == 0) {
         return new JLabel(whiteMarker);
      }
      
      //scoreboard[xofG][yofG] = guess;
      // 0 == no ship, not hit
      // 1 == no ship, hit
      // 2 == ship, no hit
      // 3 == ship, hit
    }
    
    
  
    
    
    

}