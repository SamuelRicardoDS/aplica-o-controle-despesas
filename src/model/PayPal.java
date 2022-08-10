package model;

import java.util.Date;

public class PayPal extends PaymentMethod {


  public Paypal(Date payDate, String bank, String payer) {
    super(payDate, bank, payer);
  }
  private String cardFlag;
  private String option;

}

