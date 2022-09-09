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

public class ViewShowExpenses {
    private ControlUser cu;
    private JFrame frame;
    private JLabel background;
    private JTable table;
    private ControlExpense ce;
    private JTable expensesTable;

    public ViewShowExpenses() {
        cu = new ControlUser();
        ce = new ControlExpense(null);

        frame = new JFrame();
        frame.setBounds(0, 0, 800, 480);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 17, 214, 366);
        frame.getContentPane().add(scrollPane);

        String[] columns = { "Lista de Grupos" };
        Object[][] data = new String[cu.readOne(cu.getUsername()).getGroups().size()][columns.length];

        for (int i = 0; i < cu.readOne(cu.getUsername()).getGroups().size(); i++) {
            String[] groups = { cu.readOne(cu.getUsername()).getGroups().get(i).getName() };
            data[i] = groups;
        }

        table = new JTable(data, columns);
        scrollPane.setViewportView(table);

        JLabel lblQuantoVocDeve = new JLabel("Quanto você deve:");
        lblQuantoVocDeve.setBounds(550, 12, 189, 27);
        frame.getContentPane().add(lblQuantoVocDeve);
        
        JButton btnNewButton = new JButton("Selecionar Grupo");
        btnNewButton.setBounds(67, 381, 156, 25);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("pagar");
        btnNewButton_1.setBounds(333, 381, 117, 25);
        frame.getContentPane().add(btnNewButton_1);

        JScrollPane expenseScroll = new JScrollPane();
        expenseScroll.setBounds(260, 17, 214, 366);
        frame.getContentPane().add(expenseScroll);

        String[] expenseColumns = { "Despesas do grupo" };
        Object[][] expenseData = new String[cu.readOne(cu.getUsername()).getGroups().size()][columns.length];

        for (int i = 0; i < cu.readOne(cu.getUsername()).getGroups().size(); i++) {
            String[] groups = { cu.readOne(cu.getUsername()).getGroups().get(i).getName() };
            data[i] = groups;
        }

        expensesTable = new JTable(expenseData, expenseColumns);
        expenseScroll.setViewportView(expensesTable);

        background = new JLabel("");
        background.setBounds(0, -15, 800, 480);
        background.setIcon(new ImageIcon(ViewAddExpense.class.getResource("/images/exalta.jpg")));
        frame.getContentPane().add(background);


        

    }

    public JFrame getShowExpenses() {
        return frame;
    }
}

