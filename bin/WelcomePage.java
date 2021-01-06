import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

import javax.swing.*;

public class WelcomePage extends JFrame{
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public WelcomePage() {

    setBounds(100, 100, 720, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

    JLabel FootImg = new JLabel("Football Championship");
		FootImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image img1 = new ImageIcon(this.getClass().getResource("img/Championship.png")).getImage();
		FootImg.setIcon((Icon) new ImageIcon(img1));
		FootImg.setBounds(0, 0, 720, 800);

		getContentPane().add(FootImg);
    setVisible(true);
  }
  public static void main(String[] args){
    new WelcomePage();
  }
}
