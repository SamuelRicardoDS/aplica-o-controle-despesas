package model;
import java.util.Date;

public class PayPal extends PaymentMethod {
  private Date payDate;
  private String bank;
  private String payer;
  
  public PayPal(Date payDate, String bank, String payer) {
    super(payDate, bank, payer);
  }
}

