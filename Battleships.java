	/*****************************************************************
	* An abstract class, works for all images
   * Has two methods that must be defined, show and rotate
	 
	* @Rohan Singh, Fabeun Rahman and Arrush Shah
	* @version 4/25/23
	****************************************************************/

   import javax.swing.*;
   
public abstract class Battleships{
      
   /**
   * The Image will show at the specified coordinates
   */
   public abstract Object[] show(int carrierRotation, boolean left);
   
   /**
   * The Image will show at the interval of 90 provided
   */
   public abstract ImageIcon rotate(ImageIcon icon, int angle); 
   
        
}
   
   

