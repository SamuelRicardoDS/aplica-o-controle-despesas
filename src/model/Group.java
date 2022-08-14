package model;

import java.util.ArrayList;

public class Group {
	private ArrayList<String> members = new ArrayList<String>();
	private String name;
	private String lider;
	private Double value;
	
	
	public Group(ArrayList<String> members, String name, String lider, Double value) {
		super();
		this.members = members;
		this.name = name;
		this.lider = lider;
		this.value = value;
	}
	
	public ArrayList<String> getmembers() {
		return members;
	}
	public void setmembers(ArrayList<String> members) {
		this.members = members;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLider() {
		return lider;
	}
	public void setLider(String lider) {
		this.lider = lider;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	

}
