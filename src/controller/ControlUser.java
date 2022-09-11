package controller;

import java.util.ArrayList;

import data.Database;
import model.Group;
import model.PaymentMethod;
import model.User;

/**
 * classe de controle para usuario
 * @author Samuel Ricardo
 * @since release 1
 */
public class ControlUser {

    private Database database;
    private static String username;

    public ControlUser() {
        this.database = Database.getInstance();
    }

    public User create(String username, String password, ArrayList<Group> groups, ArrayList<User> friends,
            PaymentMethod paymentMethod) {
        if (username == null || password == null) {
            System.out.println("Preencha todos os campos");
            throw new IllegalArgumentException("Preencha todos os campos");
        } else {
            User user = new User(username, password, groups, friends, paymentMethod);
            database.addUser(user);
            System.out.println("Usuário cadastrado com sucesso");
            return user;
        }
    }

    public User readOne(String username) {
        return this.database.getUser(username);
    }

    public void update(User currentUser, User inputUser) {
        for (int i = 0; i < database.getUsers().size(); i++) {
            if (database.getUsers().get(i).getUsername().equals(currentUser.getUsername())) {
                database.getUsers().set(i, inputUser);
                ControlUser.username = inputUser.getUsername();
            }
        }
    }

    public void delete(User user) {
        database.getUsers().remove(user);
    }

    public Boolean controlLogin(String username, String password) {
        Boolean isValidUser = false;

        for (User user : this.database.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isValidUser = true;
                ControlUser.username = username;
            }
        }
        return isValidUser;
    }

    public Boolean verifyFriend(String username) {
        Boolean isValidFriend = false;
        for (User user : this.database.getUsers()) {
            if (user.getUsername().equals(username)) {
                isValidFriend = true;
            }
        }
        return isValidFriend;
    }

    public String getUsername() {
        return username;
    }

    public void addFriend(String friend, User user) {
        user.getFriends().add(this.readOne(friend));
        readOne(friend).getFriends().add(user);
    }
    // public String definePassword

    /*
     * public Double calculateTotalValue() {
     * Double totalValue = 0.0;
     * for (User user : this.database.getUsers()) {
     * for(int i=0; i<user.getGroups().size(); i++) {
     * totalValue += user.getGroups().get(i).calcSingleValue();
     * }
     * }
     * return totalValue;
     * }
     */

    public ArrayList<User> readAll() {
        return this.database.getUsers();
    }

    public Boolean RLider(Group group, User user) {
        Boolean isLider = false;
        if (group.getLider().getUsername().equals(user.getUsername())) {
            isLider = true;
        }
        return isLider;
    }

    public Double howMuchUOwe(User user) {
        Double owe = 0.0;
        for (Group group : user.getGroups()) {
            if (RLider(group, user) == true) {
                owe = 0.0;
            } else {
                Double amount = group.totalValue(group.getExpenses());
                int integers = group.getMembers().size();
                owe += amount / (1 + integers);
            }
        }
        return owe;
    }

}
