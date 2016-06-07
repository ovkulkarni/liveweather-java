import java.net.*;
import java.io.*;
import org.json.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Date;
import java.text.*;

public class Weather{
   public static String location;
   public static PrintStream logfile = null;
   static{
      try{
         logfile = new PrintStream(new FileOutputStream("log.txt"));
      }
      catch(FileNotFoundException e)
      {
         JOptionPane.showMessageDialog(null,"The file could not be created.");
      }
   }
   static{
      try{
         location = getGeolookup();
      }
      catch(Exception e){
         loggerWrite("Error when doing Geolookup");
         loggerWrite("Setting Default Location as Washington");
         location = "Washington";
      }
      loggerWrite(location);
   }
   /**
    * Returns a JSONObject from a given URL. 
    *
    * @param  link Link of the page with the JSON Data
    * @return      The JSONObject generated from the URL
    */
   public static JSONObject getJSONFromURL(String link) throws Exception{
      URL url = new URL(link);
      loggerWrite("Accessing " + link);
      URLConnection connection = url.openConnection();
      BufferedReader text = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder data = new StringBuilder();
      int c;
      while ((c = text.read()) != -1){
         data.append((char) c);
      }
      text.close();
      JSONObject results = new JSONObject(data.toString());
      return results;
   }
   
   /**
    * Returns a name of a city from a given query. 
    *
    * @param  query String with part of the name of the city; US ONLY
    * @return       A String with the name of the Location
    */
    
   public static String getName(String query) throws Exception{
      JSONObject results = getJSONFromURL("http://autocomplete.wunderground.com/aq?query=" + URLEncoder.encode(query) + "&h=0&c=US");
      return results.getJSONArray("RESULTS").getJSONObject(0).getString("name");
   }
   /**
    * Returns a name of a city from a given query. 
    *
    * @param  query Get's special code from Wunderground to use in future requests from
    * @return       A String with the special code
    */
   public static String getEnding(String query) throws Exception {
      JSONObject results = getJSONFromURL("http://autocomplete.wunderground.com/aq?query=" + URLEncoder.encode(query) + "&h=0&c=US");
      return results.getJSONArray("RESULTS").getJSONObject(0).getString("l");
   }

   public static JSONObject getCurrentResults(String query) throws Exception{
      return getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/conditions" + getEnding(query) + ".json");
   }
   
   public static JSONArray getHourlyArray(String query) throws Exception{
      return getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/hourly" + getEnding(query) + ".json").getJSONArray("hourly_forecast");
   }
   
   public static JSONObject getHourObject(int n, JSONArray hourlyArray){
      return hourlyArray.getJSONObject(n);
   }
   
   public static URL getHourImageURL(JSONObject data) throws Exception{
      URL url = new URL(data.getString("icon_url"));
      return url;
   }
   
   public static String getHourTemp(JSONObject data){
      return data.getJSONObject("temp").getString("english") + " F";
   }
   
   public static String getHour(JSONObject data){
      return data.getJSONObject("FCTTIME").getString("civil");
   }
   
   public static String getGeolookup() throws Exception{
      loggerWrite("Geolocating...");
      JSONObject data = getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/geolookup/q/autoip.json").getJSONObject("location");
      loggerWrite("City: " + data.getString("city"));
      return data.getString("city");
   }
   
   public static JSONObject getForecastResults(String query) throws Exception{
      return getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/forecast10day" + getEnding(query) + ".json");
   }
   
   public static JSONArray getForecastArray(String query) throws Exception{
      loggerWrite("Getting Forecast Array");
      return getForecastResults(query).getJSONObject("forecast").getJSONObject("simpleforecast").getJSONArray("forecastday");
   }
   
   public static JSONObject getDayByNum(int n, JSONArray days) throws Exception{
      loggerWrite("Retrieved Day " + n);
      return days.getJSONObject(n);
   }
   
   public static String getForecastDate(JSONObject data) throws Exception{
      loggerWrite("Retrieved Date");
      return data.getJSONObject("date").getString("weekday");
   }
   
   public static URL getForecastImageURL(JSONObject data) throws Exception{
      URL url = new URL(data.getString("icon_url"));
      loggerWrite("Getting Image URL: " + url);
      return url;
   }
   
   public static String getForecastTemps(JSONObject data) throws Exception{
      String str = "<html>High: ";
      str += data.getJSONObject("high").getString("fahrenheit");
      str += "F<br>Low: ";
      str += data.getJSONObject("low").getString("fahrenheit");
      str += "F</html>";
      loggerWrite("Forecast Temps: " + str);
      return str;
   }
   
   public static JLabel getImageFromURL(URL url) throws Exception{
      BufferedImage image = ImageIO.read(url);
      loggerWrite("Getting Image JLabel from " + url);
      JLabel label = new JLabel(new ImageIcon(image));
      return label;
   }
   
   public static JSONObject getCurrentConditions(String query) throws Exception{
      loggerWrite("Getting Current Conditions for " + location);
      return getCurrentResults(query).getJSONObject("current_observation");
   }

   public static String getTemperature(JSONObject data){
      loggerWrite("Getting Temperature for " + location);
      return data.getString("temperature_string");
   }

   public static URL getImageURL(JSONObject data) throws Exception{
      URL url = new URL(data.getString("icon_url"));
      loggerWrite("Getting Image URL: " + url);
      return url;
   }

   public static String getFullName(JSONObject data){
      loggerWrite("Full Name: " + data.getJSONObject("display_location").getString("full"));
      return data.getJSONObject("display_location").getString("full");
   }

   public static String getCondition(JSONObject data){
      loggerWrite("Getting Conditions for " + location);
      return data.getString("weather");
   }

   public static String getTimeAndDate(JSONObject data){
      loggerWrite("Time of Weather Update: " + data.getString("local_time_rfc822"));
      return data.getString("local_time_rfc822");
   }

   public static String getActualTemp(JSONObject data){
      loggerWrite("Getting Actual Temperature for " + location);
      return data.getString("feelslike_string");
   }
   
   public static void loggerWrite(String s){
      DateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date dateTime = new Date();
      String dateTimeString = dateTimeFormat.format(dateTime);
      logfile.println(dateTimeString + ": " + s);
   }

}
