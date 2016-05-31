/*****************************************************************
* The Panel is the class that determines and encapsulates what 
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
   public Panel() throws Exception
   {
      setLayout(new BorderLayout());
      current = new CurrentPanel();
      current.setBorder(getOurBorder());
      add(current, BorderLayout.NORTH);
      JPanel right = new JPanel();
      day = new DayPanel();
      alerts = new AlertsPanel();
      search = new SearchPanel();
      right.setLayout(new GridLayout(3,1));
      right.add(search);
      right.add(day);
      right.add(alerts);
      add(right, BorderLayout.EAST);
      tenDay = new TenDayPanel();
      add(tenDay,BorderLayout.SOUTH);
   }
   /************************************************************* 
   * Returns the standardized border used for each subpanel of
   * the Panel
   * @return  border
   **************************************************************/
   public Border getOurBorder(){
      return BorderFactory.createMatteBorder(5,1,1,1,new Color(128,128,255));
   }
}
