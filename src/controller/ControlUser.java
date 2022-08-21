package controller;

import java.util.ArrayList;

import data.Database;
import model.User;

public class ControlUser {

    private Database database;

    public ControlUser(Database database) {
        this.database = Database.getInstance();
    }

    public void create(String username, String password) {
        if(username == null || password == null) {
            System.out.println("Preencha todos os campos");
        } else {
            User user = new User(username, password);
            database.addUser(user);
            System.out.println("Usuário cadastrado com sucesso");
        }
       // System.out.println(Database.getUsers());
    }

    public void delete(User user) {
        database.getUsers().remove(user);
    }
        
        

    public User readOne(String username) {
        return this.database.getUser(username);
    }

    public Boolean controlLogin(String username, String password) {
        Boolean isValidUser = false;

        for (User user : this.database.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isValidUser = true;
            }
        }
       // System.out.println(Database.getUsers());
        return isValidUser;
    }

    //public String definePassword
    
    public ArrayList<User> readAll() {
        return this.database.getUsers();
    }
    
}
