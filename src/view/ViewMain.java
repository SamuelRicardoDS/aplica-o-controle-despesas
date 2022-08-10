package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class ViewMain {

	private JFrame frame;
	private JLabel label;
	public static void main(String[] args) {
		ViewMain window = new ViewMain();
		window.frame.setVisible(true);
	}

	public ViewMain() {
		
		frame = new JFrame();
		frame.setBounds(150, 150, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ViewMain.class.getResource("/images/fc.jpg")));
		label.setBounds(0, -55, 804, 663);
		frame.getContentPane().add(label);
		
		


	}
	public JFrame getMainFrame() {
		return frame;
	}
}
