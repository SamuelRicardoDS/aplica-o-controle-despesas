package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
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
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import java.awt.Canvas;

public class ViewPrimeiraTela {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblSenha;
	private JTextField textField_1;
	private JLabel label;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public ViewPrimeiraTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("GugaBeLoved");
		btnNewButton.setBounds(185, 320, 150, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(190, 190, 103, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(0, 0, 0));
		lblSenha.setBounds(190, 260, 70, 15);
		frame.getContentPane().add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 292, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(190, 220, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(169, 176, 180, 180);
		frame.getContentPane().add(panel);
		
		label = new JLabel("");
		label.setBounds(0, -281, 960, 890);
		frame.getContentPane().add(label);
		label.setIcon(new ImageIcon("/home/gustavo/Downloads/teste.jpg"));
	}
}
