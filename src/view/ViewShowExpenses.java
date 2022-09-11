package view;

import controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.*;
import model.*;

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
    private ControlGroup cg;
    private JTable expensesTable;
    private JScrollPane scrollPane;
    private JButton btnPay;
    private JScrollPane expenseScroll;
    private JLabel howMuchUOwe;

    class ViewAddPaymentMethod {
        private JFrame frame;
        private JButton btnPix;
        private JButton btnBoleto;
        private JButton btnPaypal;
        private JLabel background;

        private ControlUser cu;
        private ControlPayment cp;
        private ControlGroup cg;

        public ViewAddPaymentMethod() {
            cu = new ControlUser();
            cp = new ControlPayment(cu.readOne(cu.getUsername()));
            cg = new ControlGroup();

            frame = new JFrame();
            frame.setBounds(0, 0, 450, 300);
            frame.getContentPane().setLayout(null);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            JLabel lblNewLabel = new JLabel("Forma de Pagamento");
            lblNewLabel.setBounds(140, 45, 155, 15);

            frame.getContentPane().add(lblNewLabel);

            btnPix = new JButton("Pix");
            btnPix.setBounds(22, 149, 117, 25);
            frame.getContentPane().add(btnPix);

            btnPix.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        cp.createPayment("pix", cu.readOne(cu.getUsername()));
                        divideExpense();
                    }
                }
            );

            btnBoleto = new JButton("Boleto");
            btnBoleto.setBounds(162, 149, 117, 25);
            frame.getContentPane().add(btnBoleto);

            btnBoleto.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        cp.createPayment("boleto", cu.readOne(cu.getUsername()));
                        frame.dispose();
                    }
                }
            );

            btnPaypal = new JButton("PayPal");
            btnPaypal.setBounds(300, 149, 117, 25);
            frame.getContentPane().add(btnPaypal);

            btnPaypal.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        cp.createPayment("paypal", cu.readOne(cu.getUsername()));
                        frame.dispose();
                    }
                }
            );

            background = new JLabel(new ImageIcon("/images/gustavo.jpg"));
            background.setBounds(0, 0, 450, 300);
            frame.getContentPane().add(background);
        }

        public JFrame getFrame() {
            return frame;
        }
    }

    public void divideExpense() {
        int selectedRow = expensesTable.getSelectedRow();
        Expense selectedExpense = cu.readOne(cu.getUsername()).getGroups().get(0).getExpenses().get(selectedRow);
        double doube = cu.readOne(cu.getUsername()).getGroups().get(0).getExpenses().get(selectedRow).getValue();
        int index = table.getSelectedRow();

        double value =
            selectedExpense.getValue() / 1 + cu.readOne(cu.getUsername()).getGroups().get(index).getMembers().size();

        double individualExpense = doube - value;

        Group group = cu.readOne(cu.getUsername()).getGroups().get(index == -1 ? 0 : index);
        String[] expenseColumns = { "Despesa", "Valor", "Pago" };
        Object[][] expenseData = new String[cu
            .readOne(cu.getUsername())
            .getGroups()
            .get(index)
            .getExpenses()
            .size()][expenseColumns.length];

        for (int i = 0; i < cu.readOne(cu.getUsername()).getGroups().get(index).getExpenses().size(); i++) {
            String[] expense = {
                group.getExpenses().get(i).getName(),
                String.valueOf(group.getExpenses().get(i).getValue()),
                individualExpense + "",
            };
            expenseData[i] = expense;
        }

        expensesTable = new JTable(expenseData, expenseColumns);
        expensesTable.repaint();
    }

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

        howMuchUOwe = new JLabel("Quanto você deve:" + cu.howMuchUOwe(cu.readOne(cu.getUsername())));
        howMuchUOwe.setBounds(550, 12, 189, 27);
        frame.getContentPane().add(howMuchUOwe);

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
