package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class ViewMain {

    private JFrame frame;
    private JLabel label;
    private JButton btnBack;
    private JToolBar tbMain;

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
        btnBack.setBounds(12, 646, 150, 25);
        frame.getContentPane().add(btnBack);

        btnBack.addActionListener(arg0 -> {
            ViewLogin window = new ViewLogin();
            window.getLoginFrame().setVisible(true);
            frame.dispose();
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