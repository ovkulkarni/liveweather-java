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
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
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
      Font sample = new Font("Serif", Font.PLAIN, 20);
      try{
         setLayout(new GridLayout(6, 0));
         addLocation(this, sample);
         addImage(this);
         addDate(this, sample);
         addCondition(this, sample);
         addTemp(this, sample);
         addFeelsLike(this, sample);
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
   * @param f  A font with which to display the label
   **************************************************************/
   public void addDate(JPanel p, Font f) throws Exception{
      JLabel label = new JLabel(Weather.getTimeAndDate(current));
      String unformat = label.getText();
      String wd = formatWeekday(unformat.substring(0,3));
      String date = formatDate(unformat.substring(5,16));
      //unformat = unformat.substring(16,unformat.length());
      
      String finalText = wd + ", " + date;
      label.setText(finalText);
      label.setFont(f);
      p.add(label);
   }
   /************************************************************* 
   * Adds a label showing a description of the current conditions
   * to a JPanel.
   * 
   * @param p  A Panel to add the label to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addCondition(JPanel p, Font f) throws Exception{
      JLabel label = new JLabel(Weather.getCondition(current));
      label.setFont(f);
      p.add(label);
   }
   /************************************************************* 
   * Adds a label showing the current temperature to a JPanel.
   * 
   * @param p  A Panel to add the label to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addTemp(JPanel p, Font f) throws Exception{
      JLabel label = new JLabel("Temperature: " + Weather.getTemperature(current));
      label.setFont(f);
      p.add(label);
   }
   /************************************************************* 
   * Adds a label showing the "feels like" temperature to a JPanel.
   * 
   * @param p  A Panel to add the label to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addFeelsLike(JPanel p, Font f) throws Exception{
      JLabel label = new JLabel("Feels Like: " + Weather.getActualTemp(current));
      label.setFont(f);
      p.add(label);
   }
   /************************************************************* 
   * Adds a label showing the location from which the Wunderground
   * API is showing weather to a JPanel
   * 
   * @param p  A Panel to add the label to ("this")
   * @param f  A font with which to display the label
   **************************************************************/
   public void addLocation(JPanel p, Font f) throws Exception{
      JLabel label = new JLabel(Weather.getFullName(current));
      label.setFont(f);
      p.add(label);
   }
   /************************************************************* 
   * Formats the weekday text received form Wunderground API
   * 
   * @param p  The weekday string given by Wunderground API
   * @return   The formatted weekday
   **************************************************************/
   public String formatWeekday(String wd){
      switch(wd){
         case "Mon":wd="Monday";break;
         case "Tue":wd="Tuesday";break;
         case "Wed":wd="Wednesday";break;
         case "Thu":wd="Thursday";break;
         case "Fri":wd="Friday";break;
         case "Sat":wd="Saturday";break;
         case "Sun":wd="Sunday";break;
      }
      return wd;
   }
   /************************************************************* 
   * Formats the date and time text received form Wunderground API
   * 
   * @param p  The date and time string given by Wunderground API
   * @return   The formatted date
   **************************************************************/
   public String formatDate(String date){
      String day = date.substring(0,date.indexOf(" "));
      int daynum = Integer.parseInt(day);
      if((daynum==1)||(daynum==21)||(daynum==31)){day=day+"st";}
      else if((daynum==2)||(daynum==22)){day=day+"nd";}
      else if((daynum==3)||(daynum==23)){day=day+"nd";}
      else{day=day+"th";}
      date = date.substring(date.indexOf(" ")+1,date.length());
      String month = date.substring(0,date.indexOf(" "));
      date = date.substring(date.indexOf(" ")+1,date.length());
      String year = date;
      return month + " " + day + ", " + year;
   }
}
