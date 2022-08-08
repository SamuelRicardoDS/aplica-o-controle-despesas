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
        User user = new User(username, password);
        this.database.addUser(user);
    }

    public User ReadOne(String username) {
        return this.database.getUser(username);
    }
}
