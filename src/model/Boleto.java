package model;
import java.util.Date;

public class Boleto extends PaymentMethod{

    public Boleto(Date payDate, String bank, String payer) {
      super(payDate, bank, payer);
    }
    private int code;
    private Date expirationDate;
}
