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
}

