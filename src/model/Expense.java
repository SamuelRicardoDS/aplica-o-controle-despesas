package model;

import java.util.*;

/** 
 * classe para objetos do tipo Expense, onde serão contidos, valores e métodos para o mesmo.
 * @author Samuel Ricardo
 * @since release 1 
 */
public class Expense {
  private Date date;
  private Double value;
  private String name;

  /**
   * Construtor da classe Expense
   * 
   * @param date  Data da despesa
   * @param value  Valor da despesa
   * @param name  Nome da despesa
   */
  public Expense(Date date, Double value, String name) {
    super();
    this.date = date;
    this.value = value;
    this.name = name;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
