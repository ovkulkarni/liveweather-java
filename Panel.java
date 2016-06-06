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
   int delay = 30000;
   /************************************************************* 
   * Constructs a Panel
   **************************************************************/
   public Panel()
   {
      try{
         setLayout(new BorderLayout());
         current = new CurrentPanel(Weather.getGeolookup());
         current.setBorder(getOurBorder(currentBorderNums));
         add(current, BorderLayout.CENTER);
         JPanel right = new JPanel();
         day = new DayPanel();
         alerts = new AlertsPanel();
         search = new SearchPanel(searchbox);
         add(search, BorderLayout.NORTH);
         right.setLayout(new GridLayout(3,1));
         right.add(search);
         right.add(day);
         //right.add(alerts);
         //add(right, BorderLayout.EAST);
         tenDay = new TenDayPanel(new EmptyBorder(5,7,5,7),getOurBorder(singleDayBorderNums));
         add(tenDay, BorderLayout.SOUTH);
         t.start();
      }
      catch(Exception e){
         System.out.println(e);
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
      private JTextField searchBox;
      public SearchListener(JTextField search){searchBox = search;}
      public void keyPressed(KeyEvent e){
         if(e.getKeyCode()==KeyEvent.VK_ENTER){update(searchBox.getText());}
      }
   }
   ActionListener taskPerformer = new ActionListener() {public void actionPerformed(ActionEvent evt) {update();}};
   Timer t = new Timer(delay, taskPerformer);
   public void update(){
      current.repaint();
      alerts.repaint();
      tenDay.repaint();
      System.out.println("Repainted.");
   }
   public void update(String newLoc){
      //current.repaint();
      //alerts.repaint();
      //tenDay.repaint();
      System.out.println("Repainted.");
   }
}
