import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
import java.awt.event.*;
/*****************************************************************
* The CurrentPanel is JPanel that displays basic weather
* information, such as time and current condition. CurrentPanel
* has a JSONObject current, and it knows how to instantiate
* that JSONObject with information retreived from the Wunderground 
* API. The CurrentPanel knows how to update and instantiate itself.
* It also knows how to instantiate itself, and how to add
* an Image depicting the current condition, a date, a condition
* description, a temperature, and a location to any Panel.
*
* Kiran Ganeshan
****************************************************************/
public class CurrentPanel extends JPanel
{ 
   private Font sample;
   private static JSONObject current;
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API with a given location and updates
   * the information on the Panel using the information
   * from the WUnderground API.
   *
   * @param sample   The font used to display information
   * @param location The location to display information about
   **************************************************************/
   public void update(Font sample, String location) throws Exception{}
   /************************************************************* 
   * Instantiates the CurrentPanel object using a location
   * that is geolocated in Panel/Weather
   *
   * @param loc   The location to display information about
   **************************************************************/
   public CurrentPanel(String loc) throws Exception{}
   /************************************************************* 
   * Adds an image depicting the current conditions to CurrentPanel.
   **************************************************************/
   public void addImage() throws Exception{}
   /************************************************************* 
   * Adds a label showing the time and date to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addDate(Font f) throws Exception{}
   /************************************************************* 
   * Adds a label showing a description of the current conditions
   * to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addCondition(Font f) throws Exception{}
   /************************************************************* 
   * Adds a label showing the current temperature to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addTemps(Font f) throws Exception{}
   /************************************************************* 
   * Adds a label showing the "feels like" temperature to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addFeelsLike(Font f) throws Exception{}
   /************************************************************* 
   * Adds a label showing the location from which the Wunderground
   * API is showing weather to CurrentPanel
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addLocation(Font f) throws Exception{}
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
