import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
import javax.swing.border.*;
/*****************************************************************
* The TenDayPanel is a JPanel that displays the most basic weather
* information for the next ten days. TenDayPanel has a JSONObject
* that it uses to retreive data from the Wunderground API, and
* it also has an array of SingleDayPanels, each of which display
* one day of weather. The TenDayPanel knows how to instantiate
* it's JSONObject and how to instantiate itself.
*
* Nikki Prabhu
****************************************************************/
public class TenDayPanel extends JPanel 
{
   private static JSONObject tenDay;
   SingleDayPanel[] dayPanels = new SingleDayPanel[10];
   /************************************************************* 
   * Instantiates the JSONObject required to retain information
   * from the Wunderground API
   **************************************************************/
   static{}
   /************************************************************* 
   * Instantiates a TenDayPanel object
   **************************************************************/
   public TenDayPanel(Border tenPanelBorder, Border singlePanelBorder)
   {
      setBorder(tenPanelBorder);
      setLayout(new GridLayout(1,10));
      for(int x=0;x<10;x++)
         dayPanels[x] = new SingleDayPanel(x,singlePanelBorder);
      for(int x=0;x<10;x++)
         add(dayPanels[x]);
   }
}
