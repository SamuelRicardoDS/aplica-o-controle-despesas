package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ViewLogin {

	private JFrame frame;
	private JTextField txtLogin;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					ViewLogin window = new ViewLogin();
					window.frame.setVisible(true);
			
	}

	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(209, 205, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("SENHA");
		lblNewLabel_1.setBounds(209, 240, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(195, 195, 200, 35);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 230, 200, 35);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(205, 270, 180, 35);
		frame.getContentPane().add(btnEntrar);
		

	}
}
