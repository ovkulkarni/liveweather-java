/*****************************************************************
* The HourPanel is a JPanel that displays information from
* a single day within a ten day forecast. The HourPanel has
* a JSONObject that it uses to retrieve information it needs to
* display, and it knows how to instantiate that object and itself.
*
* Kiran Ganeshan
****************************************************************/
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
import javax.swing.border.*;
/*****************************************************************
* The AlertsPanel is a JPanel that displays information about any
* weather alerts pertinent to the selected area, such as tropcial
* storm or hurricane warnings. The AlertsPanel knows about the 
* hourly and alerts data retrieved from the Wunderground API, and
* uses a JTextArea to display that information. The AlertsPanel
* knows how to update and instantiate itself.
*
* Omkar Kulkarni
****************************************************************/
public class AlertsPanel extends JPanel {
   private static JSONObject hourdata;
   private static JSONObject alertdata;
   private static JTextArea label;
   /************************************************************* 
   * Updates the AlertsPanel based on current information about
   * alerts in the given location available from the Wunderground
   * API, and pushes that information to a JTextArea that is
   * displayed to the user on the screen.
   *
   * @param location The location from which data will be retrieved
   **************************************************************/
   public void update(String location) throws Exception{}
   /************************************************************* 
   * Instantiates the AlertsPanel object with a given Border
   * and with information about a given location.
   *
   * @param b        The border around the AlertsPanel
   * @param location The location of the alerts
   **************************************************************/
   public AlertsPanel(Border b, String location){}
}
