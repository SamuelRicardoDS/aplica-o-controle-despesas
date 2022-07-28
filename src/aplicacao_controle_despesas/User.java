package aplicacao_controle_despesas;
import java.util.*;

import javax.swing.JOptionPane;

public class User {
	
	private String username;
	private String password;
	private String[] groups;
	
	
	
	public boolean checkregister(String username, String password) {
		return username.equals(username) && password.equals(password);
	}
	
	//se pa ta errado, mas talvez nem esteja
	
	public void actioncheck() {
		
	if(checkregister(txtUser.getUsername(), new String(txtPassword.getPassword()))) {
		
		JOptionPane.showMessageDialog(null, "Bem vindo!");
		
	}else {
		JOptionPane.showMessageDialog(null, "login incorreto");

	} }
	
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
