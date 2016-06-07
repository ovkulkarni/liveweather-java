/*****************************************************************
* The HourPanel is a JPanel that displays information from
* a single day within a ten day forecast. The HourPanel has
* a JSONObject that it uses to retrieve information it needs to
* display, and it knows how to instantiate that object and itself.
*
* Kiran Ganeshan
****************************************************************/
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
import javax.swing.border.*;
public class HourPanel extends JPanel {
   private static JSONObject hourdata;
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API
   **************************************************************/
   public void update(JPanel p, int hour, Border b, String location) throws Exception{
      try{
         p.setBorder(b);
         p.setPreferredSize(new Dimension(89,155));
         JSONArray hourarr = Weather.getHourlyArray(location);
         hourdata = Weather.getHourObject(hour, hourarr);
         p.setLayout(new GridLayout(3, 0));
         addHour(p);
         addImage(p);
         addTemp(p);
      }
      catch(Exception e){
         hourdata = new JSONObject();
         Weather.loggerWrite("ERROR: " + e);
      }
   }
   /************************************************************* 
   * Instantiates the HourPanel object
   **************************************************************/
   public HourPanel(int day, Border b, String location){
      try{
         update(this, day,b, location);
      }
      catch(Exception e){
         JLabel label = new JLabel("Things are borkened.");
         add(label);
         Weather.loggerWrite("ERROR: " + e);
      }
   }
   
   public void addImage(JPanel p) throws Exception{
      JLabel label = Weather.getImageFromURL(Weather.getHourImageURL(hourdata));
      p.add(label);
   }
   
   public void addHour(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getHour(hourdata),SwingConstants.CENTER);
      p.add(label);
   }
   
   public void addTemp(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getHourTemp(hourdata),SwingConstants.CENTER);
      p.add(label);
   }
}
