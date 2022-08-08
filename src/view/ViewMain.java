package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ViewMain {

	private JFrame frame;

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
	}

}
