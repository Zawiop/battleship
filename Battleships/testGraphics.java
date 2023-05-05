import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;


public class testGraphics
{
   public static void main(String[] args) throws MalformedURLException {
       //URL url = new URL("https://media.tenor.com/8McIGu0Tf_QAAAAi/fire-joypixels.gif");
       ImageIcon icon = new ImageIcon("Battleship.PNG");
       JLabel label = new JLabel(icon);
    
       JFrame f = new JFrame();
       f.getContentPane().add(label);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.pack();
       f.setLocationRelativeTo(null);
       f.setVisible(true);
   }
}
