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
public class SingleDayPanel extends JPanel {
   private static JSONObject daydata;
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API
   **************************************************************/
   public void update(JPanel p, int day) throws Exception{
      try{
         JSONArray dayarr = Weather.getForecastArray("Washington");
         daydata = Weather.getDayByNum(day, dayarr);
         p.setLayout(new GridLayout(3, 0));
         addImage(p);
         addDate(p);
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
   public SingleDayPanel(int day){
      try{
         update(this, day);
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
      JLabel label = new JLabel(Weather.getForecastDate(daydata));
      p.add(label);
   }
   
   public void addTemp(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getForecastTemps(daydata));
      p.add(label);
   }
}
