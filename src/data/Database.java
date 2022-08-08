package data;

import model.User;

public class Database {
	
	//private String[] groups = new String[100];
	
	User users = new Users();
	
	private String[] users = new String[200];
	
	
	private int proximaPosicao() {
		int size = users.length;
		for (int i = 0 ; i < size ; i++) {
			if (users[i] == null) {
				return i;
			}
		}
		return size;
	}
//acho que tudo aqui ta errado
	public String registerUsers(String user) {
		int proximaPosicao = proximaPosicao();
		if (proximaPosicao < users.length) {
			users[proximaPosicao] = user;
			return "user insert";
		} else {
			return "database full";
		}	
	}
	
}
