import java.net.*;
import java.io.*;
import org.json.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Weather{

   /**
    * Returns a JSONObject from a given URL. 
    *
    * @param  link Link of the page with the JSON Data
    * @return      The JSONObject generated from the URL
    */
   public static JSONObject getJSONFromURL(String link) throws Exception{
      URL url = new URL(link);
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
   
   public static String getGeolookup() throws Exception{
      return getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/geolookup/q/autoip.json").getJSONObject("location").getString("city");
   }
   
   public static JSONObject getForecastResults(String query) throws Exception{
      return getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/forecast10day" + getEnding(query) + ".json");
   }
   
   public static JSONArray getForecastArray(String query) throws Exception{
      return getForecastResults(query).getJSONObject("forecast").getJSONObject("simpleforecast").getJSONArray("forecastday");
   }
   
   public static JSONObject getDayByNum(int n, JSONArray days) throws Exception{
      return days.getJSONObject(n);
   }
   
   public static String getForecastDate(JSONObject data) throws Exception{
      return data.getJSONObject("date").getString("weekday");
   }
   
   public static URL getForecastImageURL(JSONObject data) throws Exception{
      URL url = new URL(data.getString("icon_url"));
      return url;
   }
   
   public static String getForecastTemps(JSONObject data) throws Exception{
      String str = "<html>High: ";
      str += data.getJSONObject("high").getString("fahrenheit");
      str += "F<br>Low: ";
      str += data.getJSONObject("low").getString("fahrenheit");
      str += "F</html>";
      return str;
   }
   
   public static JLabel getImageFromURL(URL url) throws Exception{
      BufferedImage image = ImageIO.read(url);
      JLabel label = new JLabel(new ImageIcon(image));
      return label;
   }
   
   public static JSONObject getCurrentConditions(String query) throws Exception{
      return getCurrentResults(query).getJSONObject("current_observation");
   }

   public static String getTemperature(JSONObject data){
      return data.getString("temperature_string");
   }

   public static URL getImageURL(JSONObject data) throws Exception{
      URL url = new URL(data.getString("icon_url"));
      return url;
   }

   public static String getFullName(JSONObject data){
      return data.getJSONObject("display_location").getString("full");
   }

   public static String getCondition(JSONObject data){
      return data.getString("weather");
   }

   public static String getDetailedURL(JSONObject data){
      return data.getString("forecast_url");
   }

   public static String getTimeAndDate(JSONObject data){
      return data.getString("local_time_rfc822");
   }

   public static String getWindConditions(JSONObject data){
      return data.getString("wind_string");
   }

   public static String getHumidity(JSONObject data){
      return data.getString("relative_humidity");
   }

   public static String getActualTemp(JSONObject data){
      return data.getString("feelslike_string");
   }

}
