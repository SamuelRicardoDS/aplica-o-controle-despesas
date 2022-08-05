package view;

import aplicacao_controle_despesas.Executavel;
import aplicacao_controle_despesas.User;
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
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import java.awt.Canvas;

public class ViewPrimeiraTela {

	private JFrame frame;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JLabel lblbackground;
	public Executavel executavel =  new Executavel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrimeiraTela window = new ViewPrimeiraTela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public ViewPrimeiraTela() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnRegister = new JButton("Registrar");
		btnRegister.setBounds(185, 320, 150, 25);
		frame.getContentPane().add(btnRegister);

		JLabel lblUsername = new JLabel("Nome:");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setBounds(190, 190, 103, 15);
		frame.getContentPane().add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(190, 220, 114, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		lblPassword = new JLabel("Senha:");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBounds(190, 260, 70, 15);
		frame.getContentPane().add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(190, 292, 114, 19);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0)));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(169, 176, 180, 180);
		frame.getContentPane().add(panel);

		lblbackground = new JLabel("");
		lblbackground.setBounds(0, -281, 960, 890);
		frame.getContentPane().add(lblbackground);

		

		// nao sei se isso deveria ficar aqui, mas funcionando é o que importa né?
		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				String username = txtUsername.getText(); // aqui o botao pega o dado do usuario e armazena na string 											// username
				String password = txtPassword.getText();

				executavel.setUsernames(username);
				executavel.setPasswords(password);

				JOptionPane.showMessageDialog(null, "USER DATA" + "\n Nome:" + username + "\n Senha:" + password); // aqui
																													// mostra

			}
		});

	}
}
