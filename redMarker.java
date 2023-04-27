	/*****************************************************************
	* An extention of an abstract class, simply extends the Battleship classes
   * Does not have any unique methods of its own
   * Is not a ship itself, but extends the ship class due to commonality of methods
	 
	* @Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/




public class redMarker extends Battleships{
   /**
   * Marker's x coordinate
   */
      private int myX;
      
   /**
   * Marker's y coordinate
   */
      private int myY;
      public redMarker(int x, int y)
      {
         myX = x;
         myY = y;
      }
      
   /**
   * Shows the marker at the specified coordinates on the panel
   */
      
      public void show(int x, int y)
      {
      }
      
   /**
   * Will actually stay as a blank definition, because this is not necessary for a circular marker
   */
      public void rotate(int z)
      {
      }
}   