/*****************************************************************
* The DayPanel is a JPanel that displays basic weather
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
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
public class DayPanel extends JPanel {
  private static JSONObject current;
  /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API
   **************************************************************/
  static{}
  /************************************************************* 
   * Instantiates the DayPanel object
   **************************************************************/
  public DayPanel(){}
}
