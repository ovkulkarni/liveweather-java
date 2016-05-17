/*****************************************************************
* The Weather class has all the methods to retrieve the weather 
* from the API. This includes all current and future weather 
* conditions.
* 
* Omkar Kulkarni
****************************************************************/
import java.net.*;
import java.io.*;
import org.json.*;

public class WeatherStub{

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

   /**
    * Gets the current results JSONObject 
    *
    * @param  query String with name of city in US 
    * @return       The JSONObject generated from the URL
    */
   public static JSONObject getCurrentResults(String query) throws Exception{
      return getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/conditions" + getEnding(query) + ".json");
   }

   /**
    * Gets the current condition JSONObject 
    *
    * @param  query String with name of city in US 
    * @return       The JSONObject generated from the URL
    */
   public static JSONObject getCurrentConditions(String query) throws Exception{
      return getCurrentResults(query).getJSONObject("current_observation");
   }
   
   /**
    * Gets the current temperature 
    *
    * @param  data The JSONObject with the conditions 
    * @return      A string with the temperature
    */
   public static String getTemperature(JSONObject data){
      return data.getString("temperature_string");
   }

   /**
    * Gets the image url to display on the panel 
    *
    * @param  data The JSONObject with the conditions 
    * @return      A string form of the URL leading to the image
    */
   public static String getImageURL(JSONObject data){
      return data.getString("icon_url");
   }
   
   /**
    * Gets the name of the city that the weather is for 
    *
    * @param  data The JSONObject with the conditions 
    * @return      A string with the full name of the city
    */
   public static String getFullName(JSONObject data){
      return data.getJSONObject("display_location").getString("full");
   }

   /**
    * Gets the actual conditions. eg. Cloudy, Sunny, Raining 
    *
    * @param  data The JSONObject with the conditions 
    * @return      A string with the condition
    */
   public static String getCondition(JSONObject data){
      return data.getString("weather");
   }
   
   /**
    * Gets the URL of the detailed conditions to link on the panel 
    *
    * @param  data The JSONObject with the conditions 
    * @return      A string with URL of the detailed conditions
    */
   public static String getDetailedURL(JSONObject data){
      return data.getString("forecast_url");
   }
   
   /**
    * Gets the time and date of when it retrieved the weather 
    *
    * @param  data The JSONObject with the conditions 
    * @return      A string with the time and date
    */
   public static String getTimeAndDate(JSONObject data){
      return data.getString("local_time_rfc822");
   }
   
   /**
    * Gets the wind condition of the location 
    *
    * @param  data The JSONObject with the conditions 
    * @return      A string with the wind condition
    */
   public static String getWindConditions(JSONObject data){
      return data.getString("wind_string");
   }
   
   /**
    * Gets the humidity of the location 
    *
    * @param  data The JSONObject with the conditions 
    * @return      A string with the humidity
    */
   public static String getHumidity(JSONObject data){
      return data.getString("relative_humidity");
   }

   /**
    * Gets the "feels like" temperature of the location 
    *
    * @param  data The JSONObject with the conditions 
    * @return      A string with the "feels like" temperature
    */
   public static String getActualTemp(JSONObject data){
      return data.getString("feelslike_string");
   }
   
   /**
    * Gets the future results JSONObject 
    *
    * @param  query String with name of city in US 
    * @return       The JSONObject generated from the URL
    */
   public static JSONObject getFutureResults(String query) throws Exception{
      return getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/forecast" + getEnding(query) + ".json");
   }

}
