import java.util.Random;




/*****************************************************************
	* The AI part of the project, what the player plays against
   * Compatible with scoreboard and all other essential classes
	 
	* @Authors Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/



public class Robot
{
   /**
   * Simply marking where the ships are, for the robot's reference
   */
   private int[] guessed;
   private int turnCounter = 0;
   private int[] posOfGuesses;
   //private int hunting = 0;
   private int huntHitCount = 0;
   private int[] hits;
   private int[] misses;
   private int[] guesses;
   private boolean hunting = false;
   private boolean dirFound = false;
   private int huntPoint = 0;
   
   public Robot()
   {

   }

   /**
   * Sends an attack to the scoreboard
   * Sent to all necessary classes
   */
   
   public static boolean validGuess(int row, int col)
   {
      
      boolean returnVal = true;
      
      if(row > 9 || row < 0)
      {
         returnVal = false;
      }
      
      if(col > 9 || col < 0)
      {
         returnVal = false;
      }
      
      return returnVal;
      
   }
   
   public int randomMove(int row, int col)
   {
      int randomMove = (int)(Math.random() * 3);
      if(randomMove == 0)
      {
         col++;
      } else if(randomMove == 1)
      {
         row++;
      } else if(randomMove == 2)
      {
         col--;
      } else
      {
         row--;
      }
      
      return row * 10 + col;
      
   }
   
   public int attack()
   {
      
      turnCounter++;
      int returnVal = -99;
      
      if(turnCounter == 1)
      {
         returnVal = (int)(Math.random() * 99);
      } else
      {
         if(hunting)
         {
            if(hits[hits.length - 1] == guesses[guesses.length - 1])
            {
               
               hunting = false;
               dirFound = true;
            } else
            {
               int row = (int)Math.floor(huntPoint / 10);
               int col = huntPoint % 10;
               
            int guess = randomMove(row, col); 
            while(!validGuess((int)Math.floor(guess/10), guess % 10))
            {
               guess = randomMove(row, col);
            }
            //check if guess is a hit
            //
            
         }
         } else if(dirFound)
            
         {
         
         } else if (hits[hits.length-1] == guesses[guesses.length - 1])
         {
            //basically if the last one was a hit, getting you into our "hunting" mechanism
            hunting = true;
         } //else if () when the capability to check if something is a hit or not is available, check the dirFound variable
         //dirFound should update after the hunting mechanism is over
         else
         {
            returnVal = (int)(Math.random() * 99 + 0);
            while(alreadyGuessed(returnVal, guessed))
            {
               returnVal = (int)(Math.random() * 99 + 0);
            }
         } 
         
         
      }
      
      
      
      return returnVal;
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
      int lastScore[] = new int[2];
      return 0;
   }
   
   
   /**
   * Checks if the square that the AI wants to guess has not already been guessed (boolean is a placeholder)
   */
   public boolean alreadyGuessed(int a, int[] g)
   {
      boolean returnVal = false;
      for(int x = 0; x < 100; x++)
      {
         if(g[x] == a)
         {
            returnVal = true;
         }
      }

      return returnVal;
   }
   
   /**
   * Returns the locations of the ships that the AI decides at the beginning of the game
   */
   public static int[][] getShips()
   {
      return null;
   }
   
   public static int cRandGuess()
   {
      int returnVal = (int)(Math.random() * 99); 
      return returnVal;
   }
   
   public static void main(String[] args) {
      int[][] grid = new int[10][10];
      Object[][] ships = new Object[5][4]; // creating 5 ships with [x, y, size, orientation] all stored in them

      // Initialize the grid with 0 (no ships)
      for (int i = 0; i < 10; i++) {
         for (int j = 0; j < 10; j++) {
            grid[i][j] = 0;
         }
      }

      // Define battleship sizes
      int[] shipSizes = {2, 3, 3, 4, 5};

      // Randomly instantiate battleships
      for (int i = 0; i < shipSizes.length; i++) {
          int size = shipSizes[i];
          boolean shipPlaced = false;
          while (!shipPlaced) {
              // Generate random starting coordinates
              int x = (int)(Math.random() * 9);
              int y = (int)(Math.random() * 9);

              // Generate random orientation (0 for horizontal, 1 for vertical)
              int orientation = (int)(Math.random());

              // Check if the battleship can be placed at the generated coordinates
              boolean canPlaceShip = true;
              if (orientation == 0) { // horizontal
                  if (x + size > 10) {
                      canPlaceShip = false;
                  } else {
                      for (int j = x; j < x + size; j++) {
                          if (grid[j][y] == 1) {
                              canPlaceShip = false;
                              break;
                          }
                      }
                  }
              } else { // vertical
                  if (y + size > 10) {
                      canPlaceShip = false;
                  } else {
                      for (int j = y; j < y + size; j++) {
                          if (grid[x][j] == 1) {
                              canPlaceShip = false;
                              break;
                          }
                      }
                  }
              }

              // Place the battleship on the grid if it can be placed
              if (canPlaceShip) {
                  if (orientation == 0) { // horizontal
                      for (int j = x; j < x + size; j++) {
                          grid[j][y] = 1;
                      }
                  } else { // vertical
                      for (int j = y; j < y + size; j++) {
                          grid[x][j] = 1;
                      }
                  }
                  ships[i][0] = x;
                  ships[i][1] = y;
                  ships[i][2] = size;
                  ships[i][3] = orientation;
                  shipPlaced = true;

                  for(int e = 0; e < ships.length; e++)
                  {
                     for(int z = 0; z < 4; z++)
                     
                     {
                        System.out.println(ships[e][z] + "");
                     }

                  }
              }
          }
      }

      
  }
}
