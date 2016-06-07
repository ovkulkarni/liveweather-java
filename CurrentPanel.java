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
   public void update(Font sample, String location) throws Exception{
      try{
         current = Weather.getCurrentConditions(location);
         addLocation(sample);
         addImage();
         addDate(sample);
         addCondition(sample);
         addTemps(sample);
         Weather.loggerWrite("Updated CurrentPanel.");
      }
      catch(Exception e){
         current = null;
         Font errorFont = new Font("Sans Serif", Font.BOLD, 30);
         JLabel errorLabel = new JLabel("There was an error retrieving data for " + Weather.location, SwingConstants.CENTER);
         errorLabel.setFont(errorFont);
         add(errorLabel);
         Weather.loggerWrite("ERROR: " + e);
      }
   }
   /************************************************************* 
   * Instantiates the CurrentPanel object using a location
   * that is geolocated in Panel/Weather
   *
   * @param loc   The location to display information about
   **************************************************************/
   public CurrentPanel(String loc) throws Exception
   {
      Weather.loggerWrite("Instantiating CurrentPanel");
      sample = new Font("Sans Serif", Font.PLAIN, 20);
      setLayout(new GridLayout(6, 0));
      Weather.loggerWrite("Set Layout as GridLayout");
      Weather.location = loc;
      Weather.loggerWrite("Set location to " + Weather.location);
      update(sample, loc);
   }
   /************************************************************* 
   * Adds an image depicting the current conditions to CurrentPanel.
   **************************************************************/
   public void addImage() throws Exception{
      JLabel label = Weather.getImageFromURL(Weather.getImageURL(current));
      add(label);
   }
   /************************************************************* 
   * Adds a label showing the time and date to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addDate(Font f) throws Exception{
      JLabel label = new JLabel(Weather.getTimeAndDate(current), SwingConstants.CENTER);
      String unformat = label.getText();
      String wd = formatWeekday(unformat.substring(0,3));
      String date = formatDate(unformat.substring(5,16));
      
      String finalText = wd + ", " + date;
      label.setText(finalText);
      label.setFont(f);
      add(label);
   }
   /************************************************************* 
   * Adds a label showing a description of the current conditions
   * to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addCondition(Font f) throws Exception{
      JLabel label = new JLabel(Weather.getCondition(current), SwingConstants.CENTER);
      label.setFont(f);
      add(label);
   }
   /************************************************************* 
   * Adds a label showing the current temperature to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addTemps(Font f) throws Exception{
      String temp = Weather.getTemperature(current);
      temp = temp.substring(0,temp.indexOf("("));
      String str = "<html>Temperature: ";
      str += temp;
      str += "<br>";
      String actual = Weather.getActualTemp(current);
      str += "Feels like: ";
      str += actual.substring(0, actual.indexOf("("));
      str += "</html>";
      JLabel label = new JLabel(str, SwingConstants.CENTER);
      label.setFont(f);
      add(label);
   }
   /************************************************************* 
   * Adds a label showing the "feels like" temperature to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addFeelsLike(Font f) throws Exception{
      String temp = Weather.getActualTemp(current);
      temp = temp.substring(0,temp.indexOf("("));
      JLabel label = new JLabel("Feels like: " + temp, SwingConstants.CENTER);
      label.setFont(f);
      add(label);
   }
   /************************************************************* 
   * Adds a label showing the location from which the Wunderground
   * API is showing weather to CurrentPanel
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addLocation(Font f) throws Exception{
      JLabel label = new JLabel(Weather.getFullName(current), SwingConstants.CENTER);
      label.setFont(f);
      add(label);
   }
   /************************************************************* 
   * Formats the weekday text received form Wunderground API
   * 
   * @param wd  The weekday string given by Wunderground API
   * @return    The formatted weekday
   **************************************************************/
   public String formatWeekday(String wd){
      switch(wd){
         case "Mon":wd="Monday";
            break;
         case "Tue":wd="Tuesday";
            break;
         case "Wed":wd="Wednesday";
            break;
         case "Thu":wd="Thursday";
            break;
         case "Fri":wd="Friday";
            break;
         case "Sat":wd="Saturday";
            break;
         case "Sun":wd="Sunday";
            break;
      }
      return wd;
   }
   /************************************************************* 
   * Formats the date and time text received form Wunderground API
   * 
   * @param date  The date and time string given by Wunderground API
   * @return      The formatted date
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
