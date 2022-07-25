package aplicacao_controle_despesas;
import java.util.*;

public class User {
	
	private String username;
	private String password;
	private String[] groups;
	
	
	
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
