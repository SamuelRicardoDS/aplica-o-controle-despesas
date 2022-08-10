package view;

import view.ViewFirstScreen;

import java.util.*;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.Point;
import java.awt.Insets;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import controller.Executavel;
import data.Database;
import model.User;
import controller.ControlUser;




public class ViewRegister {

	public Executavel executavel = new Executavel();
	private JFrame frame;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JLabel lblConfirmarSenha;
	private JTextField txtConfirmPass;
	private JButton btnClear;
	private JButton btnExit;
	private JButton btnRegister;
	private JLabel lblUsername;
	private JLabel background;
	public ControlUser cu = new ControlUser(Database.getInstance());

	public static void main(String[] args) {		
					ViewRegister window = new ViewRegister();
					window.frame.setVisible(true);
	}

	public ViewRegister() {

		frame = new JFrame();
		frame.setBounds(150, 150, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		btnRegister = new JButton("Registrar");
		btnRegister.setBounds(150, 320, 150, 25);
		frame.getContentPane().add(btnRegister);

		btnClear = new JButton("Limpar");
		btnClear.setBounds(305, 320, 150, 25);
		frame.getContentPane().add(btnClear);

		btnExit = new JButton("Voltar");
		btnExit.setBounds(220, 350, 150, 25);
		frame.getContentPane().add(btnExit);

		lblUsername = new JLabel("Nome:");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setBounds(226, 160, 103, 15);
		frame.getContentPane().add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(226, 180, 150, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		lblPassword = new JLabel("Senha:");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBounds(226, 210, 70, 15);
		frame.getContentPane().add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(226, 230, 150, 19);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setForeground(Color.BLACK);
		lblConfirmarSenha.setBounds(226, 255, 150, 20);
		frame.getContentPane().add(lblConfirmarSenha);

		txtConfirmPass = new JPasswordField();
		txtConfirmPass.setColumns(10);
		txtConfirmPass.setBounds(226, 280, 150, 19);
		frame.getContentPane().add(txtConfirmPass);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(ViewRegister.class.getResource("/images/ze.jpeg")));
		background.setBounds(0, -81, 988, 743);
		frame.getContentPane().add(background);

		// nao sei se isso deveria ficar aqui, mas funcionando é o que importa né?
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String username = txtUsername.getText(); 
				String password = txtPassword.getText();
				String confirm  = txtConfirmPass.getText();

				if (confirm.equals(password))
					System.out.println("Senha válida.");
				else
					JOptionPane.showMessageDialog(null, "Senha Invalida");

				User user = new User(username, password);

				user.setUsername(username);
				user.setPassword(password);
				cu.create(username, password);
				JOptionPane.showMessageDialog(null, "Usuário Cadastrado"); // aqui mostra
			}
		});


		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				txtUsername.setText("");
				txtPassword.setText("");
				txtConfirmPass.setText("");
			}
		});

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				frame.dispose();
				
				ViewFirstScreen origin = new ViewFirstScreen();
				origin.getOriginFrame().setVisible(true);
			}
		});
		
	}

	public JFrame getRegisterFrame() {
		return frame;
	}
}
