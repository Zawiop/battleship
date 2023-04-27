	/*****************************************************************
	* The AI part of the project, what the player plays against
   * Compatible with scoreboard and all other essential classes
	 
	* @Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/



public class robot
{
   /**
   * Simply marking where the ships are, for the robot's reference
   */
   private int[][] ships;
   /**
   * Listing what has been guessed using column(letter) row(number) notation
   */
   private String[] guessed;
   /**
   * Sends an attack to the scoreboard
   * Sent to all necessary classes
   */
   public int[] attack()
   {
      return null;
   }
   /**
   * Turns the attack into column row notation for ease of scorekeeper class
   */
   public String[] move()
   {
      return null;
   }
   
   /**
   * Checks how many of the robot's ships exist (number is a placeholder)
   */
   
   public int existingShips()
   {
      return 0;
   }
   
   
   /**
   * Checks if the square that the AI wants to guess has not already been guessed (boolean is a placeholder)
   */
   public boolean alreadyGuessed()
   {
      return false;
   }
   
   /**
   * Returns the locations of the ships that the AI decides at the beginning of the game
   */
   public int[][] getShips()
   {
      return null;
   }
   
   
   
}