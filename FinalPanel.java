	/*****************************************************************
	* Panel, contains everything as well as all visual commands
	 
	* @Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.net.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Image.*;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


public class FinalPanel extends JPanel {
   static boolean gameStarted = false;
   static JFrame frame = new JFrame("Battleship");
   static int xClicked, yClicked, counterX, counterY, xCount;
   static int[][] boundsArray = new int[100][4];
   
   static int xTL1 = 70;
   static int yTL1 = 64;
   static int xBR1 = 540;
   static int yBR1 = 534;
   
   
   /**
   * Where all elements will be instantiated and added, located in the constructor for default behavior
   */
   public FinalPanel()
   {
      this.setLayout(null);
      arraySizes(boundsArray);
      gameStart();
      System.out.println(search(boundsArray, xClicked, yClicked) + "");
   
   }
   
   public static int[][] arraySizes(int[][]  array)
   {
      
      counterX = 70;
      counterY = 64;
      xCount = 0;
      int aN = 47;
      for(int y = 0; y < 10; y++)
         {
         for(int x = 0; x < 10; x++) {
            int n = 10*y + x;
            array[n][0] = counterX;
            array[n][1] = counterY;
            array[n][2] = counterX + aN;
            array[n][3] = counterY + aN;
            counterX = counterX + aN;
         }
         counterX = 70;
         counterY += aN;
         
      }
      
      return array;
   }
   
   public int search(int[][] array, int x, int y)
   {
      // int returnVal = -99;
//       for(int a = 0; a < 10; a++)
//       {
//          for(int x = 0; x < 10; x++) {
//             int n = 10*a + x;
//             System.out.println("" + n);
//             
//             boundsArray[n][0] = counterX;
//             boundsArray[n][1] = counterY;
//             boundsArray[n][2] = counterX + aN;
//             boundsArray[n][3] = counterY + aN;
//             counterX = counterX + aN;
//          }
//       counterX = 70;
//       counterY += aN;
      return 4;
 
      

      
   
   }
   
   public void gameStart() {
      if(gameStarted == false) {
          
         addMouseListener(
            new MouseAdapter() {
               public void mouseClicked(MouseEvent e) {
                  xClicked = e.getX();
                  yClicked = e.getY();
//                   System.out.println(search(boundsArray, xClicked, yClicked));
                  if(((xClicked > xTL1) && (xClicked < xBR1)) && ((xClicked < xBR1) && (xClicked < xBR1)))
                  {
                  
                  }
                  
                  counterX = 70;
                  counterY = 64;
                  xCount = 0;
                  int aN = 47;
                  for(int y = 0; y < 10; y++)
                     {
                     for(int x = 0; x < 10; x++) {
                        int n = 10*y + x;
                        
                        boolean bool1 = x > boundsArray[n][0];
                        boolean bool2 = y < boundsArray[n][1];
                        boolean bool3 = x < boundsArray[n][2];
                        boolean bool4 = y > boundsArray[n][3];
                        
                        
                        System.out.println(bool1 + " " + bool2 + " " + bool3 + " " + bool4);
                        System.out.println(boundsArray[n][0] + " " + boundsArray[n][1] + " " + boundsArray[n][2] + " " + boundsArray[n][3]);
                        
                        boundsArray[n][1] = counterY;
                        boundsArray[n][2] = counterX + aN;
                        boundsArray[n][3] = counterY + aN;
                        counterX = counterX + aN;
                     }
                     counterX = 70;
                     counterY += aN;
             
                  }
                  
                  
                  
                  
               
               }
            
            
            });
         
         // for(int x = 0; x < 100; x++)
      //          {
      //             for(int y = 0; y < 4; y++)
      //             {
      //                System.out.println(boundsArray[x][y] + "");
      //             }   
      //          }
         
         JButton help = new JButton("Instructions Menu");
         JButton set = new JButton("Set Ships");
         JButton reset = new JButton("Reset Board");
         help.addActionListener(new helpMenu());
         set.addActionListener(new setShips());
         reset.addActionListener(new resetShips());
         set.setBounds(700, 50, 150, 25);
         help.setBounds(700, 0, 150, 25);
         reset.setBounds(700, 100, 150, 25);
         
         add(help);
         add(set);
         add(reset);
      
         ImageIcon board = new ImageIcon("board.JPG");
         JLabel boardLabel = new JLabel(board);
         boardLabel.setBounds(-20, -20, 640,640);
         //add(boardLabel);
      
         ImageIcon sub = new ImageIcon("SubmarineNoBG.PNG");
         Image subScaling = sub.getImage();
         Image newSub = subScaling.getScaledInstance(46, 133, java.awt.Image.SCALE_SMOOTH);
         sub = new ImageIcon(newSub);
         //180 degrees
         //JLabel subLabel = new JLabel(rotateIcon(rotateIcon(sub,90), 90));
         //270 degrees
         JLabel subLabel = new JLabel(rotateIcon(sub, 270));
         subLabel.setBounds(450, 20, 640,640);
         
         
         ImageIcon bship = new ImageIcon("BattleshipNoBG.png");
         Image bScale = bship.getImage();
         Image bScaled = bScale.getScaledInstance(185, 31, java.awt.Image.SCALE_SMOOTH);
         bship = new ImageIcon(bScaled);
         JLabel blabel = new JLabel(bship);
         blabel.setBounds(450, -55, 640, 640);
         
         ImageIcon carrier = new ImageIcon("carrierNoBG.png");
         Image cScale = carrier.getImage();
         Image cScaled = cScale.getScaledInstance(240, 50, java.awt.Image.SCALE_SMOOTH);
         carrier = new ImageIcon(cScaled);
         JLabel clabel = new JLabel(carrier);
         clabel.setBounds(450, -125, 640, 640);
         
         ImageIcon cruiser = new ImageIcon("cruiserNoBG.png");
         Image c2Scale = cruiser.getImage();
         Image c2Scaled = c2Scale.getScaledInstance(140, 45, java.awt.Image.SCALE_SMOOTH);
         cruiser = new ImageIcon(c2Scaled);
         JLabel c2label = new JLabel(cruiser);
         c2label.setBounds(450, 110, 640, 640);
         
         ImageIcon destroyer = new ImageIcon("destroyerNoBG.png");
         Image dScale = destroyer.getImage();
         Image dScaled = dScale.getScaledInstance(90, 30, java.awt.Image.SCALE_SMOOTH);
         destroyer = new ImageIcon(dScaled);
         JLabel dlabel = new JLabel(destroyer);
         //dlabel.setBounds(450, 180, 640, 640);
         dlabel.setBounds(17, -96, 17 + 190, -96+460); //This is (70, 64) starting point with 190 460 scale applied to it 
         
         ImageIcon frame = new ImageIcon("frameNoBG.png");
         Image fScale = frame.getImage();
         Image fScaled = fScale.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
         frame = new ImageIcon(fScaled);
         JLabel flabel = new JLabel(frame);
         flabel.setBounds(455, 30, 640, 640);
         
         
      
         
         
         add(flabel);
         add(subLabel);
         add(blabel);
         add(clabel);
         add(c2label);
         add(dlabel);
         add(flabel);
         //add(subLabel);
         add(boardLabel);
         
      
      
         
      
         //gameStarted = true;
      }
   }
   public void playGame(Graphics g) {
      if(gameStarted == true) {
         g.setColor(new Color(103,179,201));
         g.drawRect(50,50,90,70);
      }
      
   
   }
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      //gameStart(g);
     // playGame(g);
    
   }
   public static void main(String[] args)  throws MalformedURLException {
     
      frame.setSize(1500, 600);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   
      frame.setContentPane(new FinalPanel());
      frame.setVisible(true);
   }
  

   private  class helpMenu implements ActionListener {
      /**
      * What the help menu button will actually do 
      */
      public void actionPerformed(ActionEvent e) {
         
         JOptionPane.showMessageDialog(frame,"How to play Battleship: \n" +"First you must place your ships on the grid, and once you have set them, press the set ships button. Next, your oppponent, a AI, will place their ships in location. \n"+ "Soon after you get to fire at the opponents grid in alternating turns, each shot hitting one tile and letting you know if you hit or miss.", "Help Menu"
            , JOptionPane.QUESTION_MESSAGE,null);
         //whenever we add the frame in
      }
   }
   private class setShips implements ActionListener {
      /**
      * What the setShips button will actually do 
      */
      public void actionPerformed(ActionEvent e) {
        
        
      }  
   }
   private class resetShips implements ActionListener {
      /**
      * What the setShips button will actually do 
      */
      public void actionPerformed(ActionEvent e) {
        
      }
   }

   private ImageIcon rotateIcon(ImageIcon icon, int angle) {
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
