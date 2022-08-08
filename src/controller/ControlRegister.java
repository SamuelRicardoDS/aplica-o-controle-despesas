package controller;

public class ControlRegister(username, password, confirmPass) {
    
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
    
}

