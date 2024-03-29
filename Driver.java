/*****************************************************************
* The Driver is the class that contains the main method which is
* used to run the program. The Driver has no attributes and knows
* only how to run the program.
*
* Kiran Ganeshan 
****************************************************************/
import javax.swing.JFrame;
public class Driver {
   /************************************************************* 
   * Runs the program
   **************************************************************/
   public static void main(String[] args) throws Exception{
      JFrame frame = new JFrame("Live Weather by Wunderground");
      frame.setSize(955, 1100);
      frame.setLocation(0,0);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Panel());
      frame.setVisible(true);
      Runtime.getRuntime().addShutdownHook(
         new Thread() {            
            public void run() {                
               Weather.loggerWrite("Exiting Application...");            
            }       
         }
      ); 
   }
}
