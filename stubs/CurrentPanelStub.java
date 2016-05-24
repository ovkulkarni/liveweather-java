import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
/*****************************************************************
* The CurrentPanel is a JPanel that displays basic weather
* information, such as time and current condition. CurrentPanel
* has a JSONObject current, and it knows how to instantiate
* that JSONObject with information retreived from the Wunderground 
* API. It also knows how to instantiate itself, and how to add
* an Image depicting the current condition, a date, a condition
* description, a temperature, and a location to any Panel (in this
* case, "this" will be passed to each of these methods.)
*
* Kiran Ganeshan
****************************************************************/
public class CurrentPanel extends JPanel
{ 
   private static JSONObject current;
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API
   **************************************************************/
   public void update(){}
   /************************************************************* 
   * Instantiates the CurrentPanel object, and then updates each
   * five seconds.
   **************************************************************/
   public CurrentPanel(){}
   /************************************************************* 
   * Adds an image depicting the current conditions to a JPanel.
   * 
   * @param p  A Panel to add the image to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addImage(JPanel p, Font f) throws Exception{}
   /************************************************************* 
   * Adds a label showing the time and date to a JPanel.
   * 
   * @param p  A Panel to add the label to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addDate(JPanel p, Font f) throws Exception{}
   /************************************************************* 
   * Adds a label showing a description of the current conditions
   * to a JPanel.
   * 
   * @param p  A Panel to add the label to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addCondition(JPanel p, Font f) throws Exception{}
   /************************************************************* 
   * Adds a label showing the current temperature to a JPanel.
   * 
   * @param p  A Panel to add the label to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addTemp(JPanel p, Font f) throws Exception{}
   /************************************************************* 
   * Adds a label showing the "feels like" temperature to a JPanel.
   * 
   * @param p  A Panel to add the label to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addFeelsLike(JPanel p, Font f) throws Exception{}
   /************************************************************* 
   * Adds a label showing the location from which the Wunderground
   * API is showing weather to a JPanel
   * 
   * @param p  A Panel to add the label to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addLocation(JPanel p, Font f) throws Exception{}
   /************************************************************* 
   * Formats the weekday text received form Wunderground API
   * 
   * @param wd  The weekday string given by Wunderground API
   * @return    The formatted weekday
   **************************************************************/
   public String formatWeekday(String wd){}
   /************************************************************* 
   * Formats the date and time text received form Wunderground API
   * 
   * @param date  The date and time string given by Wunderground API
   * @return      The formatted date
   **************************************************************/
   public String formatDate(String date){}
}
