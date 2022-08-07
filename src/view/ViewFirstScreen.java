package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ViewFirstScreen {

	public JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFirstScreen window = new ViewFirstScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	
	public ViewFirstScreen() {
		initialize();

	}

	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(150, 150, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(195, 185, 210, 45);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(195, 260, 210, 45);
		frame.getContentPane().add(btnNewButton);
	}
}
