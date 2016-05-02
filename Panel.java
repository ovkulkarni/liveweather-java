import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;

public class Panel extends JPanel
{
   public Panel()
   {
      try{
         JLabel label = addImage();
         add(label);
      }
      catch(Exception e){
         JLabel label = new JLabel("Hi");
         add(label);
      }
      
   }
   
   public JLabel addImage() throws Exception{
      JSONObject data = Weather.getCurrentConditions("Washington");
      URL url = new URL(Weather.getImageURL(data));
      BufferedImage image = ImageIO.read(url);
      JLabel label = new JLabel(new ImageIcon(image));
      return label;
   }
      
      
}