package model;
import java.util.Date;

public class Boleto extends PaymentMethod{
  
  private Date paydate;
  private int code;
  private Date expirationDate;
  private String payer;

    public Boleto(Date payDate, String bank, String payer) {
      super(payDate, bank, payer);
    }
}
