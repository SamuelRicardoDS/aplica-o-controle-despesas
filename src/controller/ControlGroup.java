package controller;

import data.Database;
import model.Group;
import model.User;

public class ControlGroup {
    private Database database;
    public ControlUser cu;

    public ControlGroup() {
        this.database = Database.getInstance();
        this.cu = new ControlUser();
    }

    public void createGroup(String name, User lider) {
        if (name == null || lider == null) {
            System.out.println("Preencha todos os campos");
        } else {
            Group group = new Group(null, name, lider, null);
            lider.getGroups().add(group);
            System.out.println("Grupo cadastrado com sucesso");
        }
    }

    public Group readGroup(String name) {
        return this.database.getGroup(name);
    }

    public void updateGroup(Group group, Group inputGroup) {
        for (int i = 0; i < database.getGroups().size(); i++) {
            if (database.getGroups().get(i).getName().equals(group.getName())) {
                database.getGroups().set(i, inputGroup);
            }
        }
    }

    public void deleteGroup(Group group) {
        database.getGroups().remove(group);
    }

    public void addMember( User selectedFriend, User lider) {
        int lastIdx = lider.getGroups().size() - 1;
        Group lastGroup = lider.getGroups().get(lastIdx);
        lastGroup.getMembers().add(selectedFriend);

    }

    public void removeMember(Group group, User user) {
        group.getMembers().remove(user);
    }

    public String getGroupName(Group group) {
        return group.getName();
    }

}
