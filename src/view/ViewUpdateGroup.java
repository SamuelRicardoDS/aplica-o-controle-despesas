package view;

import controller.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Group;

/**
 * Classe responsável pela tela de atualização de grupos.
 * @author Samuel Ricardo
 * @author Gustavo Henrique
 * @since release 1
 */

public class ViewUpdateGroup {
    private JFrame frame;
    private JLabel background;
    private JTable table;
    private ControlGroup cg;
    private ControlUser cu;
    private JTextField textField;
    private JButton buttonChangeName;
    private JLabel ChangeName;
    private JButton addNewMembers;
    private JButton btnRemoveMembers;
    private JScrollPane tabela;
    private JButton btnBack;

    public ViewUpdateGroup() {
        cu = new ControlUser();
        cg = new ControlGroup();

        frame = new JFrame();
        frame.setBounds(100, 100, 800, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        tabela = new JScrollPane();
        tabela.setBounds(30, 34, 208, 356);
        frame.getContentPane().add(tabela);

        String[] columns = { "Lista de Grupos" };
        Object[][] data = new String[cu.readOne(cu.getUsername()).getGroups().size()][columns.length];

        for (int i = 0; i < cu.readOne(cu.getUsername()).getGroups().size(); i++) {
            String[] groups = { cu.readOne(cu.getUsername()).getGroups().get(i).getName() };
            data[i] = groups;
        }

        table = new JTable(data, columns);
        tabela.setViewportView(table);
        table.setBorder(new LineBorder(new Color(0, 0, 0)));

        table
            .getSelectionModel()
            .addListSelectionListener(
                new ListSelectionListener() {

                    public void valueChanged(ListSelectionEvent event) {}
                }
            );

        textField = new JTextField();
        textField.setBounds(330, 50, 170, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnRemoveMembers = new JButton("Remover Membros");
        btnRemoveMembers.setBounds(558, 190, 198, 26);
        frame.getContentPane().add(btnRemoveMembers);

        btnRemoveMembers.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {}
            }
        );

        addNewMembers = new JButton("Adicionar membros");
        addNewMembers.setBounds(558, 382, 198, 26);
        frame.getContentPane().add(addNewMembers);

        addNewMembers.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {}
            }
        );

        ChangeName = new JLabel("Alterar Nome");
        ChangeName.setForeground(Color.WHITE);
        ChangeName.setBounds(334, 35, 166, 15);
        frame.getContentPane().add(ChangeName);

        buttonChangeName = new JButton("Alterar Nome");
        buttonChangeName.setBounds(352, 84, 136, 25);
        frame.getContentPane().add(buttonChangeName);

        buttonChangeName.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    Group selectedGroup = cu.readOne(cu.getUsername()).getGroups().get(table.getSelectedRow());
                    cg.changeGroupName(selectedGroup, textField.getText());
                    System.out.println(selectedGroup.getName());
                }
            }
        );

        btnBack = new JButton("Voltar");
        btnBack.setBounds(30, 402, 208, 25);
        frame.getContentPane().add(btnBack);

        btnBack.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            }
        );

        Object[][] amigos = new String[cu.readOne(cu.getUsername()).getFriends().size()][columns.length];

        for (int i = 0; i < cu.readOne(cu.getUsername()).getFriends().size(); i++) {
            String[] friends = { cu.readOne(cu.getUsername()).getFriends().get(i).getUsername() };
            amigos[i] = friends;
        }

        background = new JLabel("");
        background.setBounds(0, 0, 800, 480);
        frame.getContentPane().add(background);
        background.setIcon(new ImageIcon(ViewUpdateGroup.class.getResource("/images/pagode.jpg")));
    }

    public JFrame getUpdateGroup() {
        return frame;
    }
}
