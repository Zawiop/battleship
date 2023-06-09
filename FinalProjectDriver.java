	/*****************************************************************
	* This is a basic driver, instantiates a new "finalDriverPanel", 
	* which handles all visual and size operands
	* Does not return anything
	 
	* @Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/


import javax.swing.JFrame;

public class FinalProjectDriver
{
   /**
   * Creates a "finalDriverPanel", which has all of the information based on the information in said class
   * Will also be the place where all the gameplay functionality actually happens
   */
   
   public static void main(String[] args)
   {
      
       JFrame frame = new JFrame("Battleship");
      frame.setSize(1500, 600);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      

      frame.setContentPane(new FinalPanel());
      frame.setVisible(true);

      
        
   }
}

