/*****************************************************************
* The Driver is the class that determines and encapsulates what 
* the user sees when he/she runs the program. The Panel is a
* JPanel and has a CurrentPanel, an AlertsPanel, a TenDayPanel,
* a DayPanel, and a SearchPanel. The Panel knows how to
* construct itself and how to retrieve the Border object that 
* is used as a border between subpanels.
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
public class Panel extends JPanel
{
   private CurrentPanel current;
   private AlertsPanel alerts;
   private TenDayPanel tenDay;
   private DayPanel day;
   private SearchPanel search;
   /************************************************************* 
   * Constructs a Panel
   **************************************************************/
   public Panel() {}
   /************************************************************* 
   * Returns the standardized border used for each subpanel of
   * the Panel
   * @return  border
   **************************************************************/
   public Border getOurBorder() {}
}
