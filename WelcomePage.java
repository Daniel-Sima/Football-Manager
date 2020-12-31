package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage {

	private JFrame frame;
	private JLabel FootImg;
	private JButton Continue;
	private ChooseTeamWindow teams;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Continue = new JButton("Continue");
		Continue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					teams = new ChooseTeamWindow();
					teams.newScreen();
					frame.setVisible(false);
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		Continue.setBackground(Color.BLUE);
		Continue.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		Continue.setBounds(282, 365, 117, 29);
		frame.getContentPane().add(Continue);
		
		
		
		FootImg = new JLabel("Football Championship");
		FootImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image img1 = new ImageIcon(this.getClass().getResource("/Championship.png")).getImage();
		FootImg.setIcon((Icon) new ImageIcon(img1));
		FootImg.setBounds(0, 0, 720, 800);
		frame.getContentPane().add(FootImg);
	}
}
