package view;

import controller.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewUpdateGroup {
    private JFrame frame;
    private JLabel background;
    private JTable table;
    private ControlGroup cg;
    private ControlUser cu;
    private JTextField textField;

    public ViewUpdateGroup() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 34, 208, 356);
        frame.getContentPane().add(scrollPane);

        String[] columns = { "Lista de Grupos" };
        Object[][] data = new String[cu.readOne(cu.getUsername()).getGroups().size()][columns.length];

        for (int i = 0; i < cu.readOne(cu.getUsername()).getGroups().size(); i++) {
            String[] groups = { cu.readOne(cu.getUsername()).getGroups().get(i).getName() };
            data[i] = groups;
        }
        table = new JTable(data, columns);
        scrollPane.setViewportView(table);
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        textField = new JTextField();
        textField.setBounds(330, 50, 170, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(548, 34, 208, 142);
        frame.getContentPane().add(scrollPane_1);
        
        JScrollPane scrollPane_1_1 = new JScrollPane();
        scrollPane_1_1.setBounds(548, 228, 208, 142);
        frame.getContentPane().add(scrollPane_1_1);
        
        JButton btnNewButton = new JButton("Remover Membros");
        btnNewButton.setBounds(558, 190, 198, 26);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Adicionar membros");
        btnNewButton_1.setBounds(558, 382, 198, 26);
        frame.getContentPane().add(btnNewButton_1);
        
        JLabel lblNewLabel = new JLabel("Alterar Nome");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(334, 35, 166, 15);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNewButton_2 = new JButton("Alterar Nome");
        btnNewButton_2.setBounds(352, 84, 136, 25);
        frame.getContentPane().add(btnNewButton_2);

        background = new JLabel("");
        background.setBounds(0, 0, 800, 480);
        frame.getContentPane().add(background);
        background.setIcon(new ImageIcon(ViewUpdateGroup.class.getResource("/images/pagode.jpg")));
    }

    public JFrame getUpdateGroup() {
        return frame;
    }
}
