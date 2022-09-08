package main;

import view.*;
import data.Database;
import controller.ControlUser;
import controller.ControlGroup;

public class Main {
    private Database instance;
    private ControlUser cu;
    private ControlGroup cg;

    public static void main(String[] args) {
        ViewFirstScreen window = new ViewFirstScreen();
        window.getOriginFrame().setVisible(true);
    }

    private Main() {
        this.instance = Database.getInstance();
    }

     public void fillData() {
        //cria 15 usuarios
        for (int i = 0; i < 15; i++) {
            cu.create("user" + i, "123", null, null, null);
        }
        //cria 3 grupos
        for(int i = 0; i <= 2; i++) {
            cg.createGroup("group" + i, cu.readOne("user" + i));
        }
        //adiciona 4 no grupo do user0
        for(int i = 3; i <= 6; i++) {
            cg.addMember(cu.readOne("user" + i), cu.readOne("user0"));
        }


        //adiciona 4 no grupo do user1
        for(int i = 7; i <= 10; i++) {
            cg.addMember(cu.readOne("user" + i), cu.readOne("user1"));
        }

        //adiciona 4 no grupo do user2
        for(int i = 11; i <= 14; i++) {
            cg.addMember(cu.readOne("user" + i), cu.readOne("user2"));
        }
        


     

    }

}
