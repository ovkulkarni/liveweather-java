import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
import javax.swing.border.*;
/*****************************************************************
* The SearchPanel is a JPanel that is responsible for providing a
* search bar that allows users to search for weather information
* about specific cities. The SearchPanel has a JSONObject that
* it uses to communicate with the Wunderground API when searching
* for weather information. The SearchPanel knows how to instantiate
* that JSONObject and instantiate itself. It receives a JTextField
* from the Panel instead of creating one so that the information
* in that JTextField can be easily passed back up to the Panel.
*
* Kiran Ganeshan
****************************************************************/
public class SearchPanel extends JPanel{
   public static String currentText = "";
   /************************************************************* 
   * Instantiates the SearchPanel object
   *
   * @param search   The JTextField used as the search bar.
   **************************************************************/
   public SearchPanel(JTextField search){}
}
