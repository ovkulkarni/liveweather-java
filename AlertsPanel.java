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
public class AlertsPanel extends JPanel {
   private static JSONObject hourdata;
   private static JSONObject alertdata;
   private static JTextArea label;
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API
   **************************************************************/
   public void update(String location) throws Exception{
      try{
         JSONArray alertarr = Weather.getAlertsArray(location);
         Font alertFont = new Font("Sans Serif", Font.BOLD, 20);
         if(alertarr.length() == 0){
            label = new JTextArea("No Alerts at this time.");
            label.setWrapStyleWord(true);
            add(label);
         }
         else{
            for(int i = 0; i < alertarr.length(); i++)
               alertdata = Weather.getAlertObject(i, alertarr);
            label = new JTextArea(Weather.getAlertMessage(alertdata));
            label.setWrapStyleWord(true);
            label.setOpaque(true);
            label.setBackground(Color.RED);
            label.setForeground(Color.YELLOW);
            label.setFont(alertFont);
            add(label);  
         }
      }
      catch(Exception e){
         hourdata = new JSONObject();
         Weather.loggerWrite("ERROR: " + e);
      }
   }
   /************************************************************* 
   * Instantiates the HourPanel object
   **************************************************************/
   public AlertsPanel(Border b, String location){
      try{
         setBorder(b);
         update(location);
      }
      catch(Exception e){
         JLabel label = new JLabel("Things are borkened.");
         add(label);
         Weather.loggerWrite("ERROR: " + e);
      }
   }
}
