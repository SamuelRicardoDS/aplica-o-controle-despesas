package controller;

import java.util.ArrayList;

import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Executavel {
	                              //nao é correto instanciar aqui, isso deve ser mudado para o construtor da classe
	ArrayList<String> usernames = new ArrayList<String>();
	ArrayList<String> passwords = new ArrayList<String>();
	

	public static void main(String[] args) {

		User input_user = new User();

		input_user.setUsername(null);
		input_user.setPassword(null);
		try {
			A = Runtime.getRuntime().exec("pwd");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// getters and setters
	public ArrayList<String> getUsernames() {
		return usernames;
	}

	public void setUsernames(String usernames) {
		this.usernames.add(usernames);
	}

	public ArrayList<String> getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords.add(passwords);
	}

}
