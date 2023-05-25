import java.util.Arrays;
import java.util.Random;

public class Robot {
   private static int[] guessed = new int[100];
   private static int turnCounter = 0;
   private static int[] posOfGuesses;
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

   public Robot(int[][] opponentShips) {
      this.opponentShips = opponentShips;
      hasBeenAttacked = new boolean[10][10];
      random = new Random();
   }

   public static int[] nextAttack() {
      int row, col;
      if (hunting) {
         int[] nextGuess = getNextHuntGuess(scoreboard);
         row = nextGuess[0];
         col = nextGuess[1];
      } else {
         do {
               row = random.nextInt(10);
               col = random.nextInt(10);
         } while (hasBeenAttacked[row][col]);
      }

      markAttack(row, col);
      return new int[]{row, col};
   }

   public static void markAttack(int row, int col) {
      hasBeenAttacked[row][col] = true;
      if (opponentShips[row][col] == 1) {
         scoreboard[row][col] = 3; // Hit
      } else {
         scoreboard[row][col] = 2; // Miss
      }
   }

   private static int[] getNextHuntGuess(int[][] grid) {
      int[] nextGuess = new int[2];
      int row = huntPoint / 10;
      int col = huntPoint % 10;
      boolean dirFound = false;
      int orientation = -1; // Initialize orientation to an invalid value

      while (!dirFound) {
         if (orientation == -1) { // Initial hunt guess
               if (isValidGuess(row - 1, col) && grid[row - 1][col] == 0) {
                  nextGuess[0] = row - 1;
                  nextGuess[1] = col;
                  orientation = 0; // Up
               } else if (isValidGuess(row + 1, col) && grid[row + 1][col] == 0) {
                  nextGuess[0] = row + 1;
                  nextGuess[1] = col;
                  orientation = 1; // Down
               } else if (isValidGuess(row, col - 1) && grid[row][col - 1] == 0) {
                  nextGuess[0] = row;
                  nextGuess[1] = col - 1;
                  orientation = 2; // Left
               } else if (isValidGuess(row, col + 1) && grid[row][col + 1] == 0) {
                  nextGuess[0] = row;
                  nextGuess[1] = col + 1;
                  orientation = 3; // Right
               } else {
                  huntPoint = (huntPoint + 1) % 100; // Move to the next position
                  row = huntPoint / 10;
                  col = huntPoint % 10;
               }
         } else { // Continue in the same direction
               if (orientation == 0 && isValidGuess(row - 1, col) && grid[row - 1][col] == 0) {
                  nextGuess[0] = row - 1;
                  nextGuess[1] = col;
               } else if (orientation == 1 && isValidGuess(row + 1, col) && grid[row + 1][col] == 0) {
                  nextGuess[0] = row + 1;
                  nextGuess[1] = col;
               } else if (orientation == 2 && isValidGuess(row, col - 1) && grid[row][col - 1] == 0) {
                  nextGuess[0] = row;
                  nextGuess[1] = col - 1;
               } else if (orientation == 3 && isValidGuess(row, col + 1) && grid[row][col + 1] == 0) {
                  nextGuess[0] = row;
                  nextGuess[1] = col + 1;
               } else { // Direction change required
                  orientation = -1; // Reset orientation
                  dirFound = false;
                  huntPoint = (huntPoint + 1) % 100; // Move to the next position
                  row = huntPoint / 10;
                  col = huntPoint % 10;
               }
         }
      }

      return nextGuess;
   }

   private static boolean isValidGuess(int row, int col) {
      return row >= 0 && row < 10 && col >= 0 && col < 10 && !hasBeenAttacked[row][col];
   }

   public static int[][][] generateShipsGrid() {
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

   public static void main(String[] args) {
      int[][][] opponentShipsFull = generateShipsGrid();
      int[][] opponentGrid = opponentShipsFull[0];
      Robot robot = new Robot(opponentGrid);
      for (int i = 0; i < 100; i++) {
         int[] nextAttack = robot.nextAttack();
         int row = nextAttack[0];
         int col = nextAttack[1];
      }
   }
}
