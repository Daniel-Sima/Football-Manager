import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;


import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TeamRankings extends JFrame{
  protected JPanel panel;

  public TeamRankings(){
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

  public static void main(String[] args){
    new TeamRankings();
  }

}
