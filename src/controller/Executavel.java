package controller;
import java.util.ArrayList;
import model.User;

public class Executavel {
	                             //nao é correto instanciar aqui, isso deve ser mudado para o construtor da classe
	ArrayList<String> usernames = new ArrayList<String>();
	ArrayList<String> passwords = new ArrayList<String>();
	

	// getters and setters
	public ArrayList<String> getUsernames() {
		return usernames;
	}

	public  void setUsernames(String usernames) {
		this.usernames.add(usernames);
	}

	public ArrayList<String> getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords.add(passwords);
	}

}
	
