package controller;

import data.Database;
import model.Group;
import model.User;

/**
 * classe para controlar e manipular os objetos do tipo Group.
 * @author Samuel Ricardo
 * @since release 1
 */
public class ControlGroup {
    private Database database;
    public ControlUser cu;

    /**
     * Construtor da classe ControlGroup
     */
    public ControlGroup() {
        this.database = Database.getInstance();
        this.cu = new ControlUser();
    }

    /**
     * Método para criar um grupo e adiciona-lo na lista de grupos de seu lider
     * @param name nome do grupo
     * @param lider lider do grupo
     */
    public void createGroup(String name, User lider) {
        if (name == null || lider == null) {
            System.out.println("Preencha todos os campos");
        } else {
            Group group = new Group(null, name, lider, null);
            lider.getGroups().add(group);
            System.out.println("Grupo cadastrado com sucesso");
        }
    }

    /**
     * Método para listar um grupo pelo nome.
     * @param name nome do grupo
     * @return group
     */
    public Group readGroup(String name) {
        return this.database.getGroup(name);
    }

    /**
     * Método para atualizar um grupo
     * @param group grupo a ser atualizado
     * @param inputGroup grupo atualizado
     * 
     */
    public void updateGroup(Group group, Group inputGroup) {
        for (int i = 0; i < database.getGroups().size(); i++) {
            if (database.getGroups().get(i).getName().equals(group.getName())) {
                database.getGroups().set(i, inputGroup);
            }
        }
    }

    /**
     * Método para deletar um grupo
     * @param group grupo a ser deletado
     */
    public void deleteGroup(Group group) {
        database.getGroups().remove(group);
    }

    /**
     * Método para adicionar um usuário a um grupo
     * @param lider usuario que adiciona os membros
     * @param selectedFriend usuário a ser adicionado ao grupo
     */
    public void addMember( User selectedFriend, User lider) {
        int lastIdx = lider.getGroups().size() - 1;
        Group lastGroup = lider.getGroups().get(lastIdx);
        lastGroup.getMembers().add(selectedFriend);

    }

    /**
     * Método para remover um usuário de um grupo
     * @param group grupo do qual o usuário será removido
     * @param user usuario que será removido do grupo
     */
    public void removeMember(Group group, User user) {
        group.getMembers().remove(user);
    }

    public String getGroupName(Group group) {
        return group.getName();
    }

}
