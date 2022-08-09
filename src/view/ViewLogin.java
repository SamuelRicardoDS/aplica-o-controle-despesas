package view;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.ControlUser;
import data.Database;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ViewLogin {

	private JFrame frame;
	private JTextField txtLogin;
	private JTextField txtPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnEntrar;
	private JButton btnBack;
	private JLabel label;
	ControlUser cu = new ControlUser(Database.getInstance());


	public static void main(String[] args) {

		ViewLogin window = new ViewLogin();
		window.frame.setVisible(true);

	}

	public ViewLogin() {

		frame = new JFrame();
		frame.setBounds(150, 150, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(209, 205, 70, 15);
		frame.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("SENHA");
		lblNewLabel_1.setBounds(209, 240, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);

		txtLogin = new JTextField();
		txtLogin.setBounds(195, 195, 200, 35);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBounds(195, 230, 200, 35);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(205, 270, 180, 35);
		frame.getContentPane().add(btnEntrar);

		btnBack = new JButton("VOLTAR");
		btnBack.setBounds(205, 310, 180, 35);
		frame.getContentPane().add(btnBack);

		label = new JLabel("");
		label.setIcon(new ImageIcon(ViewLogin.class.getResource("/images/jm.jpg")));
		label.setBounds(-72, -117, 979, 696);
		frame.getContentPane().add(label);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				ViewFirstScreen window = new ViewFirstScreen();
				window.getOriginFrame().setVisible(true);
			}
		});
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtLogin.getText();
				String password = txtPassword.getText();

				if(cu.ControlLogin(username, password) == true) {
					frame.dispose();
					ViewMain window = new ViewMain();
					window.getMainFrame().setVisible(true);
					System.out.println(cu.ReadAll());
				} else {
					System.out.println("Usuário ou senha inválidos");
				}
				
			}
		});
	}

	public JFrame getLoginFrame() {
		return frame;
	}
}
