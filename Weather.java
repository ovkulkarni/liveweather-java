import java.net.*;
import java.io.*;
import org.json.*;

public class Weather{
   public static void main(String[] args) throws Exception{
      System.out.println(getName("Alexa"));
      System.out.println(currentConditions("Alexa"));
   }
   
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
      JSONObject results = getJSONFromURL("http://autocomplete.wunderground.com/aq?query=" + query + "&h=0&c=US");
      return results.getJSONArray("RESULTS").getJSONObject(0).getString("name");
   }
   public static String getEnding(String query) throws Exception {
      JSONObject results = getJSONFromURL("http://autocomplete.wunderground.com/aq?query=" + query + "&h=0&c=US");
      return results.getJSONArray("RESULTS").getJSONObject(0).getString("l");
   }
   public static String currentConditions(String query) throws Exception {
      JSONObject results = getJSONFromURL("http://api.wunderground.com/api/ccb47836f398476f/conditions" + getEnding(query) + ".json");
      return results.getJSONObject("current_observation").getString("temperature_string");
   }
   
}
       
       
