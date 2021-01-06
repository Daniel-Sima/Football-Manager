import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class WelcomePage extends JFrame{
  public WelcomePage(){

    setBounds(100, 100, 720, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

    JLabel FootImg = new JLabel("Football Championship");
		FootImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image img1 = new ImageIcon(this.getClass().getResource("/Championship.png")).getImage();
		FootImg.setIcon((Icon) new ImageIcon(img1));
		FootImg.setBounds(0, 0, 720, 800);

		getContentPane().add(FootImg);
    setVisible(true);
  }
  public static void main(String[] args){
    new WelcomePage();
  }
}
