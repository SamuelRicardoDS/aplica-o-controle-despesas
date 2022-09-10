package view;

import controller.ControlExpense;
import controller.ControlUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.*;
import model.Group;

/**
 * Essa classe é responsável por criar a interface gráfica para mostrar as despesas de um grupo.
 * 
 * @author Samuel Ricardo
 * @since release 1
 */
public class ViewShowExpenses {
    private ControlUser cu;
    private JFrame frame;
    private JLabel background;
    private JTable table;
    private ControlExpense ce;
    private JTable expensesTable;
    private JScrollPane scrollPane;
    private JButton btnPay;

    /**
     * Construtor da classe ViewShowExpenses, onde é criada a interface gráfica.
     */
    public ViewShowExpenses() {
        cu = new ControlUser();
        ce = new ControlExpense(null);

        frame = new JFrame();
        frame.setBounds(0, 0, 800, 480);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        scrollPane = new JScrollPane();
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

        btnPay = new JButton("pagar");
        btnPay.setBounds(333, 381, 117, 25);
        frame.getContentPane().add(btnPay);

        btnPay.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    ViewAddPaymentMethod v = new ViewAddPaymentMethod();
                    v.getFrame().setVisible(true);
                }
            }
        );

        JScrollPane expenseScroll = new JScrollPane();
        expenseScroll.setBounds(260, 17, 214, 366);
        frame.getContentPane().add(expenseScroll);

        String[] expenseColumns = { "Despesa", "Valor" };
        Object[][] expenseData = new String[0][expenseColumns.length];

        expensesTable = new JTable(expenseData, expenseColumns);
        expenseScroll.setViewportView(expensesTable);

        table
            .getSelectionModel()
            .addListSelectionListener(
                new ListSelectionListener() {

                    public void valueChanged(ListSelectionEvent e) {
                        int index = table.getSelectedRow();
                        Group group = cu.readOne(cu.getUsername()).getGroups().get(index == -1 ? 0 : index);

                        String[] expenseColumns = { "Despesa", "Valor" };
                        Object[][] expenseData = new String[cu
                            .readOne(cu.getUsername())
                            .getGroups()
                            .get(index)
                            .getExpenses()
                            .size()][expenseColumns.length];

                        for (
                            int i = 0;
                            i < cu.readOne(cu.getUsername()).getGroups().get(index).getExpenses().size();
                            i++
                        ) {
                            String[] expense = {
                                group.getExpenses().get(i).getName(),
                                String.valueOf(group.getExpenses().get(i).getValue()),
                            };
                            expenseData[i] = expense;
                        }

                        expensesTable = new JTable(expenseData, expenseColumns);
                        expenseScroll.setViewportView(expensesTable);
                        expensesTable.repaint();
                    }
                }
            );

        background = new JLabel("");
        background.setBounds(0, -15, 800, 480);
        background.setIcon(new ImageIcon(ViewAddExpense.class.getResource("/images/exalta.jpg")));
        frame.getContentPane().add(background);
    }

    public JFrame getShowExpenses() {
        return frame;
    }
}
