import javax.swing.*;

/*****************************************************************
* An abstract class, works for all images
* Has two methods that must be defined, show and rotate
   
* @Authors Rohan Singh, Fabeun Rahman and Arrush Shah
* @version 4/25/23
****************************************************************/


   
public abstract class Battleships{
      
   /**
   * The Image will show at the specified coordinates
   * @param Rotation how it is oriented
   * @param left Left click or not
   * @return Associated Image data
   * 
   */
   public abstract Object[] show(int Rotation, boolean left);
   
   /**
   * The Image will show at the interval of 90 provided
   * @param icon Image to rotate
   * @param angle How much, in intervals of 90
   * @return Rotated Image
   */
   public abstract ImageIcon rotate(ImageIcon icon, int angle); 
   
        
}
   
   

