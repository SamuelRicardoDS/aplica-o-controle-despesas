package data;

import java.util.ArrayList;
import model.Group;
import model.User;

public class Database {
    ArrayList<User> users;
    ArrayList<Group> groups;
    private static Database instance;

    private Database() {}

    //singleton
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
