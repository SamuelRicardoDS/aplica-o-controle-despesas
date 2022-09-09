package model;

import java.util.Date;

/**
 * classe para objetos do tipo PayPal, que é uma subclasse de PaymentMethod, onde serão contidos, valores e métodos para o mesmo.
 * @author Samuel Ricardo
 * @since release 1 */
public class PayPal extends PaymentMethod {
  private String cardFlag;
  private String type;

  /**
   * Construtor da classe PayPal
   * 
   * @param cardFlag    Bandeira do cartão
   * @param type  Tipo de cartão
   */
  public PayPal(Date payDate, String bank, String payer, String cardFlag, String type, Double amount) {
    super(payDate, bank, payer, amount);
    this.cardFlag = cardFlag;
    this.type = type;
  }

  /**
   * Método que sobrescreve o calculo do método pai, acrescido de uma taxa
   * @param Group group  Grupo de usuários
   * @return Double  Valor que cada usuário deve pagar
   */
  @Override
  public Double calcSingleValue(Group group) {
    amount = 0.0;
    int integers = group.getMembers().size();
    for (int i = 0; i < integers; i++) {
      amount += group.getExpenses().get(i).getValue();
    }
    Double singleValue = amount / integers;
    return singleValue * 1.035;
  }

  public String getCardFlag() {
    return cardFlag;
  }

  public void setCardFlag(String cardFlag) {
    this.cardFlag = cardFlag;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
