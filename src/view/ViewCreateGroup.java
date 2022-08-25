package view;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControlGroup;
import controller.ControlUser;
import model.User;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.border.LineBorder;





public class ViewCreateGroup {

	private JFrame frame;
	private JLabel background;
	private JTextField nameGroup;
	private JButton btnNewGroup;
	private JButton btnBack;
	private JButton btnAddMember;
	private ControlUser cu;
	private ControlGroup cg;
	private JTable table;
	private JScrollPane scrollPane;
	
	public ViewCreateGroup() {
		
		cu = new ControlUser();
		cg = new ControlGroup();
		
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 480);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(595, 30, 190, 340);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(341, 198, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		nameGroup = new JTextField();
		nameGroup.setBounds(320, 193, 151, 25);
		frame.getContentPane().add(nameGroup);
		nameGroup.setColumns(10);
		
		btnNewGroup = new JButton("Criar Grupo");
		btnNewGroup.setBounds(341, 248, 117, 25);
		frame.getContentPane().add(btnNewGroup);
		
		btnBack = new JButton("Voltar");
		btnBack.setBounds(12, 406, 117, 25);
		frame.getContentPane().add(btnBack);
		
		btnAddMember = new JButton("Adicionar Membros");
		btnAddMember.setBounds(595, 406, 190, 25);
		frame.getContentPane().add(btnAddMember);
		
		background = new JLabel("");
		background.setBounds(0, -28, 925, 542);
		frame.getContentPane().add(background);
		background.setIcon(new ImageIcon(ViewCreateGroup.class.getResource("/images/duzao.jpg")));
		
		
		btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
		});
		btnNewGroup.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name = nameGroup.getText();
			User lider = cu.readOne(cu.getUsername());
			System.out.println(name + lider);
			cg.createGroup(name, lider);
		}
		});
		
	}
	public JFrame getCreateGroupFrame() {
		return frame;
	}
}

