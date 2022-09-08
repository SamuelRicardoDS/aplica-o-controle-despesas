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

  /*   private Main() {
        this.instance = Database.getInstance();


    }
     public void fillData() {
        for (int i = 0; i <= 15; i++) {
            cu.create("user" + i, "123", null, null, null);
        }

        for(int i = 1; i <= 3; i++) {
            cg.createGroup("group" + i, cu.readOne("user" + i));
            
        }
     

    } */

}
