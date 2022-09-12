package data;

import java.util.ArrayList;
import model.Group;
import model.User;


/**
 * Classe para armazenar os dados do sistema, como os usuários e grupos.
 * @author Samuel Ricardo
 * @author Gustavo Henrique
 * @since release 1
 */
public class Database {
    ArrayList<User> users;
    ArrayList<Group> groups;
    private static Database instance;

    private Database() {}

    //singleton
    /**
     * Método para criar uma instância da classe Database
     * @return instance
     * singleton
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
            instance.users = new ArrayList<User>();
            instance.groups = new ArrayList<Group>();
        }
        return instance;
    }

    public void clearDatabase() {
        instance = null;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Método para retornar um grupo a partir de seu nome
     * @param name nome do grupo
     * @return groups
     */
    public Group getGroup(String name) {
        for (Group group : groups) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    /**
     * Método para retornar um usuário a partir de seu nome
     * @param username nome do usuário
     * @return users
     */
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
