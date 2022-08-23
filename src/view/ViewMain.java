package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ViewMain {

    private JFrame frame;
    private JLabel label;
    private JButton btnBack;
    private JButton btnCreateGroup;
    
    

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
        
        btnBack = new JButton("Voltar");
        btnBack.setBounds(0,0,130,30);
        
        btnCreateGroup = new JButton("Criar Grupo");
        btnCreateGroup.setBounds(0,30, 130, 30);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 150, 720);
        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
        panel.add(btnBack);
        panel.add(btnCreateGroup);
        
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                ViewLogin window = new ViewLogin();
                window.getLoginFrame().setVisible(true);
                frame.dispose();
            }
        });
        
        tbMain = new JToolBar();
        tbMain.setBounds(0, 0, 150, 720);
        frame.getContentPane().add(tbMain);
        tbMain.add(btnBack);

        label = new JLabel("");
        label.setIcon(new ImageIcon(ViewMain.class.getResource("/images/fc.jpeg")));
        label.setBounds(0, -24, 1280, 720); 
        frame.getContentPane().add(label);
        

    }

    public JFrame getMainFrame() {
        return frame;
    }
}