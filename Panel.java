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
   int delay = 30000;
   /************************************************************* 
   * Constructs a Panel
   **************************************************************/
   public Panel()
   {
      try{
         searchbox = new JTextField(25);
         setLayout(new BorderLayout());
         current = new CurrentPanel(Weather.location);
         current.setBorder(getOurBorder(currentBorderNums));
         add(current, BorderLayout.CENTER);
         alerts = new AlertsPanel(getOurBorder(hourBorderNums), Weather.location);
         search = new SearchPanel(searchbox);
         searchbox.addKeyListener(new SearchListener());
         add(search, BorderLayout.NORTH);
         JPanel south = new JPanel();
         south.setLayout(new GridLayout(2,1));
         day = new DayPanel(new EmptyBorder(5,7,5,7),getOurBorder(hourBorderNums));
         south.add(day);
         tenDay = new TenDayPanel(new EmptyBorder(5,7,5,7),getOurBorder(singleDayBorderNums));
         south.add(tenDay);
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
         Weather.loggerWrite("Repainted.");
      }
      catch(Exception e){
         Weather.loggerWrite("Error when updating CurrentPanel: " + e);
      }
   }

}
