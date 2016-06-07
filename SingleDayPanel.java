/*****************************************************************
* The SingleDayPanel is a JPanel that displays information from
* a single day within a ten day forecast. The SingleDayPanel has
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
public class SingleDayPanel extends JPanel {
   private static JSONObject daydata;
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API
   **************************************************************/
   public void update(JPanel p, int day, Border b, String location) throws Exception{
      try{
         p.setBorder(b);
         p.setPreferredSize(new Dimension(89,155));
         JSONArray dayarr = Weather.getForecastArray(location);
         daydata = Weather.getDayByNum(day, dayarr);
         p.setLayout(new GridLayout(3, 0));
         addDate(p);
         addImage(p);
         addTemp(p);
      }
      catch(Exception e){
         daydata = new JSONObject();
         System.out.println(e);
      }
   }
   /************************************************************* 
   * Instantiates the SingleDayPanel object
   **************************************************************/
   public SingleDayPanel(int day, Border b, String location){
      try{
         update(this, day,b, location);
      }
      catch(Exception e){
         JLabel label = new JLabel("Things are borkened.");
         add(label);
      }
   }
   
   public void addImage(JPanel p) throws Exception{
      JLabel label = Weather.getImageFromURL(Weather.getForecastImageURL(daydata));
      p.add(label);
   }
   
   public void addDate(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getForecastDate(daydata),SwingConstants.CENTER);
      p.add(label);
   }
   
   public void addTemp(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getForecastTemps(daydata),SwingConstants.CENTER);
      p.add(label);
   }
}
