package test;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Database;
import controller.ControlGroup;
import model.Group;
import model.User;

class ControlGroupTest {
    Database instance;
    ControlGroup controlGroup;

    @BeforeEach 
    void setUp() {
        this.instance = Database.getInstance();
        this.controlGroup = new ControlGroup();
        this.instance.clearDatabase();
    }

    @Test
    void createGroupTest() {
        ArrayList<Group> gruposDoUsuario = new ArrayList<Group>();
        ArrayList<User> amigosDoUsuario = new ArrayList<User>();
        User lider = new User("nome de usuario", "senha de usuario", gruposDoUsuario, amigosDoUsuario);

        controlGroup.createGroup("nome de grupo", lider); 
        assertEquals(1, instance.getGroups().size());
    }

}
