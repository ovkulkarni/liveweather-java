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
import java.awt.event.*;
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
   private JTextField searchbox;
   private int[] currentBorderNums = {10,10,10,10,10,10,5,10};
   private int[] singleDayBorderNums = {5,2,5,2,2,2,2,2};
   private int[] hourBorderNums = {5,2,5,2,2,2,2,2};
   private int[] alertBorderNums = {10,10,10,10,5,10,10,10};
   private int[] tenDayBorderNums = {5,7,5,7};
   private int[] dayBorderNums = {5,7,5,7};
   int delay = 300000;
   /************************************************************* 
   * Constructs a Panel
   **************************************************************/
   public Panel()
   {
      try{
         searchbox = new JTextField(25);
         setLayout(new BorderLayout());
         JPanel top = new JPanel();
         top.setLayout(new GridLayout(1,2));
         JLabel logo = new JLabel(new ImageIcon("images/logo.png"));
         top.add(logo);
         current = new CurrentPanel(Weather.location);
         current.setBorder(getOurBorder(currentBorderNums,"Current Conditions"));
         current.setMinimumSize(new Dimension(450,400));
         top.add(current);
         add(top, BorderLayout.CENTER);
         alerts = new AlertsPanel(getOurBorder(alertBorderNums,"Alerts"), Weather.location);
         search = new SearchPanel(searchbox);
         searchbox.addKeyListener(new SearchListener());
         add(search, BorderLayout.NORTH);
         JPanel south = new JPanel();
         south.setLayout(new GridLayout(3,1));
         Border tenDayBorder = getTitledEmptyBorder(tenDayBorderNums,"Ten Day Forecast");
         tenDay = new TenDayPanel(tenDayBorder,getOurBorder(singleDayBorderNums));
         south.add(tenDay);
         Border dayBorder = getTitledEmptyBorder(dayBorderNums,"Hourly Forecast");
         day = new DayPanel(dayBorder,getOurBorder(hourBorderNums));
         south.add(day);
         south.add(alerts);
         add(south,BorderLayout.SOUTH);
         t.start();
      }
      catch(Exception e){
         Weather.loggerWrite("FATAL ERROR: " + e);
         System.exit(1);
      }
   }
   /************************************************************* 
   * Returns the standardized border used for each subpanel of
   * the Panel
   * @return  border
   **************************************************************/
   public Border getOurBorder(int[] width){
      Border innerBorder = new EmptyBorder(width[0]-4,width[1],width[2],width[3]);
      Border outerBorder = new EmptyBorder(width[4],width[5],width[6],width[7]);
      Border ourBorder = BorderFactory.createMatteBorder(5,1,1,1,new Color(128,128,255));
      Border b = new CompoundBorder(ourBorder,innerBorder);
      return new CompoundBorder(outerBorder,b);
   }
   public Font getTitleFont(){return new Font("Sans-Serif",Font.PLAIN,30);}
   public Border getOurBorder(int[] width,String titleString){
      Border innerBorder = new EmptyBorder(width[0]-4,width[1],width[2],width[3]);
      Border outerBorder = new EmptyBorder(width[4],width[5],width[6],width[7]);
      Border ourBorder = BorderFactory.createMatteBorder(5,1,1,1,new Color(128,128,255));
      Border empty = BorderFactory.createEmptyBorder();
      TitledBorder title = new TitledBorder(empty, titleString,TitledBorder.CENTER,TitledBorder.CENTER,getTitleFont());
      title.setTitleJustification(TitledBorder.CENTER);
      Border b = new CompoundBorder(ourBorder,innerBorder);
      b = new CompoundBorder(title,b);
      return new CompoundBorder(outerBorder,b);
   }
   public Border getTitledEmptyBorder(int[] width,String titleString){
      Border border = new EmptyBorder(width[0],width[1],width[2],width[3]);
      Border empty = BorderFactory.createEmptyBorder();
      TitledBorder title = new TitledBorder(empty, titleString,TitledBorder.CENTER,TitledBorder.CENTER,getTitleFont());
      return new CompoundBorder(border,title);
   }
   private class SearchListener extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_ENTER) {
        Weather.loggerWrite("Got new value from search box: "  + searchbox.getText());
        Weather.location = searchbox.getText();
        update();
        }
     }
   }
   
   
   ActionListener taskPerformer = 
      new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            update();
         }
      };
   Timer t = new Timer(delay, taskPerformer);
   public void update(){
      try{
         Font f = new Font("Sans Serif", Font.PLAIN, 20);
         current.removeAll();
         current.update(f, Weather.location);
         current.revalidate();
         current.repaint();
         tenDay.removeAll();
         tenDay.update(getOurBorder(singleDayBorderNums));
         tenDay.revalidate();
         tenDay.repaint();
         day.removeAll();
         day.update(getOurBorder(hourBorderNums));
         day.revalidate();
         day.repaint();
         alerts.removeAll();
         alerts.update(Weather.location);
         alerts.revalidate();
         alerts.repaint();
         Weather.loggerWrite("Repainted.");
      }
      catch(Exception e){
         Weather.loggerWrite("Error when updating CurrentPanel: " + e);
      }
   }

}
