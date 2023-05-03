import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HelpPanelContainer {
   public JPanel newJpanel() {
      JPanel panel = new JPanel();
      JLabel text = new JLabel("How to play Battleship: \n First you must place your ships on the grid, and once you have set them, press the set ships button. Next, your oppponent, a AI, will place their ships in location. Soon after you get to fire at the opponents grid in alternating turns, each shot hitting one tile and letting you know if you hit or miss.");
      panel.add(text);
      return panel;
   }

}