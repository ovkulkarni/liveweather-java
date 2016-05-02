import java.net.*;
import java.io.*;
import org.json.*;

public class Weather{
   
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
      
   public static String getName(String query) throws Exception{
      JSONObject results = getJSONFromURL("http://autocomplete.wunderground.com/aq?query=" + URLEncoder.encode(query) + "&h=0&c=US");
      return results.getJSONArray("RESULTS").getJSONObject(0).getString("name");
   }
   
   public static String getEnding(String query) throws Exception {
      JSONObject results = getJSONFromURL("http://autocomplete.wunderground.com/aq?query=" + URLEncoder.encode(query) + "&h=0&c=US");
      return results.getJSONArray("RESULTS").getJSONObject(0).getString("l");
   }
   
   public static JSONObject getCurrentResults(String query) throws Exception{
       return getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/conditions" + getEnding(query) + ".json");
   }
   
   public static JSONObject getCurrentConditions(String query) throws Exception{
       return getCurrentResults(query).getJSONObject("current_observation");
   }

   public static String getTemperature(JSONObject data){
        return data.getString("temperature_string");
   }
    
   public static String getImageURL(JSONObject data){
        return data.getString("icon_url");
    }

   public static String getFullName(JSONObject data){
       return data.getString("full");
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
