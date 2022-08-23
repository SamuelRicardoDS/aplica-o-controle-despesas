package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.ImageIcon;




public class ViewCreateGroup {
	
	public static void main(String[] args) {
	    ViewCreateGroup window = new ViewCreateGroup();
	    window.frame.setVisible(true);
	}

	private JFrame frame;
	private JLabel background;
	public ViewCreateGroup() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 480);
		frame.getContentPane().setLayout(null);
		
		background = new JLabel("");
		background.setBounds(0, -28, 925, 542);
		frame.getContentPane().add(background);
		background.setIcon(new ImageIcon(ViewCreateGroup.class.getResource("/images/duzao.jpg")));
		frame.setLocationRelativeTo(null);
		
		
	}
	public JFrame getCreateGroupFrame() {
		return frame;
	}
}

