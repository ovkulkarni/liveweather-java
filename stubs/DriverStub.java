import javax.swing.JFrame;
/*****************************************************************
* The Driver is the class that contains the main method which is
* used to run the program. The Driver has no attributes and knows
* only how to run the program.
*
* Kiran Ganeshan 
****************************************************************/
public class DriverStub {
   /************************************************************* 
   * Runs the program
   **************************************************************/
   public static void main(String[] args) throws Exception{
      JFrame frame = new JFrame("Live Weather");
      frame.setSize(560,540);
      frame.setLocation(400,100);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new PanelStub());
      frame.setVisible(true);
   }
}
