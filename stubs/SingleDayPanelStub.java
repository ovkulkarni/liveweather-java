import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
import javax.swing.border.*;
/*****************************************************************
* The SingleDayPanel is a JPanel that displays information from
* a single day within a ten day forecast. The SingleDayPanel has
* a JSONObject that it uses to retrieve information it needs to
* display, and it knows how to instantiate that object and itself.
*
* Kiran Ganeshan
****************************************************************/
public class SingleDayPanel extends JPanel {
   private static JSONObject daydata;
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API and uses that JSONObject to display
   * information about the 10 day forecast for each day
   *
   * @param p        The Panel to update
   * @param day      The day that this SingleDayPanel was assigned to
   * @param b        The Border to put around the SingleDayPanel
   * @param location The location from which to get info
   **************************************************************/
   public void update(JPanel p, int day, Border b, String location) throws Exception{}
   /************************************************************* 
   * Instantiates the SingleDayPanel object using information
   * about the border, location, and day
   *
   * @param day      The day that this SingleDayPanel was assigned to
   * @param b        The Border to put around the SingleDayPanel
   * @param location The location from which to get info
   **************************************************************/
   public SingleDayPanel(int day, Border b, String location){}
   /************************************************************* 
   * Adds the ImageIcon used to identify the current condition to
   * a panel.
   *
   * @param p  The Panel to add the image to
   **************************************************************/
   public void addImage(JPanel p) throws Exception{}
   /************************************************************* 
   * Adds the Date to a panel.
   *
   * @param p  The Panel to add the date to
   **************************************************************/
   public void addDate(JPanel p) throws Exception{}
   /************************************************************* 
   * Adds the temperature to a panel.
   *
   * @param p  The Panel to add the temperature to
   **************************************************************/
   public void addTemp(JPanel p) throws Exception{}
}
