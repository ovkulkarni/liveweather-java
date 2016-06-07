import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
import javax.swing.border.*;
/*****************************************************************
* The HourPanel is a JPanel that displays information from
* a single hour within a ten hour forecast. The HourPanel has
* a JSONObject that it uses to retrieve information it needs to
* display, and it knows how to instantiate that object and itself.
*
* Kiran Ganeshan
****************************************************************/
public class HourPanel extends JPanel {
   private static JSONObject hourdata;
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API and updates the HourPanel's 
   * displayed information based on new information retrieved
   * from the Wunderground API
   *
   * @param p        A Panel to update (this)
   * @param hour     The specific hour to update
   * @param b        A border to surround each hour
   * @param location A location to retrieve info from
   **************************************************************/
   public void update(JPanel p, int hour, Border b, String location) throws Exception{}
   /************************************************************* 
   * Instantiates the HourPanel object using information from
   * update method and Wunderground API
   *
   * @param day      The day to update
   * @param b        A border to surround each hour
   * @param location The location to get info from
   **************************************************************/
   public HourPanel(int day, Border b, String location){}
   /************************************************************* 
   * Adds the image to the HourPanel, which represents the
   * conditions visually
   *
   * @param p  The panel to add the image to
   **************************************************************/
   public void addImage(JPanel p) throws Exception{}
   /************************************************************* 
   * Adds the hour to the HourPanel
   *
   * @param p  The panel to add the hour to
   **************************************************************/
   public void addHour(JPanel p) throws Exception{}
   /************************************************************* 
   * Adds the temp to the HourPanel
   *
   * @param p  The panel to add the temp to
   **************************************************************/
   public void addTemp(JPanel p) throws Exception{}
}
