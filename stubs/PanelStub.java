import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
import javax.swing.border.*;
/*****************************************************************
* The Panel is the class that determines and encapsulates what 
* the user sees when he/she runs the program. The Panel is a
* JPanel and has a CurrentPanel, an AlertsPanel, a TenDayPanel,
* a DayPanel, and a SearchPanel. The Panel knows how to
* construct itself and how to retrieve the Border object that 
* is used as a border between subpanels, as well as several other
* Border objects.
*
* Kiran Ganeshan
****************************************************************/
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
   * Constructs the main Panel of the program by synthesizing
   * use of methods in other Panels, such as DayPanel or
   * CurrentPanel. Determines the overall look and feel of the
   * program.
   **************************************************************/
   public Panel(){}
   /************************************************************* 
   * Returns the standardized border used for each subpanel of
   * the Panel, with padding on the inside and outside as
   * determined using the array of integers passed to it
   *
   * @param   width     Eight integers that represent padding values
   * @return  [unnamed] The border object to be added to a Panel
   **************************************************************/
   public Border getOurBorder(int[] width){}
   /************************************************************* 
   * Returns the title font used when writing titles
   *
   * @return  [unnamed] The font object used when writing titles
   **************************************************************/
   public Font getTitleFont(){return new Font("Sans-Serif",Font.PLAIN,30);}
   /************************************************************* 
   * Returns the standardized border used for each subpanel of
   * the Panel, with padding on the inside and outside as
   * determined using the array of integers passed to it, and a
   * title determined by the string passed
   *
   * @param   width        Eight integers that represent padding values
   * @param   titleString  The string used as the title of the Panel
   * @return  [unnamed]    The border object to be added to a Panel
   **************************************************************/
   public Border getOurBorder(int[] width,String titleString){}
   /************************************************************* 
   * Returns an empty border, with padding on the inside and outside as
   * determined using the array of integers passed to it, and a
   * title determined by the string passed
   *
   * @param   width        Eight integers that represent padding values
   * @param   titleString  The string used as the title of the Panel
   * @return  [unnamed]    The border object to be added to a Panel
   **************************************************************/
   public Border getTitledEmptyBorder(int[] width,String titleString){}
   /*****************************************************************
   * The SearchListener is responsible for calling the update function
   * when the enter button on the keyboard is pressed, indicating that
   * there is a city name in the search bar that the user wants to
   * see weather information about
   *
   * Omkar Kulkarni
   ****************************************************************/
   private class SearchListener extends KeyAdapter {
      /************************************************************* 
      * Updates the Panel when the enter button is pressed.
      *
      * @param e  The KeyEvent associated with the press of a key
      **************************************************************/
      public void keyPressed(KeyEvent e) {}
   }
   /*****************************************************************
   * The ActionListener taskPerformer and Timer t are responsible
   * for updating the Panel every [delay] milliseconds.
   *
   * Omkar Kulkarni
   ****************************************************************/
   ActionListener taskPerformer = 
      new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            update();
         }
      };
   Timer t = new Timer(delay, taskPerformer);
   /************************************************************* 
   * Updates the Panel when the enter button is pressed or every
   * time the Timer and ActionListener indicate to do so.
   **************************************************************/
   public void update(){}
}
