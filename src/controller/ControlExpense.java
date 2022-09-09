package controller;

import data.Database;
import java.util.ArrayList;
import java.util.Date;
import model.Expense;
import model.Group;

public class ControlExpense {
  private Group group;

  public ControlExpense(Group group) {
    this.group = group;
  }

  public void createExpense(Group group, Date data, Double value, String name) {
    Expense expense = new Expense(data, value, name);
    group.addExpense(expense);
  }

  
  public ArrayList<Expense> readExpense(Group group) {
    return group.getExpenses();
  }
  
  public void updateExpense(Group inputgroup) {
    for (Group group : Database.getInstance().getGroups()) {
      if (group.getName().equals(inputgroup.getName())) {
        group.setExpenses(inputgroup.getExpenses());
      }
    }
  }
  
  public void deleteExpense(Group group, Expense expense) {
    group.getExpenses().remove(expense);
  }

  public void payExpense(Group group, Expense expense) {
    expense.setPaid(true);
  }
}
