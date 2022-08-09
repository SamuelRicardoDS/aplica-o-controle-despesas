package controller;
/* 
public class ControlRegister(username,password,confirmPass)
{
    public Executavel executavel = new Executavel();

    public void register(username, password, confirmPass) {
        
        if (username.equals("") || password.equals("") || confirmPass.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else if (!password.equals(confirmPass)) {
            JOptionPane.showMessageDialog(null, "As senhas não conferem");
        } else {
            User user = new User(username, password);
            user.addUser();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
        }
    }
    
} */

import data.Database;
import model.User;

public class ControlUser {

    private Database database;

    public ControlUser(Database database) {
        this.database = database;
    }

    public void Create(String username, String password) {
        if(username == null || password == null) {
            System.out.println("Preencha todos os campos");
        } else {
            User user = new User(username, password);
            database.addUser(user);
            System.out.println("Usuário cadastrado com sucesso");
        }
        
    }

    public User ReadOne(String username) {
        return this.database.getUser(username);
    }

    public Boolean ControlLogin(String username, String password) {
        Boolean isValidUser = false;

        for (User user : this.database.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isValidUser = true;
            }
        }

        return isValidUser;
    }

    
}
