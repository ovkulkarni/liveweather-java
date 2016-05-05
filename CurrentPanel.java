import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;

public class CurrentPanel extends JPanel
{ 
   private static JSONObject current;
   static{
      try{
         current = Weather.getCurrentConditions("Washington");
      }
      catch(Exception e){
         current = new JSONObject();
      }
   }
   public CurrentPanel()
   {
      try{
         setLayout(new GridLayout(5, 0));
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
   
   public void addImage(JPanel p) throws Exception{
      URL url = new URL(Weather.getImageURL(current));
      BufferedImage image = ImageIO.read(url);
      JLabel label = new JLabel(new ImageIcon(image));
      p.add(label);
   }
   
   public void addDate(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getTimeAndDate(current));
      p.add(label);
   }
   public void addCondition(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getCondition(current));
      p.add(label);
   }
   public void addTemp(JPanel p) throws Exception{
      JLabel label = new JLabel("Temperature: " + Weather.getTemperature(current) + "                   Feels Like: " + Weather.getActualTemp(current));
      p.add(label);
   }
   public void addLocation(JPanel p) throws Exception{
      JLabel label = new JLabel(Weather.getFullName(current));
      p.add(label);
   }
      
      
}
