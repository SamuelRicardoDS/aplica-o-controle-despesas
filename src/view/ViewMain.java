package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class ViewMain {

	private JFrame frame;
	private JLabel label;
	private JButton btnBack;
	
	public static void main(String[] args) {
		ViewMain window = new ViewMain();
		window.frame.setVisible(true);
	}

	public ViewMain() {
		
		frame = new JFrame();
		frame.setBounds(150, 150, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ViewMain.class.getResource("/images/fc.jpg")));
		label.setBounds(0, -55, 804, 663);
		frame.getContentPane().add(label);

		btnBack = new JButton("Voltar");
		btnBack.setBounds(150, 320, 150, 25);
		frame.getContentPane().add(btnBack);

		btnBack.addActionListener(arg0 -> {
			ViewLogin window = new ViewLogin();
			window.getLoginFrame().setVisible(true);
			frame.dispose();
		});

	}
	public JFrame getMainFrame() {
		return frame;
	}
}
