package model;
import java.util.Date;

public class PayPal extends PaymentMethod {
  private String cardFlag;
  private String type;
  
  public PayPal(Date payDate, String bank, String payer, String cardFlag, String type) {
    super(payDate, bank, payer);
    this.cardFlag = cardFlag;
    this.type = type;
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

