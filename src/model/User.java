package model;

import view.ViewRegister;
import java.util.*;

import javax.swing.JOptionPane;

public class User {

	private String username = new username();
	private String password;
	private String[] groups;

	// aqui ja nn ta mais

	public String[] getGroups() {
		return groups;
	}

	public void setGroups(String[] groups) {
		this.groups = groups;
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

}
