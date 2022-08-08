package model;

import view.ViewRegister;
import java.util.*;

import javax.swing.JOptionPane;

public class User {

	private String username;
	private String password;
	private ArrayList<String> groups;

	
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
	public ArrayList<String> getGroups() {
		return groups;
	}
	public void setGroups(ArrayList<String> groups) {
		this.groups = groups;
	}


}
