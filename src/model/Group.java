package model;

import java.util.ArrayList;

public class Group {
	private ArrayList<User> members = new ArrayList<User>();
	private String name;
	private User lider;
	private Double value;
	
	
	public Group(ArrayList<User> members, String name, User lider, Double value) {
		super();
		this.members = members;
		this.name = name;
		this.lider = lider;
		this.value = value;
	}
	
	public ArrayList<User> getmembers() {
		return members;
	}
	public void setmembers(ArrayList<User> members) {
		this.members = members;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getLider() {
		return lider;
	}
	public void setLider(User lider) {
		this.lider = lider;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	

}
