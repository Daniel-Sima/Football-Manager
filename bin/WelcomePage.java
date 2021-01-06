import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JLabel;

public class WelcomePage extends JLabel{
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public WelcomePage() {

		Image img1 = new ImageIcon(this.getClass().getResource("img/Championship.png")).getImage();
    setIcon((Icon) new ImageIcon(img1));
  }
}
