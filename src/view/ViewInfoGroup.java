package view;

import javax.swing.JFrame;

public class ViewInfoGroup {
    private JFrame frame;

    public ViewInfoGroup() {
        frame = new JFrame();
        frame.setBounds(0, 0, 800, 480);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
    }

    public JFrame getInfoGroup() {
        return frame;
    }
}
