/*****************************************************************
* The SearchPanel is a JPanel that is responsible for providing a
* search bar that allows users to search for weather information
* about specific cities. The SearchPanel has a JSONObject that
* it uses to communicate with the Wunderground API when searching
* for weather information. The SearchPanel knows how to instantiate
* that JSONObject and instantiate itself.
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
public class SearchPanel extends JPanel{
   /************************************************************* 
   * Instantiates the SearchPanel object
   **************************************************************/
   public SearchPanel(JTextField search){
      add(new JLabel(new ImageIcon("images/search-icon.png")));
      setPreferredSize(new Dimension(955,50));
      search = new JTextField("",SwingConstants.LEFT);
      search.setPreferredSize(new Dimension(905,40));
      search.setFont(new Font("Sans-Serif",Font.PLAIN,30));
      add(search);
      setBackground(Color.WHITE);
   }
}
