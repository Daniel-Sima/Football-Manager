import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TeamRankings extends JFrame{
  	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panel;

  public TeamRankings(Simulation championnat){
    panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(),
		"ODI Rankings", TitledBorder.CENTER, TitledBorder.TOP));

		String [][] data = championnat.setStringClassement();
		String [] header = {"Team","Played","Win","Draw","Loose"};
		JTable teamTable = new JTable(data, header);

		panel.add(new JScrollPane(teamTable));
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Classement");
		setSize(550,400);
		setVisible(true);
  }
}
