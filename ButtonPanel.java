	/*****************************************************************
	* A Panel that contains helpful buttons for the game to operate
	 
	* @Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel 
{
   /**
   * Where all elements will be added, including the helpMenu button, the setShips button and the confirmShot button
   */   
   public ButtonPanel()
   {
   }
   /**
   * The listener for the helpMenu, opens up some general instructions
   */
   private class helpMenu implements ActionListener {
      /**
      * What the help menu button will actually do 
      */
       public void actionPerformed(ActionEvent e) {
       }
   }
   
   /**
   * The listener for the setShips, confirms the setting of the ships
   */
   
   private class setShips implements ActionListener {
       /**
       * What the setShips button will actually do 
       */
       public void actionPerformed(ActionEvent e) {
       }
   
   /**
   * The listener for the confirmShot button, confirms the player's shot 
   */
   
   private class confirmShot implements ActionListener {
       /**
       * What the confirmShot button will actually do 
       */
       public void actionPerformed(ActionEvent e) {
       }
   }
}
}

