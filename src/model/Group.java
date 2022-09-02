package model;

import java.util.ArrayList;

public class Group {
  private ArrayList<User> members = new ArrayList<User>();
  private String name;
  private User lider;
  private ArrayList<Expense> expenses;

  public Group(ArrayList<User> members, String name, User lider, ArrayList<Expense> expenses) {
    super();
    this.members = members;
    this.name = name;
    this.lider = lider;
    this.expenses = expenses;
  }

  public Double totalValue(ArrayList<Expense> expenses) {
    Double totalValue = 0.0;
    for (int i = 0; i < expenses.size(); i++) {
      Double itValue = expenses.get(i).getValue();
      totalValue = totalValue + itValue;
    }
    return totalValue;
  }

  public ArrayList<User> getMembers() {
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

  public ArrayList<Expense> getExpenses() {
    return expenses;
  }

  public void setExpenses(ArrayList<Expense> expenses) {
    this.expenses = expenses;
  }

  public void addExpense(Expense expense) {
    this.expenses.add(expense);
  }
}
