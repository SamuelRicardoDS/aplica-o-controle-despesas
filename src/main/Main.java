package main;

import java.util.ArrayList;
import java.util.Date;

import controller.ControlGroup;
import controller.ControlUser;
import data.Database;
import model.Group;
import model.PaymentMethod;
import model.User;
import view.*;

/**
 * Classe principal do projeto, esta que executa a primeira tela do programa
 * e preenche a base de dados.
 * @author Samuel Ricardo
 * @since release 1
 */
public class Main {
    private Database instance;
    private ControlUser cu;
    private ControlGroup cg;

    private Main() {
        this.instance = Database.getInstance();
        this.cu = new ControlUser();
        this.cg = new ControlGroup();
    }

    public void fillData() {
        //cria 15 usuarios
        // for (int i = 0; i < 15; i++) {
        //     cu.create("" + i, "", null, null, null);
        // }


        
        // //cria 3 grupos
        // for (int i = 0; i <= 2; i++) {
        //     cg.createGroup("group" + i, cu.readOne("" + i));
        // }

        // for(int i = 3; i <= 6; i++) {
        //     cu.addFriend(cu.readOne("" + i).getUsername());
        // }
        // //adiciona 4 no grupo do user0
        // for (int i = 3; i <= 6; i++) {
        //     cg.addMember(cu.readOne("" + i), cu.readOne("0"));
        // }
        // //adiciona 4 no grupo do user1
        // for (int i = 7; i <= 10; i++) {
        //     cg.addMember(cu.readOne("" + i), cu.readOne("1"));
        // }
        // //adiciona 4 no grupo do user2
        // for (int i = 11; i <= 14; i++) {
        //     cg.addMember(cu.readOne("" + i), cu.readOne("2"));
        // }

        //cria 15 usuarios
        for (int i = 0; i < 15; i++) {
            cu.create("" + i, "", new ArrayList<Group>(), new ArrayList<User>(), null);
        }
    }

    public static void main(String[] args) {
        ViewFirstScreen window = new ViewFirstScreen();
        window.getOriginFrame().setVisible(true);
        Main main = new Main();
        main.fillData();
    }
}
