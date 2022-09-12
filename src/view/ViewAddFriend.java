package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.*;

import controller.ControlUser;

/**
 * Essa classe é responsável por criar a interface gráfica para adicionar um amigo.
 * 
 * @author Gustavo Henrique
 * @since release 1
 */
public class ViewAddFriend {

	private JFrame frame;
	private JLabel lblbackground;
	private JTextField txtNameFriend;
	private JButton btnAddFriend;
	private JLabel lblNameFriend;
	
	ControlUser cu = new ControlUser();

	/**
	 * Construtor da classe ViewAddFriend, onde é criada a interface gráfica.
	 */
	public ViewAddFriend() {
		
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 480);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		btnAddFriend = new JButton("Adicionar Amigo");
		btnAddFriend.setBounds(287, 278, 227, 25);
		frame.getContentPane().add(btnAddFriend);
		
		lblNameFriend = new JLabel("Nome ");
		lblNameFriend.setBounds(297, 242, 124, 15);
		frame.getContentPane().add(lblNameFriend);
		
		txtNameFriend = new JTextField();
		txtNameFriend.setBounds(287, 237, 227, 25);
		frame.getContentPane().add(txtNameFriend);
		txtNameFriend.setColumns(10);
		
		lblbackground = new JLabel("");
		lblbackground.setIcon(new ImageIcon(ViewAddFriend.class.getResource("/images/mamonas.jpg")));
		lblbackground.setBounds(0, 0, 800, 480);
		frame.getContentPane().add(lblbackground);

		/**
		 * botão que chama o método addFriend da classe ControlUser
		 */
		btnAddFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = txtNameFriend.getText();
				
				if(cu.verifyFriend(username) == true) {
					cu.addFriend(username, cu.readOne(cu.getUsername()));
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
