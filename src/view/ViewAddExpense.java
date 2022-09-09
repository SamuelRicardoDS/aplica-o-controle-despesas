package view;

import controller.ControlUser;
import model.Group;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

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


    public ViewAddExpense() {
        cu = new ControlUser();

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
        btnAddExpense.setBounds(70, 406, 190, 25);
        frame.getContentPane().add(btnAddExpense);
        
        btnCreateExpense = new JButton("Criar despesa");
        btnCreateExpense.setBounds(501, 248, 199, 65);
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
                }
            }
        );

        /*         btnAddExpense.addActionListener(
            new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (table.getSelectedRow() > -1) {
                        Group selectedGroup = cu.readOne(cu.getUsername()).getFriends().get(table.getSelectedRow());
                        User lider = cu.readOne(cu.getUsername());

                        cg.addMember(selectedFriend, lider);
                        //get(0) pq só tem um grupo
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione um amigo para criar um");
                        
                    }
                }
            }
        ); */
        

        background = new JLabel("");
        background.setBounds(50, 0, 800, 480);
        background.setIcon(new ImageIcon(ViewAddExpense.class.getResource("/images/exalta.jpg")));
        frame.getContentPane().add(background);
    }
        

    
    
    public JFrame getAddExpense() {
        return frame;
    }
}
