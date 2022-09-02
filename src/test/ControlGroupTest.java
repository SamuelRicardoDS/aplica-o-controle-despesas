package test;

import static org.junit.jupiter.api.Assertions.*;


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
        User lider = new User("nome de usuario", "senha de usuario", gruposDoUsuario, amigosDoUsuario, null);

        controlGroup.createGroup("nome de grupo", lider); 
        assertEquals(1, instance.getGroups().size());
    }

  /*  @Test
    void readGroupTest() {
        ArrayList<Group> gruposDoUsuario = new ArrayList<Group>();
        ArrayList<User> amigosDoUsuario = new ArrayList<User>();
        
        User lider = new User("nome de usuario", "senha de usuario", gruposDoUsuario, amigosDoUsuario);
        controlGroup.createGroup("nome de grupo", lider);

        Group grupo = new Group(null, "nome de grupo", lider, null);
        assertEquals(grupo, controlGroup.readGroup(grupo));
    } */

    @Test
    void addMemberTest() {
        ArrayList<Group> gruposDoUsuario = new ArrayList<Group>();
        ArrayList<User> amigosDoUsuario = new ArrayList<User>();
        User lider = new User("nome de usuario", "senha de usuario", gruposDoUsuario, amigosDoUsuario, null);

        controlGroup.createGroup("nome de grupo", lider);

        Group grupo = new Group(null, "nome de grupo", lider, null);
        User membro = new User("nome de usuario", "senha de usuario", gruposDoUsuario, amigosDoUsuario, null);
        
        controlGroup.addMember(membro, grupo);
        assertEquals(1, grupo.getMembers().size());
    }

}
