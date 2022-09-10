package model;

import java.util.*;

/**
 * classe para objetos do tipo usuário, onde serão contidos, valores e métodos para o mesmo.
 * @author Samuel Ricardo
 * @since release 1 */

public class User {
    private String username;
    private String password;
    private ArrayList<Group> groups;
    private ArrayList<User> friends;
    private PaymentMethod paymentMethod;

    /**
     * Construtor da classe User
     * @param username nome de usuário
     * @param password senha
     * @param groups lista de grupos
     * @param friends lista de amigos
     * @param paymentMethod método de pagamento
     */
    public User(
        String username,
        String password,
        ArrayList<Group> groups,
        ArrayList<User> friends,
        PaymentMethod paymentMethod
    ) {
        super();
        this.username = username;
        this.password = password;
        this.groups = new ArrayList<Group>();
        this.friends = new ArrayList<User>();
        this.paymentMethod = paymentMethod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
