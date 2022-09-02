package view;

import controller.ControlUser;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.User;

public class ViewMain {
  private JFrame frame;
  private JLabel label;
  private JButton btnBack;
  private JButton btnCreateGroup;
  private JButton addFriend;
  private JLabel lblNewLabel;
  public ControlUser cu = new ControlUser();

  public static void main(String[] args) {
    ViewMain window = new ViewMain();
    window.frame.setVisible(true);
  }

  public ViewMain() {
    frame = new JFrame();
    frame.setBounds(150, 150, 1280, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().getLayout();

    addFriend = new JButton("Adicionar Amigo");
    addFriend.setBounds(550, 270, 180, 30);
    frame.getContentPane().add(addFriend);

    addFriend.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          ViewAddFriend window = new ViewAddFriend();
          window.getAddFriend().setVisible(true);
        }
      }
    );

    btnCreateGroup = new JButton("Criar Grupo");
    btnCreateGroup.setBounds(580, 230, 120, 30);
    frame.getContentPane().add(btnCreateGroup);
    btnCreateGroup.setHorizontalAlignment(SwingConstants.LEFT);
    btnCreateGroup.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
          ViewCreateGroup window = new ViewCreateGroup();
          window.getCreateGroupFrame().setVisible(true);
        }
      }
    );

    btnBack = new JButton("Voltar");
    btnBack.setBounds(20, 640, 77, 25);
    frame.getContentPane().add(btnBack);

    btnBack.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
          ViewLogin window = new ViewLogin();
          window.getLoginFrame().setVisible(true);
          frame.dispose();
        }
      }
    );

    String usuario = cu.getUsername();
    lblNewLabel = new JLabel("Bem Vindo " + usuario);
    lblNewLabel.setBounds(1072, 12, 196, 25);
    lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
    frame.getContentPane().add(lblNewLabel);

    label = new JLabel("");
    label.setIcon(new ImageIcon(ViewMain.class.getResource("/images/fc.jpeg")));
    label.setBounds(0, 0, 1280, 720);
    frame.getContentPane().add(label);
  }

  public JFrame getMainFrame() {
    return frame;
  }
}
