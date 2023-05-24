	/*****************************************************************
	* An array version of the scoreboard, used for comparisons and simple operations
   * Can access all values in this with methods, and set specific values
	 
	* @Author Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/



public class BoardArray {
    
   /**
   * The 2-d array that represents the scoreboard itself
   */
    private int[][] grid;
    private int[][] shipDetails;
   /**
   * Takes a move that has happened, and is applied to the array itself
   */
   public BoardArray(int[][][] shipLoc) {
      grid = shipLoc[0];
      shipDetails = shipLoc[1];
   }
    
    public void setMove(int xofG, int yofG, int guess)
    {
      
      
      
      //scoreboard[xofG][yofG] = guess;
      // 0 == no ship, not hit
      // 1 == no ship, hit
      // 2 == ship, no hit
      // 3 == ship, hit
    }
    
    
   /**
   * Checks if the selected position has a ship or not, simplifies lots of operations (false is a placeholder)
   */
    
    public boolean isHit(int x, int y)
    {
      if(grid[x][y] == 0 || grid[x][y] == 1)
      {
         return false;
      } else{
         return true;
      }
    }
    
   /**
   * Gets the entire 2D array and makes it accessible
   */
    public int[][] getScoreboard()
    {
      
      return null;//scoreboard;
    }
    
    /**
    * Sets ships onto the board and adds them to the scoreboard private variable
    */
    public void placeShape(int [][] values, int n)
    {
      // for(int i = 0; i < n; i++) {
      //    scoreboard[values[i][0]][values[i][1]] = 2;
      // }
    }
    

}