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
import java.awt.Image.*;
import java.awt.image.BufferedImage;


public class FinalPanel extends JPanel {
static boolean gameStarted = false;
static JFrame frame = new JFrame("hey");
static int xClicked, yClicked, counterX, counterY, xCount;
static int[][] boundsArray = new int[100][4];
static JLabel boardLabel, c2label, s2label, d2label;
static int carrierRotation = 1;
static int subRotation = 1;
static int destroyerRotation = 1;

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
   for(int z = 0; z < 100; z++) {
      if(x > array[z][0] && x < array[z][2] && y > array[z][1] && y < array[z][3]) {
         return z;
      }

   }
   return -1;
   

   

   

}


public void crusierListener(MouseEvent e){

   xClicked = e.getX();
   yClicked = e.getY();

   
   counterX = 70;
   counterY = 64;
   xCount = 0;
   int aN = 47;
   

   int searched= search(boundsArray, xClicked, yClicked);
   Image c2Scaled;
   int scaled = 0;
   int bounds= 0;
   Cruiser cruiser = new Cruiser("cruiserNoBG.png", boundsArray, searched);
   if(searched != -1){
      
      if(SwingUtilities.isLeftMouseButton(e)){
        Object[] array = cruiser.show(carrierRotation, true);
        c2Scaled = (Image) array[0];
        scaled = Integer.parseInt((String)array[1]);
        bounds = Integer.parseInt((String)array[2]);
        carrierRotation = 1;

      }
      else if(SwingUtilities.isRightMouseButton(e)){
         Object[] array = cruiser.show(carrierRotation, false);
         c2Scaled = (Image) array[0];
         scaled = Integer.parseInt((String)array[1]);
         bounds = Integer.parseInt((String)array[2]);
         carrierRotation++;

      } else {
            c2Scaled = null;
         
      }
      ImageIcon cruiserIcon = new ImageIcon(c2Scaled);
      c2label.setVisible(false); 

      c2label = new JLabel(cruiserIcon);

      int x = boundsArray[searched][0];
      int y = boundsArray[searched][1];
      c2label.setBounds(x-53-188-8 - scaled + bounds, y-190-98-8 + scaled - bounds, 640, 640);
      frame.add(c2label);
      c2label.setVisible(true);
      Container container = c2label.getParent();
      container.setComponentZOrder(c2label, 0);
      container.repaint();
   }
   
   
   
   

}
public void subListener(MouseEvent e){

   xClicked = e.getX();
   yClicked = e.getY();

   
   counterX = 70;
   counterY = 64;
   xCount = 0;
   int aN = 47;
   

   int searched= search(boundsArray, xClicked, yClicked);
   Image s2Scaled;
   int scaled = 0;
   int bounds= 0;
   Submarine sub = new Submarine("SubmarineNoBG.png", boundsArray, searched);
   if(searched != -1){
      
      if(SwingUtilities.isLeftMouseButton(e)){
        Object[] array = sub.show(subRotation, true);
        s2Scaled = (Image) array[0];
        scaled = Integer.parseInt((String)array[1]);
        bounds = Integer.parseInt((String)array[2]);
        subRotation = 1;

      }
      else if(SwingUtilities.isRightMouseButton(e)){
         Object[] array = sub.show(subRotation, false);
         s2Scaled = (Image) array[0];
         scaled = Integer.parseInt((String)array[1]);
         bounds = Integer.parseInt((String)array[2]);
         subRotation++;

      } else {
            s2Scaled = null;
         
      }
      ImageIcon subIcon = new ImageIcon(s2Scaled);
      s2label.setVisible(false);

     s2label = new JLabel(subIcon);

      int x = boundsArray[searched][0];
      int y = boundsArray[searched][1];
      s2label.setBounds(x-53-188-8 - scaled + bounds, y-190-98-8 + scaled - bounds, 640, 640);
      frame.add(s2label);
      c2label.setVisible(true);
      Container container = s2label.getParent();
      container.setComponentZOrder(s2label, 0);
      container.repaint();
   }
   
   
   
   

}
public void destroyerListener(MouseEvent e){

   xClicked = e.getX();
   yClicked = e.getY();

   
   counterX = 70;
   counterY = 64;
   xCount = 0;
   int aN = 47;
   

   int searched= search(boundsArray, xClicked, yClicked);
   Image d2Scaled;
   int scaled = 0;
   int bounds= 0;
   Destroyer destroyer = new Destroyer("DestroyerNoBG.png", boundsArray, searched);
   if(searched != -1){
      
      if(SwingUtilities.isLeftMouseButton(e)){
        Object[] array = destroyer.show(destroyerRotation, true);
        d2Scaled = (Image) array[0];
        scaled = Integer.parseInt((String)array[1]);
        bounds = Integer.parseInt((String)array[2]);
        destroyerRotation = 1;

      }
      else if(SwingUtilities.isRightMouseButton(e)){
         Object[] array = destroyer.show(destroyerRotation, false);
         d2Scaled = (Image) array[0];
         scaled = Integer.parseInt((String)array[1]);
         bounds = Integer.parseInt((String)array[2]);
         destroyerRotation++;

      } else {
            d2Scaled = null;
         
      }
      ImageIcon deIcon = new ImageIcon(d2Scaled);
      d2label.setVisible(false);

     d2label = new JLabel(deIcon);

      int x = boundsArray[searched][0];
      int y = boundsArray[searched][1];
      d2label.setBounds(x-53-188-8-23 - scaled + bounds, y-190-98-8 + scaled - bounds, 640, 640);
      frame.add(d2label);
      d2label.setVisible(true);
      Container container = d2label.getParent();
      container.setComponentZOrder(d2label, 0);
      container.repaint();
   }
   
   
   
   

}


public void gameStart() {
   if(gameStarted == false) { 
      addMouseListener(
         new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            //crusierListener(e);
            //subListener(e);  
            destroyerListener(e);
            }
               
               
               
               
            
            }
         
         
         );
      
      
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
       boardLabel = new JLabel(board);
      boardLabel.setBounds(-20, -20, 640,640);
      //add(boardLabel);
   
      ImageIcon sub = new ImageIcon("SubmarineNoBG.PNG");
      Image subScaling = sub.getImage();
      Image newSub = subScaling.getScaledInstance(133, 46, java.awt.Image.SCALE_SMOOTH);
      sub = new ImageIcon(newSub);
      //180 degrees
      //JLabel subLabel = new JLabel(rotateIcon(rotateIcon(sub,90), 90));
      //270 degrees
      s2label = new JLabel(sub);
      s2label.setBounds(450, 20, 640,640);
      
      
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
      c2label = new JLabel(cruiser);
      c2label.setBounds(450, 110, 640, 640);
      
      ImageIcon destroyer = new ImageIcon("destroyerNoBG.png");
      Image dScale = destroyer.getImage();
      Image dScaled = dScale.getScaledInstance(90, 30, java.awt.Image.SCALE_SMOOTH);
      destroyer = new ImageIcon(dScaled);
      d2label = new JLabel(destroyer);
      d2label.setBounds(450, 180, 640, 640);
      //d2label.setBounds(17, -96, 17 + 190, -96+460); //This is (70, 64) starting point with 190 460 scale applied to it 
      
      ImageIcon frame = new ImageIcon("frameNoBG.png");
      Image fScale = frame.getImage();
      Image fScaled = fScale.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
      frame = new ImageIcon(fScaled);
      JLabel flabel = new JLabel(frame);
      flabel.setBounds(455, 30, 640, 640);
      
      
   
      
      
      add(flabel);
      add(s2label);
      add(blabel);
      add(clabel);
      add(c2label);
      add(d2label);
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
