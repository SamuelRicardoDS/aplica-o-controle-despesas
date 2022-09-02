package controller;

import model.Expense;
import model.Group;

import java.util.ArrayList;
import java.util.Date;

import data.Database;

public class ControlExpense {
	private Group group;

	public ControlExpense(Group group) {
		this.group = group;
	}

	public void createExpense(Date date, Double value, String name, Group group) {
		Expense expense = new Expense(date, value, name);
		this.group.getExpenses().add(expense);
	}
	
	public ArrayList<Expense> readExpenses(Group group) {
		return group.getExpenses();
	}
	
	public void updateExpense(Group inputgroup) {
		for (Group group : Database.getInstance().getGroups()) {
			if (group.getName().equals(inputgroup.getName())) {
				group.setExpenses(inputgroup.getExpenses());
			}
		}
	}
	
	public void deleteExpense(Group group) {
		group.setExpenses(null);
	}

}
