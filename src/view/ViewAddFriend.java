package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.*;

import controller.ControlUser;

public class ViewAddFriend {

	private JFrame frame;
	private JLabel background;
	private JTextField nameFriend;
	private JButton btnAddFriend;
	
	ControlUser cu = new ControlUser();

	public ViewAddFriend() {
		
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 480);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		btnAddFriend = new JButton("Adicionar Amigo");
		btnAddFriend.setBounds(287, 278, 227, 25);
		frame.getContentPane().add(btnAddFriend);
		
		JLabel lblNomeAmigo = new JLabel("Nome ");
		lblNomeAmigo.setBounds(297, 242, 124, 15);
		frame.getContentPane().add(lblNomeAmigo);
		
		nameFriend = new JTextField();
		nameFriend.setBounds(287, 237, 227, 25);
		frame.getContentPane().add(nameFriend);
		nameFriend.setColumns(10);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(ViewAddFriend.class.getResource("/images/mamonas.jpg")));
		background.setBounds(0, 0, 800, 480);
		frame.getContentPane().add(background);
		
		btnAddFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = nameFriend.getText();
				
				if(cu.verifyFriend(username) == true) {
					cu.addFriend(username);
					System.out.println(cu.readOne(username).getFriends());
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario não encontrado");
				}
		});
	}
	public JFrame getAddFriend() {
		return frame;
	}
}
