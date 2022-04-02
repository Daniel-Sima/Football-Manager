import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class TeamsWindow extends JFrame implements Files{
	private static final long serialVersionUID = 1L;
	private Dimension currentScreenSize;
/*----------------------------------------------------------------------------*/
	public TeamsWindow(String result) {
		currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

		new JFrame();
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocation(0, (int) currentScreenSize.getHeight() / 12);

		JLabel twoTeams = new JLabel("twoTeams");
		twoTeams.setHorizontalAlignment(SwingConstants.CENTER);

		Image img2 = new ImageIcon(this.getClass().getResource(imgGameLocation)).getImage();

		JTextArea InfoTeams = new JTextArea();

		InfoTeams.setBackground(new Color(202, 235, 252));
		InfoTeams.setForeground(new Color(0, 102, 0));
		InfoTeams.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

		InfoTeams.setText(result);

		InfoTeams.setBounds(350, 576, 320, 70);
		getContentPane().add(InfoTeams);

		twoTeams.setIcon((Icon) new ImageIcon(img2));

		twoTeams.setBounds(0, 0, 1000, 750);
		getContentPane().add(twoTeams);

		setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setVisible(false);
	}
/*----------------------------------------------------------------------------*/
}
