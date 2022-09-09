package view;

import controller.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
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
    private JScrollPane tabela_1;
    private JScrollPane tabela_2;

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

        textField = new JTextField();
        textField.setBounds(330, 50, 170, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        tabela_1 = new JScrollPane();
        tabela_1.setBounds(548, 34, 208, 142);
        frame.getContentPane().add(tabela_1);

        tabela_2 = new JScrollPane();
        tabela_2.setBounds(548, 228, 208, 142);
        frame.getContentPane().add(tabela_2);

        btnRemoveMembers = new JButton("Remover Membros");
        btnRemoveMembers.setBounds(558, 190, 198, 26);
        frame.getContentPane().add(btnRemoveMembers);

        addNewMembers = new JButton("Adicionar membros");
        addNewMembers.setBounds(558, 382, 198, 26);
        frame.getContentPane().add(addNewMembers);

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

        background = new JLabel("");
        background.setBounds(0, 0, 800, 480);
        frame.getContentPane().add(background);
        background.setIcon(new ImageIcon(ViewUpdateGroup.class.getResource("/images/pagode.jpg")));
    }

    public JFrame getUpdateGroup() {
        return frame;
    }
}
