package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ViewMain {

    private JFrame frame;
    private JLabel label;
    private JButton btnBack;

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
        //fundo ainda ta quebrando o codigo, comentei a linha que da erro
        label = new JLabel("");
        //label.setIcon(new ImageIcon(ViewMain.class.getResource("/images/fc.jpeg")));
        label.setBounds(0, -24, 1280, 707);
        frame.getContentPane().add(label);

    }

    public JFrame getMainFrame() {
        return frame;
    }
}