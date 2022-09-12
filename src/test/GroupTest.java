package test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Database;
import controller.ControlExpense;
import controller.ControlGroup;
import controller.ControlUser;
import model.Group;

import model.User;

/**
 * Classe de testes relacionados aos grupos da aplicação
 * @author Samuel Ricardo
 * @since release 1
 */

class GroupTest {
    Database instance;
    ControlGroup controlGroup;
    ControlUser controlUser;
    ControlExpense controlExpense;

    @BeforeEach 
    void setUp() {
        this.instance = Database.getInstance();
        this.controlGroup = new ControlGroup();
        this.controlUser = new ControlUser();
        this.controlExpense = new ControlExpense(controlGroup.readGroup("Group"));
        this.instance.clearDatabase();
    }

    @Test
    void createGroupTest() {
        controlUser.create("nome de usuario", "senha de usuario", null, null, null);

        controlGroup.createGroup("nome de grupo", instance.getUsers().get(0)); 
        assertEquals(1, instance.getGroups().size());
    }

   @Test
    void readGroupTest() {
        ArrayList<Group> gruposDoUsuario = new ArrayList<Group>();
        ArrayList<User> amigosDoUsuario = new ArrayList<User>();
        
        User lider = new User("nome de usuario", "senha de usuario", gruposDoUsuario, amigosDoUsuario, null);
        controlGroup.createGroup("nome de grupo", lider);
        Group grupo = controlGroup.readGroup("nome de grupo");
        Group expectedGroup = instance.getGroups().get(0);
        assertEquals(grupo, expectedGroup);
    }

    @Test
    void updateGroupTest() {
        ArrayList<Group> gruposDoUsuario = new ArrayList<Group>();
        ArrayList<User> amigosDoUsuario = new ArrayList<User>();
        User lider = new User("nome de usuario", "senha de usuario", gruposDoUsuario, amigosDoUsuario, null);
        controlGroup.createGroup("nome de grupo", lider);

        Group grupo = new Group(null, "nome de grupo", lider, null);
        Group grupoAtualizado = new Group(null, "nome de grupo atualizado", lider, null);
        controlGroup.updateGroup(grupo, grupoAtualizado);
        assertEquals("nome de grupo atualizado", instance.getGroups().get(0).getName());
    }

    @Test
    void deleteGroupTest() {
        ArrayList<Group> gruposDoUsuario = new ArrayList<Group>();
        ArrayList<User> amigosDoUsuario = new ArrayList<User>();
        User lider = new User("nome de usuario", "senha de usuario", gruposDoUsuario, amigosDoUsuario, null);
        controlGroup.createGroup("nome de grupo", lider);

        Group grupo = instance.getGroups().get(0);
        controlGroup.deleteGroup(lider, grupo);
        assertEquals(0, instance.getGroups().size());
    }

    @Test
	void addMemberTest(){
		controlUser.create("nome de usuario", "senha de usuario", null, null, null);
		controlUser.create("nome de usuario 2", "senha de usuario 2", null, null, null);
        
        controlGroup.createGroup("nome de grupo", instance.getUsers().get(0));
        controlGroup.addMember(instance.getUsers().get(1), instance.getUsers().get(0));
		
		assertEquals(1, instance.getUsers().get(0).getGroups().get(0).getMembers().size());
	}

    @Test
    void removeMemberTest(){
        controlUser.create("nome de usuario", "senha de usuario", null, null, null);
        controlUser.create("nome de usuario 2", "senha de usuario 2", null, null, null);

        controlGroup.createGroup("nome de grupo", instance.getUsers().get(0));
        Group group = instance.getGroups().get(0);
        controlGroup.addMember(instance.getUsers().get(1), instance.getUsers().get(0));
        controlGroup.removeMember(group, instance.getUsers().get(1));

    }

    @Test
    void createExpenseTest() {
        controlUser.create("nome de usuario", "senha de usuario", null, null, null);
        controlUser.create("nome de usuario 2", "senha de usuario 2", null, null, null);

        controlGroup.createGroup("nome de grupo", instance.getUsers().get(0));
        Group group = instance.getGroups().get(0);
        controlGroup.addMember(instance.getUsers().get(1), instance.getUsers().get(0));
        Date date = new Date();
        controlExpense.createExpense(group, date, 1000.00, "amendoim");
        assertEquals(1, instance.getGroups().get(0).getExpenses().size());
    }

}
