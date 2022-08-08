package view;


import java.awt.event.*;
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
		
		frame = new JFrame();
		frame.setBounds(150, 150, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(195, 185, 210, 45);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Cadastro");
		btnRegister.setBounds(195, 260, 210, 45);
		frame.getContentPane().add(btnRegister);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewFirstScreen.class.getResource("/images/hj.jpg")));
		label.setBounds(0, -128, 875, 843);
		frame.getContentPane().add(label);


		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				ViewLogin window = new ViewLogin();
				window.getLoginFrame().setVisible(true);
			}
		});

		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				frame.dispose();
				ViewRegister window = new ViewRegister();
				window.getRegisterFrame().setVisible(true);
			}
		});

	}
	//leva a tela
	public JFrame getOriginFrame() {
		return frame;
	}
}
