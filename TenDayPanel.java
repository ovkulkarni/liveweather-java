import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
public class TenDayPanel extends JPanel 
{
   SingleDayPanel[] dayPanels = new SingleDayPanel[10];
   public TenDayPanel()
   {
      for(int x=0;x<10;x++)
         dayPanels[x] = new SingleDayPanel();
      for(int x=0;x<10;x++)
         add(dayPanels[x]);
   }
}