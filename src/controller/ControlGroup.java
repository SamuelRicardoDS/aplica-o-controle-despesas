package controller;

import data.Database;
import model.Group;
import model.User;

public class ControlGroup {

    private Database database;
    public ControlUser cu = new ControlUser();

    public ControlGroup() {
        this.database = Database.getInstance();
    }

    public void createGroup(String name, User lider) {
        if (name == null || lider == null) {
            System.out.println("Preencha todos os campos");
        } else {
            Group group = new Group(null, name, lider, null);
            database.addGroup(group);
            System.out.println("Grupo cadastrado com sucesso");
        }
    }

    public Group readGroup(Group group) {
        return database.getGroup(group);
    }

    public void updateGroup(Group inputGroup) {
        for (int i = 0; i < database.getGroups().size(); i++) {
            if (database.getGroups().get(i).getName().equals(inputGroup.getName())) {
                database.getGroups().set(i, inputGroup);
            }
        }
    }

    public void deleteGroup(Group group) {
        database.getGroups().remove(group);
    }

    public void addMember(User SelectedFriend, Group group) {
        	int lastIdx = database.getGroups().size() - 1;
        	Group lastGroup = database.getGroups().get(lastIdx);
        	lastGroup.getMembers().add(SelectedFriend);                  
    }

    public String getGroupName(Group group) {
        return group.getName();
    }

}
