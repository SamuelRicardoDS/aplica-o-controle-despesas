package controller;

import model.Expense;
import model.Group;
import data.Database;

public class ControlExpense {
	private Group group;

	public ControlExpense(Group group) {
		this.group = group;
	}

	public void createExpense(Group group) {
		this.group.getValue().addItem();
	}

	public Expense readExpense(Group group) {
		return group.getValue();
	}

	public void updateExpense(Group inputgroup) {
		for (Group group : Database.getInstance().getGroups()) {
			if (group.getName().equals(inputgroup.getName())) {
				group.setValue(inputgroup.getValue());
			}
		}
	}

	public void deleteExpense(Group group) {
		group.setValue(null);
	}

}
