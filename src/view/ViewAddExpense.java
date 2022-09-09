package view;

import controller.ControlExpense;
import controller.ControlUser;
import model.Group;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ViewAddExpense {
    private ControlUser cu;
    private JFrame frame;
    private JLabel background;
    private JTable table;
    private JButton btnAddExpense;
    private JButton btnCreateExpense;
    private JTextField txtName;
    private JTextField txtValue;
    private JTextField txtDate;
    private JLabel lblName;
    private JLabel lblValue;
    private JLabel lblDate;
    private ControlExpense ce;

    public ViewAddExpense() {
        cu = new ControlUser();
        ce = new ControlExpense(null);

        frame = new JFrame();
        frame.setBounds(0, 0, 800, 480);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 38, 232, 366);
        frame.getContentPane().add(scrollPane);

        String[] columns = { "Lista de Grupos" };
        Object[][] data = new String[cu.readOne(cu.getUsername()).getGroups().size()][columns.length];

        for (int i = 0; i < cu.readOne(cu.getUsername()).getGroups().size(); i++) {
            String[] groups = { cu.readOne(cu.getUsername()).getGroups().get(i).getName() };
            data[i] = groups;
        }

        table = new JTable(data, columns);
        scrollPane.setViewportView(table);

        btnAddExpense = new JButton("Adicionar despesa");
        btnAddExpense.setBounds(34, 406, 190, 25);
        frame.getContentPane().add(btnAddExpense);

        btnCreateExpense = new JButton("Criar despesa");
        btnCreateExpense.setBounds(549, 231, 139, 36);
        frame.getContentPane().add(btnCreateExpense);

        txtDate = new JTextField();
        txtDate.setBounds(539, 200, 150, 19);
        frame.getContentPane().add(txtDate);
        txtDate.setColumns(10);

        txtValue = new JTextField();
        txtValue.setBounds(539, 150, 150, 19);
        frame.getContentPane().add(txtValue);
        txtValue.setColumns(10);

        txtName = new JTextField();
        txtName.setBounds(539, 100, 150, 19);
        frame.getContentPane().add(txtName);
        txtName.setColumns(10);

        btnCreateExpense.addActionListener(
                new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        String name = txtName.getText();
                        
                        Double value = Double.parseDouble(txtValue.getText());
                        String date = txtDate.getText();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
                        try{
                            Date formatDate = formato.parse(date);
                            Group group = cu.readOne(cu.getUsername()).getGroups().get(table.getSelectedRow());
                            ce.createExpense(group, formatDate, value, name);
                        } catch(java.text.ParseException err) {
                            return;
                        }



                    }
                });

        /*
         * btnAddExpense.addActionListener(
         * new ActionListener() {
         * public void actionPerformed(java.awt.event.ActionEvent evt) {
         * if (table.getSelectedRow() > -1) {
         * Group selectedGroup =
         * cu.readOne(cu.getUsername()).getFriends().get(table.getSelectedRow());
         * User lider = cu.readOne(cu.getUsername());
         * 
         * cg.addMember(selectedFriend, lider);
         * //get(0) pq só tem um grupo
         * 
         * } else {
         * JOptionPane.showMessageDialog(null, "Selecione um amigo para criar um");
         * 
         * }
         * }
         * }
         * );
         */

        lblDate = new JLabel("data:");
        lblDate.setBounds(546, 180, 70, 15);
        frame.getContentPane().add(lblDate);

        lblValue = new JLabel("Valor:");
        lblValue.setBounds(549, 130, 70, 15);
        frame.getContentPane().add(lblValue);

        lblName = new JLabel("nome:");
        lblName.setBounds(546, 80, 70, 15);
        frame.getContentPane().add(lblName);

        background = new JLabel("");
        background.setBounds(0, -15, 800, 480);
        background.setIcon(new ImageIcon(ViewAddExpense.class.getResource("/images/exalta.jpg")));
        frame.getContentPane().add(background);

    }

    public JFrame getAddExpense() {
        return frame;
    }
}
