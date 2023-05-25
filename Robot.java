import java.util.Random;
import java.io.*;
import java.util.Arrays;
import java.math.*;





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
   private static int[] guessed = new int[100];
   private static int turnCounter = 0;
   private static int[] posOfGuesses;
   //private int hunting = 0;
   private static int huntHitCount = 0;
   private static int[] hits = new int[100];
   private static int[] misses = new int[100];
   private static int[] guesses = new int[100];
   private static int[][] scoreboard = new int[10][10];
   
   private static boolean hunting = false;
   private static boolean dirFound = false;
   private static int huntPoint = 0;
   private static int orientation;
   
   
   private static int[][] opponentShips;
   private static boolean[][] hasBeenAttacked;
   private static Random random;
   
   public Robot(int[][] opponentShips)
   {
      this.opponentShips = opponentShips;
      hasBeenAttacked = new boolean[10][10];
      random = new Random();
   }
   
   public static int[] nextAttack()
   {
      int row, col;
      for(int x = 0; x < opponentShips.length; x++)
      {
         for(int y = 0; y < opponentShips[x].length; y++)
         {
            if(x > 0 && !hasBeenAttacked[x][y])
            {
               row = x - 1;
               col = y;
               return new int[]{row, col};
            }

            if( x < 9 && !hasBeenAttacked[x + 1][y])
            {
               row = x + 1;
               col = y;
               return new int[]{row, col};
            }

            if(y > 0 && !hasBeenAttacked[x][y - 1])
            {
               row = x;
               col = y - 1;
            }

            if(y < 9 && !hasBeenAttacked[x][y + 1])
            {
               row = x;
               col = y+1;
            }
         }
      }

      do
      {
         double bruh = Math.random();
         double bruh2 = Math.random();
         System.out.println("" + bruh + " " + bruh2);
         row = (int)Math.floor((bruh * 10));
         col = (int)Math.floor((bruh2 * 10));
         System.out.println(row + " " + col);

      } while (!hasBeenAttacked[row][col]);
      // guessed[turnCounter - 1] = row * 10 + col;
      return new int[]{row, col};
   }


   public static void markAttack(int row, int col)
   {
      hasBeenAttacked[row][col] = true;
   }

   public static void main(String[] args)
   {
      System.out.println("e");
      int[][] grid = bruh()[0];
      opponentShips = grid;
      hasBeenAttacked = new boolean[10][10];
      
      for(int y = 0; y < 10; y++)
      {
         for(int z = 0; z < 10; z++)
         {
            hasBeenAttacked[y][z] = false;
         }
      }
      for(int x = 0; x < 100; x++)
      {
         markAttack(nextAttack()[0], nextAttack()[1]);
      }


      System.out.println(Arrays.deepToString(hasBeenAttacked).replace("], ", "]\n"));
      
      

   }
   public static int cRandGuess()
   {
      int returnVal = (int)(Math.random() * 99); 
      return returnVal;
   }


   

  public static int[][][] bruh()
  {
      int[][] grid = new int[10][10];
      int[][] ships = new int[5][4]; // creating 5 ships with [x, y, size, orientation] all stored in them

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
            }
         }
      }

      int[][][] bruh = new int[][][]{grid, ships};
      return bruh;
  }

}
