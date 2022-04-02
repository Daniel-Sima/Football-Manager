import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JLabel;

public class WelcomePage extends JLabel implements Files{
  private static final long serialVersionUID = 1L;
/*----------------------------------------------------------------------------*/
  public WelcomePage() {

		Image img1 = new ImageIcon(this.getClass().getResource(imgChampionshipLocation)).getImage();
    setIcon((Icon) new ImageIcon(img1));
  }
/*----------------------------------------------------------------------------*/
}
