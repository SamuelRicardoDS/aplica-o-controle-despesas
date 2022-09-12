package view;

import controller.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
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
    private JTable membros;
    private JScrollPane scrollPane_1;
    private JTable friends;
    private JScrollPane scrollPane_2;
    private JButton btnDeleteGroup;

    private void UpdateMembersTable() {
        int selectedRow = table.getSelectedRow();
        Group selectedGroup = cu.readOne(cu.getUsername()).getGroups().get(selectedRow == -1 ? 0 : selectedRow);

        String[] columns1 = { "Membros do Grupo" };

        Object[][] data1 = new String[cu
            .readOne(cu.getUsername())
            .getGroups()
            .get(selectedRow)
            .getMembers()
            .size()][columns1.length];

        for (int i = 0; i < selectedGroup.getMembers().size(); i++) {
            String[] members = { selectedGroup.getMembers().get(i).getUsername() };
            data1[i] = members;
        }
        membros = new JTable(data1, columns1);
        scrollPane_1.setViewportView(membros);
        membros.repaint();
    }
    /**
     * Construtor da classe ViewUpdateGroup, onde é criada a interface gráfica.
     */
    public ViewUpdateGroup() {
        cu = new ControlUser();
        cg = new ControlGroup();

        frame = new JFrame();
        frame.setBounds(100, 100, 800, 480);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        tabela = new JScrollPane();
        tabela.setBounds(30, 0, 208, 356);
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

                    public void valueChanged(ListSelectionEvent event) {
                        UpdateMembersTable();
                    }
                }
            );

        textField = new JTextField();
        textField.setBounds(330, 88, 170, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnRemoveMembers = new JButton("Remover Membros");
        btnRemoveMembers.setBounds(558, 364, 198, 26);
        frame.getContentPane().add(btnRemoveMembers);

        btnRemoveMembers.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = membros.getSelectedRow();
                    if (selectedIndex < 0) {
                        return;
                    }
                    cu
                        .readOne(cu.getUsername())
                        .getGroups()
                        .get(table.getSelectedRow())
                        .getMembers()
                        .remove(membros.getSelectedRow());
                    UpdateMembersTable();
                }
            }
        );

        addNewMembers = new JButton("Adicionar membros");
        addNewMembers.setBounds(558, 401, 198, 26);
        frame.getContentPane().add(addNewMembers);

        addNewMembers.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    int friendIndex = friends.getSelectedRow();
                    if (friendIndex < 0) {
                        return;
                    }

                    cu
                        .readOne(cu.getUsername())
                        .getGroups()
                        .get(table.getSelectedRow())
                        .getMembers()
                        .add(cu.readOne(cu.getUsername()).getFriends().get(friendIndex));
                    UpdateMembersTable();
                }
            }
        );

        ChangeName = new JLabel("Alterar Nome");
        ChangeName.setForeground(Color.WHITE);
        ChangeName.setBounds(330, 61, 166, 15);
        frame.getContentPane().add(ChangeName);

        buttonChangeName = new JButton("Alterar Nome");
        buttonChangeName.setBounds(351, 126, 136, 25);
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

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(558, 35, 198, 317);
        frame.getContentPane().add(scrollPane_1);

        String[] columns1 = { "Membros do Grupo" };
        Object[][] data1 = new String[0][columns1.length];

        membros = new JTable(data1, columns1);
        scrollPane_1.setViewportView(membros);

        scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(334, 177, 166, 250);
        frame.getContentPane().add(scrollPane_2);

        String[] column_3 = { "Lista de Amigos" };
        Object[][] data_3 = new String[cu.readOne(cu.getUsername()).getFriends().size()][column_3.length];

        for (int i = 0; i < cu.readOne(cu.getUsername()).getFriends().size(); i++) {
            String[] friends = { cu.readOne(cu.getUsername()).getFriends().get(i).getUsername() };
            data_3[i] = friends;
        }

        friends = new JTable(data_3, column_3);
        scrollPane_2.setViewportView(friends);
        
        btnDeleteGroup = new JButton("Deletar este grupo");
        btnDeleteGroup.setBounds(30, 368, 208, 25);
        frame.getContentPane().add(btnDeleteGroup);

        btnDeleteGroup.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Group group = cu.readOne(cu.getUsername()).getGroups().get(table.getSelectedRow());
                    cg.deleteGroup(cu.readOne(cu.getUsername()), group);
                    frame.repaint();
                    
                }
            }
        );

        background = new JLabel("");
        background.setBounds(0, 0, 800, 480);
        frame.getContentPane().add(background);
        background.setIcon(new ImageIcon(ViewUpdateGroup.class.getResource("/images/pagode.jpg")));
    }

    public JFrame getUpdateGroup() {
        return frame;
    }
}
