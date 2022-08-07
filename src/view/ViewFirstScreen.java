package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ViewFirstScreen {

	private JFrame frame;

	
	public static void main(String[] args) {
					ViewFirstScreen window = new ViewFirstScreen();
					window.frame.setVisible(true);	
	}

	
	public ViewFirstScreen() {
		initialize();

	}

	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(150, 150, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(195, 185, 210, 45);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(195, 260, 210, 45);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/gugabalatensa/Documents/OO/aplicacao_controle_despesas/hj.jpg"));
		label.setBounds(0, -128, 875, 843);
		frame.getContentPane().add(label);
	}

	public JFrame getFrame() {
		return frame;
	}
}
