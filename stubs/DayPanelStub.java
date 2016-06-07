import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
import javax.swing.border.*;
/*****************************************************************
* The DayPanel is a JPanel that displays the most basic weather
* information for the next ten hours. DayPanel has a JSONObject
* that it uses to retreive data from the Wunderground API, and
* it also has an array of HourPanels, each of which display
* one day of weather. The DayPanel knows how to instantiate
* it's JSONObject and how to instantiate itself.
*
* Nikki Prabhu
****************************************************************/
public class DayPanel extends JPanel 
{
   private static JSONObject hourly;
   HourPanel[] hourPanels = new HourPanel[10];
   /************************************************************* 
   * Instantiates a DayPanel object
   *
   * @param dayPanelBorder    The border that will go around DayPanel
   * @param hourPanelBorder   The border that will surround HourPanels
   **************************************************************/
   public DayPanel(Border dayPanelBorder, Border hourPanelBorder){}
   /************************************************************* 
   * Updates the information on the DayPanel object
   *
   * @param hourPanelBorder   The border that will surround HourPanels
   **************************************************************/
   public void update(Border hourPanelBorder){}
}
