package data;

import java.util.ArrayList;
import model.User;

public class Database {
    ArrayList<User> users;
    private static Database instance;

	
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
            instance.users = new ArrayList<User>();
        }
        return instance;
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
	
}

/* 
 * View -> Usuaŕio clica em um botão de entrar, passando nome e senha -> ControlUser -> Controller acessa a database e faz o que ele quiser com os dados.
 */
