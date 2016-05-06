import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import org.json.*;
import java.net.*;
CurrentPanel currentPanel;
public class Panel extends JPanel
{
   public Panel()
   {
      setLayout(new BorderLayout());
      currentPanel = new CurrentPanel();
      add(currentPanel, BorderLayout.NORTH);
   }
}
