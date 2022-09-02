package model;

import java.util.Date;

public class PayPal extends PaymentMethod {
  private String cardFlag;
  private String type;

  public PayPal(Date payDate, String bank, String payer, String cardFlag, String type, Double amount) {
    super(payDate, bank, payer, amount);
    this.cardFlag = cardFlag;
    this.type = type;
  }

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
