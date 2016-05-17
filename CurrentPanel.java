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
   static{
      try{
         current = Weather.getCurrentConditions("Washington");
      }
      catch(Exception e){
         current = new JSONObject();
      }
   }
   /************************************************************* 
   * Instantiates the CurrentPanel object
   **************************************************************/
   public CurrentPanel()
   {
      try{
         setLayout(new GridLayout(6, 0));
         addLocation(this);
         addImage(this);
         addDate(this);
         addCondition(this);
         addTemp(this);
         
      }
      catch(Exception e){
         System.out.println(e);
      }
      
   }
   /************************************************************* 
   * Adds an image depicting the current conditions to a JPanel.
   * 
   * @param p  A Panel to add the image to ("this")
   **************************************************************/
   public void addImage(JPanel p) throws Exception{
      URL url = new URL(Weather.getImageURL(current));
      BufferedImage image = ImageIO.read(url);
      JLabel label = new JLabel(new ImageIcon(image));
      p.add(label);
   }
   /************************************************************* 
   * Adds a label showing the time and date to a JPanel.
   * 
   * @param p  A Panel to add the label to ("this")
   **************************************************************/
   public void addDate(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getTimeAndDate(current));
      p.add(label);
   }
   /************************************************************* 
   * Adds a label showing a description of the current conditions
   * to a JPanel.
   * 
   * @param p  A Panel to add the label to ("this")
   **************************************************************/
   public void addCondition(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getCondition(current));
      p.add(label);
   }
   /************************************************************* 
   * Adds two labels showing the current temperature and the
   * "feels like" temperature to a JPanel.
   * 
   * @param p  A Panel to add the labels to ("this")
   **************************************************************/
   public void addTemp(JPanel p) throws Exception{
      JLabel label = new JLabel("Temperature: " + Weather.getTemperature(current));
      JLabel label2 = new JLabel("Feels Like: " + Weather.getActualTemp(current));
      p.add(label);
       p.add(label2);
   }
   /************************************************************* 
   * Adds a label showing the location from which the Wunderground
   * API is showing weather to a JPanel
   * 
   * @param p  A Panel to add the label to ("this")
   **************************************************************/
   public void addLocation(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getFullName(current));
      p.add(label);
   }
}
