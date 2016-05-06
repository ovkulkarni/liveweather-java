import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
CurrentPanel current;
AlertsPanel alerts;
TenDayPanel tenDay;
DayPanel day;
SearchPanel search;
public class Panel extends JPanel
{
   public Panel()
   {
      setLayout(new BorderLayout());
      current = new CurrentPanel();
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
}
