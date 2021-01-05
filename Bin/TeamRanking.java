package Test;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TeamRanking {
	
   public static void main(String[] args) {
	   
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      panel.setBorder(BorderFactory.createTitledBorder(
    	BorderFactory.createEtchedBorder(), "Team Rankings", TitledBorder.CENTER, TitledBorder.TOP));
      	String[][] data = {
         { "1", "P1", "W1", "D1", "L1" },
         { "2", "P1", "W1", "D1", "L1" },
         { "3", "P1", "W1", "D1", "L1" },
         { "4", "P1", "W1", "D1", "L1" },
         { "5", "P1", "W1", "D1", "L1" },
         { "6", "P1", "W1", "D1", "L1" },
         
      };
      	
      String[] header = { "Team Name", "P", "W", "D", "L" };
      
      DefaultTableModel model = new DefaultTableModel(data, header);
      
      panel.add(new JScrollPane());
      frame.getContentPane().add(panel);
      
      JTable table = new JTable(model);
      table.setBounds(0, 0, 100, 200);
      panel.add(table);
      frame.setSize(550, 400);
      frame.setVisible(true);
   }
}
