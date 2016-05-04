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
      add(new CurrentPanel());
   }
}