import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
public class Panel extends JPanel
{

    private CurrentPanel current;
    private AlertsPanel alerts;
    private TenDayPanel tenDay;
    private DayPanel day;
    private SearchPanel search;
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
