package model;

import java.util.ArrayList;

/**
 * classe para objetos do tipo Group, onde serão contidos, valores e métodos para o mesmo.
 * @author Samuel Ricardo
 * @since release 1 
 */
public class Group {
  private ArrayList<User> members;
  private String name;
  private User lider;
  private ArrayList<Expense> expenses;

  /**
   * Construtor da classe Group
   * 
   * @param members  Membros do grupo
   * @param name  Nome do grupo
   * @param lider  Líder do grupo
   * @param expenses  Despesas do grupo
   */
  public Group(ArrayList<User> members, String name, User lider, ArrayList<Expense> expenses) {
    super();
    this.members =  new ArrayList<User>();
    this.name = name;
    this.lider = lider;
    this.expenses =  new ArrayList<>();
  }

  /**
   * Método que calcula o calor total das despesas do grupo
   * @return Double - Valor total das despesas
   */
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
