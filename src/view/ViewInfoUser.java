package view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControlUser;
import model.User;

import javax.swing.JLabel;
import javax.swing.JButton;

public class ViewInfoUser {
    private JFrame frame;
    private JTextField txtNewUsername;
    private JTextField txtNewPassword;
    private JLabel lblUsername;
    private ControlUser cu;
    private JLabel lblCurrentPassword;
    private JLabel lblPassword;
    private JLabel lblNewUsername;
    private JButton btnUpdate;
    private JLabel lblNewPassword;

    public ViewInfoUser() {
        cu = new ControlUser();

        frame = new JFrame();
        frame.setBounds(0, 0, 800, 480);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nome de usuário atual");
        lblNewLabel.setBounds(64, 55, 194, 35);
        frame.getContentPane().add(lblNewLabel);
        
        lblUsername = new JLabel(cu.getUsername());
        lblUsername.setBounds(64, 75, 70, 15);
        frame.getContentPane().add(lblUsername);
        
        lblCurrentPassword = new JLabel("Senha atual:");
        lblCurrentPassword.setBounds(64, 139, 133, 15);
        frame.getContentPane().add(lblCurrentPassword);
        
        lblPassword = new JLabel(cu.readOne(cu.getUsername()).getPassword());
        lblPassword.setBounds(64, 152, 70, 15);
        frame.getContentPane().add(lblPassword);
        frame.setLocationRelativeTo(null);
        
        lblNewUsername = new JLabel("Novo nome:");
        lblNewUsername.setBounds(422, 50, 133, 15);
        frame.getContentPane().add(lblNewUsername);
        
        txtNewUsername = new JTextField();
        txtNewUsername.setText("");
        txtNewUsername.setBounds(422, 80, 114, 19);
        frame.getContentPane().add(txtNewUsername);
        txtNewUsername.setColumns(10);
        
        lblNewPassword = new JLabel("Nova Senha:");
        lblNewPassword.setBounds(422, 110, 131, 15);
        frame.getContentPane().add(lblNewPassword);
        
        txtNewPassword = new JTextField();
        txtNewPassword.setText("");
        txtNewPassword.setBounds(422, 140, 114, 19);
        frame.getContentPane().add(txtNewPassword);
        txtNewPassword.setColumns(10);
        
        btnUpdate = new JButton("atualizar");
        btnUpdate.setBounds(422, 171, 117, 25);
        frame.getContentPane().add(btnUpdate);

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            User currentUser = cu.readOne(cu.getUsername());
            
            
           User user = cu.create(txtNewUsername.getText(), 
                txtNewPassword.getText(), 
                cu.readOne(cu.getUsername()).getGroups(), 
                cu.readOne(cu.getUsername()).getFriends(), 
                null);

                cu.update(currentUser, user);
                System.out.println(user.getPassword());
            }
        });
        
    }

    public JFrame getInfoUser() {
        return frame;
    }
}