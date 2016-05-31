/*****************************************************************
* The CurrentPanel is CurrentPanel that displays basic weather
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
import java.awt.event.*;
public class CurrentPanel extends JPanel
{ 
   private Font sample;
   private static JSONObject current;
   private JButton updateButton;
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API
   **************************************************************/
   public void update(Font sample) throws Exception{
      try{
         current = Weather.getCurrentConditions("Washington");
         setLayout(new GridLayout(6, 0));
         addLocation(sample);
         addImage();
         addDate(sample);
         addCondition(sample);
         addTemp(sample);
         addFeelsLike(sample);
         addUpdateButton();
      }
      catch(Exception e){
         current = new JSONObject();
         System.out.println(e);
      }
   }
   /************************************************************* 
   * Instantiates the CurrentPanel object
   **************************************************************/
   public CurrentPanel() throws Exception
   {
      sample = new Font("Serif", Font.PLAIN, 20);
      update(sample);
      Thread.sleep(5000);
   }
   /************************************************************* 
   * Adds an image depicting the current conditions to CurrentPanel.
   **************************************************************/
   public void addImage() throws Exception{
      URL url = new URL(Weather.getImageURL(current));
      BufferedImage image = ImageIO.read(url);
      JLabel label = new JLabel(new ImageIcon(image));
      add(label);
   }
   /************************************************************* 
   * Adds a label showing the time and date to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addDate(Font f) throws Exception{
      JLabel label = new JLabel(Weather.getTimeAndDate(current));
      String unformat = label.getText();
      String wd = formatWeekday(unformat.substring(0,3));
      String date = formatDate(unformat.substring(5,16));
      //unformat = unformat.substring(16,unformat.length());
      
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
      JLabel label = new JLabel(Weather.getCondition(current));
      label.setFont(f);
      add(label);
   }
   /************************************************************* 
   * Adds a label showing the current temperature to CurrentPanel.
   * 
   * @param f  A font with which to display the label
   **************************************************************/
   public void addTemp(Font f) throws Exception{
      String temp = Weather.getTemperature(current);
      temp = temp.substring(0,temp.indexOf("("));
      JLabel label = new JLabel("Temperature: " + temp);
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
      JLabel label = new JLabel("Feels like: " + temp);
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
      JLabel label = new JLabel(Weather.getFullName(current));
      label.setFont(f);
      add(label);
   }
   /************************************************************* 
   * Adds the update button to the CurrentPanel
   **************************************************************/
   public void addUpdateButton() throws Exception{
      updateButton = new JButton("Update");
      updateButton.addActionListener(new UpdateListener());
      add(updateButton);
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
   /*****************************************************************
   * The UpdateListener is a private class of CurrentPanel that 
   * implements the ActionListener interface. It is responsible for
   * handling the response to the update button being pressed.
   *
   * Kiran Ganeshan
   ****************************************************************/
   private class UpdateListener implements ActionListener
   {
      /************************************************************* 
      * Responds to any presses of the update button by updating
      * the CurrentPanel
      * 
      * @param e  The ActionEvent to which the UpdateListener is
      *           responding
      **************************************************************/

      public void actionPerformed(ActionEvent e)
      {
         try{update(sample);}
         catch(Exception a){System.out.println(a);}
      }
   }
}
