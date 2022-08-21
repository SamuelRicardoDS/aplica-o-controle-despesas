package data;

import java.util.ArrayList;
import model.User;
import model.Group;

public class Database {
    ArrayList<User> users;
    ArrayList<Group> groups;
    private static Database instance;

    private Database() {
    }

	
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
            instance.users = new ArrayList<User>();
            instance.groups = new ArrayList<Group>();
        }
        return instance;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public Group getGroup(String name) {
        for (Group group : groups) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }

	public void addUser(User user) {
        users.add(user);
    }

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


    public ArrayList<Group> getGroups() {
        return groups;
    }
	
}

/* 
 * View -> Usuaŕio clica em um botão de entrar, passando nome e senha -> ControlUser -> Controller acessa a database e faz o que ele quiser com os dados.
 */
