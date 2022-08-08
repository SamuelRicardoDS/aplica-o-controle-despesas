package controller;
import java.util.ArrayList;
import model.User;

public class Executavel {
	                             //nao é correto instanciar aqui, isso deve ser mudado para o construtor da classe
	ArrayList<String> usernames = new ArrayList<String>();
	ArrayList<String> passwords = new ArrayList<String>();
	

	public static void main(String[] args) {

		User input_user = new User();

		input_user.setUsername(null);
		input_user.setPassword(null);
		
		
	}
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
	
