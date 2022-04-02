import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TeamRankings extends JPanel{
	private static final long serialVersionUID = 1L;
/*----------------------------------------------------------------------------*/
  public TeamRankings(Championnat championnat){
	setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),
			" ======== Barclay's Premier League Table ========= ", TitledBorder.CENTER, TitledBorder.TOP));

	String [][] data = championnat.setStringClassement();
	String [] header = {"Team","Played","Win","Draw","Loose","Points"};
	JTable teamTable = new JTable(data, header);

	add(new JScrollPane(teamTable));
  }
/*----------------------------------------------------------------------------*/ 
}
